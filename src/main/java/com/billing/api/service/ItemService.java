package com.billing.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.billing.api.entiry.Item;

public interface ItemService {

	public Item addItem(Item item);
	
	public Item getItemById(Long id);
	
	public List<Item> getItem();
	
	public Item updateItem(Long id, Item item);
	
	public boolean deleteItem(Long id);
	
}
