package com.example.Phase3;
import jakarta.persistence.*;


@Entity
@Table(name = "products")
public class Products {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long  id;
	 
	 @Column(name ="name")
	 private String name;
	 
	 @Column(name ="category")
	 private String category;

	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
}
