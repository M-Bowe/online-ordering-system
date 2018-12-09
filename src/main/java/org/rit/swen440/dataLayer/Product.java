package org.rit.swen440.dataLayer;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDateTime;

/**
 * A record of each product type
 */
@Data
public class Product {
  @Setter(AccessLevel.PRIVATE)
  private boolean updated = false;

  private Path path;

  private int skuCode;
  private int itemCount;
  private int threshold;
  private int reorderAmount;
  private String title;
  private String description;
  private BigDecimal cost;

  /**
   * Check to see if we have enough of this item for an order
   *
   * @param amount Number of items being ordered
   * @return true if enough stock
   */
  public boolean canOrder(int amount) {
    return (itemCount - amount >= 0);
  }

  
  /**
   * Place an order, decrement the available itemCount
   *
   * @param amount being ordered
   * @return if order was successfully processed
   */
  public boolean order(int amount) {
    if (canOrder(amount)) {
      itemCount = itemCount - amount;
      // TODO:  add stock management functionality

      try {
		  Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/orderingsystem","swen440","swen440");
		  Statement stmt = conn.createStatement();

		  stmt.executeQuery("UPDATE Product SET quantity="+itemCount+" WHERE sku = "+ skuCode);
		  //stmt.executeQuery("INSERT INTO Transaction VALUES("+LocalDateTime.now()+",'Test User',"+skuCode+","+amount+","+itemCount);
      } catch (SQLException e) {
			System.out.println("I can't believe you've done this");
			e.printStackTrace();
      }
	
      return true;
    }

    return false;
  }


public String getTitle() {return this.title;}
public int getSkuCode() {return this.skuCode;}
public int getItemCount(){return this.itemCount;}
public int getThreshold(){return this.threshold;}
public int getReorderAmount(){return this.reorderAmount;}
public String getDescription(){return this.description;}
public BigDecimal getCost(){return this.cost;}
public void setTitle(String title){this.title=title;}
public void setSkuCode(int skuCode){this.skuCode=skuCode;}
public void setItemCount(int itemCount){this.itemCount=itemCount;}
public void setThreshold(int threshold){this.threshold=threshold;}
public void setReorderAmount(int reorderAmount){this.reorderAmount=reorderAmount;}
public void setDescription(String description){this.description=description;}
public void setCost(BigDecimal cost){this.cost=cost;}

}
