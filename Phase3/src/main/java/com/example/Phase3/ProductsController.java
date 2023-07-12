package com.example.Phase3;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	ProductsRepository productsRepository;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/show")
	public ResponseEntity<List<Products>> getAllProducts(){
		List<Products> products = new ArrayList<Products>();
		try {
			products= productService.showAll(); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	@PostMapping("/add")
	public String addProduct(@RequestBody ProductDTO productDTO) { 	
		productService.addProduct(productDTO);
		return "Added";
	} 
	
	@DeleteMapping("/remove")
	public String deleteProduct( @RequestParam(name = "id") Long id) {
		productService.removeProduct(id);
		return "Deleted";
	}
	

	@GetMapping("/categorize")
	public ResponseEntity<List<Products>> getCategorizedProducts(@RequestParam String str){
		List<Products> products = new ArrayList<Products>();
		try {
			products= productService.categorizeProducts(str); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	
	
}


