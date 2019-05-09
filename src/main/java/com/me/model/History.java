/*
*@author toanb
*@date 17 kwi 2019
**/

/*
 * The history will save the Items which were bought by customer.
 * 
 */
package com.me.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class History {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId; //Product Id
	
	private int customerId; //Customer Id
	private int missionId; //Mission Id
	private Timestamp boughtDate; //Time which item was bought
		
	//Constructors
	public History() {}  
	public History(int productId, int customerId, int missionId, Timestamp boughtDate) {
		super();
		this.productId = productId;
		this.customerId = customerId;
		this.missionId = missionId;
		this.boughtDate = boughtDate;
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

	public Timestamp getBoughtDate() {
		return boughtDate;
	}

	public void setBoughtDate(Timestamp boughtDate) {
		this.boughtDate = boughtDate;
	}
	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}


}
