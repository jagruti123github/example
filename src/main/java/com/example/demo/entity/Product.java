package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pId;
	private String pName;
	private Double pCost;
	

}
