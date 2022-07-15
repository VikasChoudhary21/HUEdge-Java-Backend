package com.service.catalog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table (name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	    @Id
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column (name = "product_name")
	    @NonNull
	    private String productName;

	    @NonNull
	    private Double price;

	    @NonNull
	    private String description;

	    @NonNull
	    private String category;
	    
	    @NonNull
	    private int availability;
	    
	    @NonNull
	    private Double rating;

		public Integer getId() {
			return id;
		}
	    
	    

}
