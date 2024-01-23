package com.example.demo.runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repo.ProductRepo;
@Component
public class TestRunner implements CommandLineRunner{
    @Autowired
	private ProductRepo prepo;
	@Override
	public void run(String... args) throws Exception {
    Product p =new Product(101,"Pen", 200.0);
    Product p1 =new Product(102,"Pencil", 300.0);
    Product p2 =new Product(103,"Book", 400.0);
    Product p3 =new Product(104,"Box", 500.0);
    
    //prepo.save(p);
    
    prepo.saveAll(Arrays.asList(p,p1,p2,p3));
    
    //foreach loop
    Iterable<Product> data = prepo.findAll();
    /*for(Product pob:data) {
    	System.out.println(pob);
    	
    }*/
    
    //foreach method lamda expression or method refrence
   // data.forEach(System.out::println);
    data.forEach(ob->System.out.println(ob));
    
     Product prod = prepo.findById(103).orElseThrow(()-> new ProductNotFoundException("NOT EXIST"));
     System.out.println(prod);
    
     Iterable<Product> list = prepo.findAllById(Arrays.asList(101,103,106));
     list.forEach(System.out::println);
     
	}

}
