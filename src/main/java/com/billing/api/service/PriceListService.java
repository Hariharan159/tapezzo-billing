package com.billing.api.service;

import java.util.List;
import java.util.Optional;

import com.billing.api.entiry.Item;
import com.billing.api.entiry.PriceList;

public interface PriceListService {

	public PriceList addPriceList(PriceList priceList);
	
	public PriceList getPriceListById(Long id);
	
	public List<PriceList> getPriceList();
	
	public PriceList updatePriceList(Long id, PriceList priceList);
	
	public boolean deletePriceList(Long id);

	
}
