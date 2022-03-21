package com.billing.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.api.entiry.PriceBook;
import com.billing.api.entiry.PriceList;
import com.billing.api.service.PriceBookService;
import com.billing.api.service.PriceListService;

@RestController
@RequestMapping("/api/price-list")
public class PriceListController {

	@Autowired
	private PriceListService priceListService;

	@PostMapping("/add")
	public ResponseEntity<PriceList> add(@RequestBody PriceList priceList) {
		return ResponseEntity.ok(priceListService.addPriceList(priceList));
	}
	
	@GetMapping("/getpricebook/{id}")
	public ResponseEntity<PriceList> getItem(@PathVariable final Long id) {
		return ResponseEntity.ok(priceListService.getPriceListById(id));
	}
	
	@GetMapping("/getpricebooks")
	public ResponseEntity<List<PriceList>> getItems(){
		List<PriceList> priceBooks = priceListService.getPriceList();
		return ResponseEntity.ok(priceBooks);
	}
	
	@PutMapping("/updatepricebook/{id}")
	public ResponseEntity<PriceList> updateItem(@PathVariable final Long id, @RequestBody PriceList priceList) {
		return ResponseEntity.ok(priceListService.updatePriceList(id, priceList));
	}
	
	@DeleteMapping("/deletepricebook/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		boolean status = priceListService.deletePriceList(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", status);
		return ResponseEntity.ok(response);
	} 
	
}
