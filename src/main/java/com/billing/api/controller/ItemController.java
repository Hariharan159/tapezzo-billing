package com.billing.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.billing.api.entiry.Item;
import com.billing.api.service.ItemService;

@RestController
@RequestMapping("/api/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/print")
	public String print() {
		return "Welcome";
	}
	
	@PostMapping("/add")
	public ResponseEntity<Item> add(@RequestBody Item item) {
		return ResponseEntity.ok(itemService.addItem(item));
	}
	
	@GetMapping("/getitem/{id}")
	public ResponseEntity<Item> getItem(@PathVariable final Long id) {
		return ResponseEntity.ok(itemService.getItemById(id));
	}
	
	@GetMapping("/getitems")
	public ResponseEntity<List<Item>> getItems(){
		List<Item> items = itemService.getItem();
		return ResponseEntity.ok(items);
	}
	
	@PutMapping("/updateitem/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable final Long id, @RequestBody Item item) {
		return ResponseEntity.ok(itemService.updateItem(id, item));
	}
	
	@DeleteMapping("/deleteitem/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		boolean status = itemService.deleteItem(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", status);
		return ResponseEntity.ok(response);
	} 
	
}
