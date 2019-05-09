/*
*@author toanb
*@date 16 kwi 2019
**/

/*
 * Product entity that describes the image properties and methods.
 */
package com.me.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId; // Product Id

	private String missionName; // Mission Name
	private Timestamp takenDate; // Date when the image was taken (UTC)
	private int footprint; // four coordinate describing the area of the image
	private float price; // price of product
	private String url; // url that save the image

	// Constructors for Product class
	public Product() {
	}

	public Product(String missionName, Timestamp takenDate, int footprint, float price, String url) {
		super();
		this.missionName = missionName;
		this.takenDate = takenDate;
		this.footprint = footprint;
		this.price = price;
		this.url = url;
	}

	public Product(int productId, String missionName, Timestamp takenDate, int footprint, float price, String url) {
		super();
		this.productId = productId;
		this.missionName = missionName;
		this.takenDate = takenDate;
		this.footprint = footprint;
		this.price = price;
		this.url = url;
	}

	// Getters and setters for product attributes.
	public int getProductId() {
		return productId;
	}

	public String getMissionName() {
		return missionName;
	}

	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}

	public Timestamp getTakenDate() {
		return takenDate;
	}

	public void setTakenDate(Timestamp takenDate) {
		this.takenDate = takenDate;
	}

	public int getFootprint() {
		return footprint;
	}

	public void setFootprint(int footprint) {
		this.footprint = footprint;
	}

	public float getPrice() {
		return price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", missionName='" + missionName + '\'' +
                ", takenDate='" + takenDate + '\'' +
                ", footprint='" + footprint + '\'' +
                ", price='" + price + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}
