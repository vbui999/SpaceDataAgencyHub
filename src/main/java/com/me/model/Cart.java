/*
*@author toanb
*@date 16 kwi 2019
**/

/*
 * Cart is the shopping items of customers. All the items which customer choose was save here.
 * This data will be used in case of Customer check out.
 */
package com.me.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id; //Id of item in shopping cart
	
	private int productId; //Product Id
	private int customerId; //Customer Id
	private int missionId; //Mission Id
	private String productName; //Product name
	private float price; //Price of product
	private String url; //Url of product, that will be hidden if the customer haven't bought it yet
	private Timestamp billDate; //Time that the item was added
	
	//Constructors
	public Cart() {}	
	public Cart(int productId, int customerId, int missionId, String productName, float price, String url, Timestamp billDate) {
		this.productId = productId;
		this.customerId = customerId;
		this.missionId = missionId;
		this.productName = productName;
		this.price = price;
		this.url = url;
		this.billDate = billDate;
	}
	public Cart(int Id, int productId, int customerId, int missionId, String productName, float price, String url, Timestamp billDate) {
		this.Id = Id;
		this.productId = productId;
		this.customerId = customerId;
		this.missionId = missionId;
		this.productName = productName;
		this.price = price;
		this.url = url;
		this.billDate = billDate;
	}

	//Getters and Setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId() {
		return Id;
	}
	
    public void setId(int id) {
		Id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

	public Timestamp getBillDate() {
		return billDate;
	}

	public void setBillDate(Timestamp billDate) {
		this.billDate = billDate;
	}
	public int getMissionId() {
		return missionId;
	}

	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	@Override
    public String toString() {
        return "ShoppingCart{" +
                "Id=" + Id +
                ", productId='" + productId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", missionId='" + missionId + '\'' +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", url='" + url + '\'' +
                ", billDate='" + billDate + '\'' +
                '}';
    }


	
}
