package org.rit.swen440.dataLayer;

import lombok.Data;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.sql.*;

/**
 * A product category supported by the Order System
 */
@Data
public class Category {
  private String name;
  private String description;

  private Set<Product> products = new HashSet<>();

  public Category(String name, String desc) {
	this.name=name;
	this.description=desc;
	}

public Category() {}

public Optional<Product> findProduct(String name) {
    return products.stream()
        .filter(p -> p.getTitle().equalsIgnoreCase(name))
        .findFirst();
  }

public void setName(String name) {this.name = name;}
public void setDescription(String description) {this.description = description;}
public void setProducts(Set<Product> loadProducts) {this.products = loadProducts;}
public Set<Product> getProducts() {return this.products;}
public String getName(){return this.name;}
public String getDescription(){ return this.description;}
}
