package com.example.Phase3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
	
	@Autowired
	PurchasesRepository purchasesRepository;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	public List<Transaction> showAll() {
		List<Purchases> purchases = purchasesRepository.findAll();
		List<Transaction> transactions = new ArrayList<Transaction>();
		for (Purchases purchase : purchases) {
			Transaction  transaction = new Transaction();
			transaction.setProductName(productService.showProductName(purchase.getProductId()));
			transaction.setTransactionDate(purchase.getDate());
			transaction.setUserName(userService.showUserName(purchase.getUserId()));
			transactions.add(transaction);
		}
		return transactions;
	}
	
}
