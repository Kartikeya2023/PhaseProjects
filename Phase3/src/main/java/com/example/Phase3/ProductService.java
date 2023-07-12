package com.example.Phase3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	ProductsRepository productsRepository;
	
	public List<Products> showAll(){
		List<Products> products = productsRepository.findAll();
		return products;
	}
	
	public void addProduct(ProductDTO productDTO) {
		Products products = new Products();
		products.setCategory(productDTO.getCategory());
		products.setName(productDTO.getName());
		productsRepository.save(products);
	}
	
	public void removeProduct(Long id) {
		productsRepository.deleteById(id);
	}
	
	public String showProductName(long id) {
		Optional<Products> product = productsRepository.findById(id);
		if(product.isEmpty())
			return "PRODUCT_NOT_FOUND";
		else 
			return product.get().getName();
	}
	
	public List<Products> categorizeProducts(String str){
		List<Products> products = productsRepository.findAll();
		List<Products> retList= new ArrayList<Products>();
		for (Products products2 : products) {
			if (products2.getCategory().toString().equals(str)) {
				retList.add(products2);
			}
		}
		return retList;
	}
}