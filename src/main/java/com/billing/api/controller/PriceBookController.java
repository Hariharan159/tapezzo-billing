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

import com.billing.api.entiry.Item;
import com.billing.api.entiry.PriceBook;
import com.billing.api.service.ItemService;
import com.billing.api.service.PriceBookService;


@RestController
@RequestMapping("/api/pricebook")
public class PriceBookController {

	@Autowired
	private PriceBookService priceBookService;
	
	@PostMapping("/add")
	public ResponseEntity<PriceBook> add(@RequestBody PriceBook priceBook) {
		return ResponseEntity.ok(priceBookService.addPriceBook(priceBook));
	}
	
	@GetMapping("/getpricebook/{id}")
	public ResponseEntity<PriceBook> getItem(@PathVariable final Long id) {
		return ResponseEntity.ok(priceBookService.getpriceBookById(id));
	}
	
	@GetMapping("/getpricebooks")
	public ResponseEntity<List<PriceBook>> getItems(){
		List<PriceBook> priceBooks = priceBookService.getpriceBook();
		return ResponseEntity.ok(priceBooks);
	}
	
	@PutMapping("/updatepricebook/{id}")
	public ResponseEntity<PriceBook> updateItem(@PathVariable final Long id, @RequestBody PriceBook priceBook) {
		return ResponseEntity.ok(priceBookService.updatePriceBook(id, priceBook));
	}
	
	@DeleteMapping("/deletepricebook/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		boolean status = priceBookService.deletePriceBook(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", status);
		return ResponseEntity.ok(response);
	} 
	
}
