package com.example.Phase3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
	@Autowired
	PurchaseService purchaseService;
	
	@Autowired
	PurchasesRepository purchasesRepository;
	
	@GetMapping("/show")
	public ResponseEntity<List<Transaction>> showTransactions(Model model) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			transactions= purchaseService.showAll();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).body(transactions);
	}
}
