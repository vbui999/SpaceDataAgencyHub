/*
*@author toanb
*@date 17 kwi 2019
**/
package com.me.service;

import java.util.List;

import com.me.model.Product;

public class HideUrl {

	public HideUrl() {}
	/*
	 * Hide product Url from users who haven't bought yet
	 */
	public List<Product> hideProductUrl(List<Product> listProduct){
		for (int i =0; i < listProduct.size(); i++) {	
			listProduct.get(i).setUrl("");
		}	
		return listProduct;
	}

}
