package com.billing.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.billing.api.entiry.Item;
import com.billing.api.entiry.PriceBook;
import com.billing.api.exception.ResourseNotFoundException;
import com.billing.api.repository.PriceBookRepository;
import com.billing.api.service.PriceBookService;

@Service
public class PriceBookServiceImpl implements PriceBookService {

	@Autowired
	private PriceBookRepository priceBookRepository;
	
	@Override
	public PriceBook addPriceBook(PriceBook priceBook) {
		return priceBookRepository.save(priceBook);
	}

	@Override
	public PriceBook getpriceBookById(Long id) {
		return priceBookRepository.getById(id);
	}

	@Override
	public PriceBook updatePriceBook(Long id, PriceBook newPriceBook) {
		
		Optional<PriceBook> priceBook = priceBookRepository.findById(id);
		priceBook.orElseThrow(()-> new ResourseNotFoundException("PriceBook Not found "+id));
		
		priceBook.get().setPriceBookId(id);
		priceBook.get().setPriceBookName(newPriceBook.getPriceBookName());
		
		return priceBook.get();
	}

	@Override
	public boolean deletePriceBook(Long id) {

		boolean status = false;
		Optional<PriceBook> oldItem = priceBookRepository.findById(id);
		oldItem.orElseThrow(()-> new ResourseNotFoundException("Item Not Found "+id));
		
		try {
			priceBookRepository.deleteById(id);
			status = true;
	  	} catch (EmptyResultDataAccessException e) { 
	  		return false; 
	  	}
		
		return status;
	}

	@Override
	public List<PriceBook> getpriceBook() {
		return priceBookRepository.findAll();
	}
		
}
