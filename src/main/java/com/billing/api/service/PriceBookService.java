package com.billing.api.service;

import java.util.List;

import com.billing.api.entiry.Item;
import com.billing.api.entiry.PriceBook;

public interface PriceBookService {


	public PriceBook addPriceBook(PriceBook priceBook);
	
	public PriceBook getpriceBookById(Long id);
	
	public List<PriceBook> getpriceBook();
	
	public PriceBook updatePriceBook(Long id, PriceBook priceBook);
	
	public boolean deletePriceBook(Long id);
	

}
