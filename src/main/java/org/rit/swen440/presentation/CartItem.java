package org.rit.swen440.presentation;

import java.util.*;
import java.io.*;

public class CartItem
{
  String name;
  int quantity;
  double price;

  public CartItem(String _name, int _quantity, double _price){
    name = _name;
    quantity = _quantity;
    price = _price;
  }

  public String getName() { return name; }
  public int getQuantity() { return quantity;}
  public double getPrice() { return price;}

  public void addAmount(int amount){ this.quantity += amount; }

}
