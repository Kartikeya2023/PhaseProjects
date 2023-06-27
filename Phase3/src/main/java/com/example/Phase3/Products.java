package com.example.Phase3;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name ="name")
	 private String name;
	 
	 @Column(name ="category")
	 private String category;

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", category=" + category + "]";
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	


	public Products(Long id, String name, String category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}
	
}
