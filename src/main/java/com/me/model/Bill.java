/*
*@author toanb
*@date 16 kwi 2019
**/

/*
 * Bill is created when the customer check out successfully.
 */
package com.me.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;		//Id of the Bill
	private int customerId; //Customer Id
	private float amount; //Total price
	private Timestamp boughtDate; //The date which the bill was created
	
	//Constructors
	public Bill() {}
	public Bill(int customerId, float amount, Timestamp boughtDate) {
		super();
		this.customerId = customerId;
		this.amount = amount;
		this.boughtDate = boughtDate;
	}
	public Bill(int id, int customerId, float amount, Timestamp boughtDate) {
		super();
		Id = id;
		this.customerId = customerId;
		this.amount = amount;
		this.boughtDate = boughtDate;
	}
	
	//Getters and Setters
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Timestamp getBoughtDate() {
		return boughtDate;
	}
	public void setBoughtDate(Timestamp boughtDate) {
		this.boughtDate = boughtDate;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@Override
	public String toString() {
		return "Bill {Id=" + Id + ", customerId=" + customerId + ", amount=" + amount + ", boughtDate=" + boughtDate
				+ "}";
	}
	
}
