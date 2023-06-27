package com.example.Phase3;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="purchases")
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name ="product_id")
    private Long product_id;
    
    @Column(name ="user_id")
    private Long user_id;
    
    @Column(name ="date")
    private Date date;

	@Override
	public String toString() {
		return "Purchases [id=" + id + ", product_id=" + product_id + ", user_id=" + user_id + ", date=" + date + "]";
	}

	public Purchases() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Purchases(Long id, Long product_id, Long user_id, Date date) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.user_id = user_id;
		this.date = date;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
    
}
