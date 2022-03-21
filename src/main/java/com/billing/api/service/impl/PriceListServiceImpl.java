package com.billing.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.billing.api.entiry.PriceList;
import com.billing.api.exception.ResourseNotFoundException;
import com.billing.api.repository.PriceListRepository;
import com.billing.api.service.PriceListService;
import com.billing.api.util.CommonUtil;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PriceListServiceImpl implements PriceListService {

	@Autowired
	private PriceListRepository priceListRepository;
	
	@Override
	public PriceList addPriceList(PriceList priceList) {
		return priceListRepository.save(priceList);
	}

	@Override
	public PriceList getPriceListById(Long id) {
		Optional<PriceList> priceList = priceListRepository.findById(id);
		priceList.orElseThrow(()-> new ResourseNotFoundException("PriceList not Found "+id));
		return priceListRepository.findById(id).get();
	}

	@Override
	public PriceList updatePriceList(Long id, PriceList newPriceList) {
		
		Optional<PriceList> oldpriceList = priceListRepository.findById(id);
		oldpriceList.orElseThrow(()-> new ResourseNotFoundException("PriceList not Exist with id : "+id));
		
		oldpriceList.get().setItem(newPriceList.getItem());
		oldpriceList.get().setPrice(newPriceList.getPrice());
		oldpriceList.get().setPriceBook(newPriceList.getPriceBook());
		oldpriceList.get().setPriceListId(id);
		/*
			PriceList priceList = new PriceList();
			priceList.setPriceListId(id);
			priceList.setItem(newPriceList.getItem());
			priceList.setPrice(newPriceList.getPrice());
			priceList.setPriceBook(newPriceList.getPriceBook());
		*/
		
		return priceListRepository.save(oldpriceList.get());
	}

	@Override
	public boolean deletePriceList(Long id) {
		
		boolean status = false;
		Optional<PriceList> oldpriceList = priceListRepository.findById(id);
		oldpriceList.orElseThrow(()-> new ResourseNotFoundException("PriceList not Exist with id : "+id));
		try {
				priceListRepository.deleteById(id);
				status = true;
		  	} catch (EmptyResultDataAccessException e) { 
		  		return false; 
		  	}
		return status;
	}

	@Override
	public List<PriceList> getPriceList() {
		return priceListRepository.findAll();
	}

}
