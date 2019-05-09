/*
*@author toanb
*@date 16 kwi 2019
**/
package com.me.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.me.model.Bill;
import com.me.model.Cart;
import com.me.model.History;

public class CheckOut{
	
	public CheckOut() {}
	/*
	 * Process the Oder of customer and return as a Bill
	 */
	public Bill CheckOrder(List<Cart> listCart) {
		float amount = 0;
		for (Cart cart : listCart) {	//caculate the total price of bill
			amount = amount + cart.getPrice();
		}
		int customerId = listCart.get(1).getId();	//get the customerId	
		Timestamp boughtDate = Timestamp.valueOf("1980-02-01 00:00:01"); //example of current date
		Bill bill = new Bill(customerId, amount, boughtDate);		
		return bill;
	}
	
	/*
	 * Create a history of purchased products and return as History list
	 */
	public List<History> createHistory(List<Cart> listCart){
		List<History> listHistory = new ArrayList<History>();				
		for(Cart cart: listCart) {
			History history = new History(cart.getProductId(), cart.getCustomerId(), cart.getMissionId(), cart.getBillDate());
			listHistory.add(history);
		}		
		return listHistory;
	}
}
