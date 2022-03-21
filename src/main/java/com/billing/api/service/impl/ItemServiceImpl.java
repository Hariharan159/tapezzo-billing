package com.billing.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.billing.api.entiry.Item;
import com.billing.api.exception.ResourseNotFoundException;
import com.billing.api.repository.ItemRepository;
import com.billing.api.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Item addItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public Item getItemById(Long id) {
		Optional<Item> item = itemRepository.findById(id);
		item.orElseThrow(()-> new ResourseNotFoundException("Item Not Found "+id));
		return item.get();
	}

	@Override
	public Item updateItem(Long id, Item newItem) {
		Optional<Item> oldItem = itemRepository.findById(id);
		oldItem.orElseThrow(()-> new ResourseNotFoundException("Item Not Found "+id));
		
		oldItem.get().setItemId(id);
		oldItem.get().setItemCode(newItem.getItemCode());
		oldItem.get().setItemName(newItem.getItemName());
		
		return itemRepository.save(oldItem.get());
	}

	@Override
	public boolean deleteItem(Long id) {
		
		boolean status = false;
		Optional<Item> oldItem = itemRepository.findById(id);
		oldItem.orElseThrow(()-> new ResourseNotFoundException("Item Not Found "+id));
		
		try {
			itemRepository.deleteById(id);
			status = true;
	  	} catch (EmptyResultDataAccessException e) { 
	  		return false; 
	  	}
		
		return status;
	}

	@Override
	public List<Item> getItem() {
		return itemRepository.findAll();
	}

}
