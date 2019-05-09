/*
*@author toanb
*@date 16 kwi 2019
**/

/*
 * Show services for Customer: searching, view order history.
 */
package com.me.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.me.model.Bill;
import com.me.model.Cart;
import com.me.model.History;
import com.me.model.Product;
import com.me.repository.BillRepository;
import com.me.repository.CartRepository;
import com.me.repository.HistoryRepository;
import com.me.repository.MissionRepository;
import com.me.repository.ProductRepository;
import com.me.service.CheckOut;
import com.me.service.HideUrl;

@RestController
public class CustomerController {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	MissionRepository missionRepository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	BillRepository billRepository;
	@Autowired
	HistoryRepository historyRepository;
	/*
	 * SEARCHING
	 */
	HideUrl hideUrl = new HideUrl(); // Hide Image URL for customers who haven't bought product yet/

	// show product with Id
	@GetMapping("/customer/{id}")
	public Product indexProducts(@PathVariable String id) {
		int productId = Integer.parseInt(id);
		Product product = productRepository.findOne(productId);
		return product;
	}

	// show all product
	@GetMapping("/customer")
	public List<Product> indexAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	// search by ImageType
	@PostMapping("/customer/search/image_type")
	public List<Product> searchProductByTypeImage(@RequestBody Map<String, String> body) {
		String searchTerm = body.get("text");
		return hideUrl.hideProductUrl(missionRepository.findByImageType(searchTerm));
	}

	// search by MissionName
	@PostMapping("/customer/search/name")
	public List<Product> searchProductByMissionName(@RequestBody Map<String, String> body) {
		String searchTerm = body.get("text");
		return hideUrl.hideProductUrl(productRepository.findByMissionNameContaining(searchTerm));
	}

	// search by TakenDate lower than
	@PostMapping("/customer/search/lower_date")
	public List<Product> searchProductByLowerDate(@RequestBody Map<String, String> body) {
		Timestamp searchTerm = Timestamp.valueOf(body.get("text"));
		return hideUrl.hideProductUrl(productRepository.findByTakenDateLessThan(searchTerm));
	}

	// search by TakenDate greater than
	@PostMapping("/customer/search/greater_date")
	public List<Product> searchProductByGreaterDate(@RequestBody Map<String, String> body) {
		Timestamp searchTerm = Timestamp.valueOf(body.get("text"));
		return hideUrl.hideProductUrl(productRepository.findByTakenDateGreaterThan(searchTerm));
	}

	// search by TakenDate between
	@PostMapping("/customer/search/between_date")
	public List<Product> searchProductByBetweenDate(@RequestBody Map<String, String> body) {
		Timestamp searchTerm = Timestamp.valueOf(body.get("date1"));
		Timestamp searchTerm2 = Timestamp.valueOf(body.get("date2"));
		return hideUrl.hideProductUrl(productRepository.findByTakenDateBetween(searchTerm, searchTerm2));
	}

	/*
	 * ORDER PROCESSING
	 */
	CheckOut checkOut = new CheckOut(); // create Object for checkout
	// Check out and show the bill

	@PostMapping("/customer/checkout")
	public Bill checkOutCart(@RequestBody Map<String, String> body) {
		int customerId = Integer.parseInt(body.get("text"));
		List<Cart> listCart = cartRepository.findByCustomerId(customerId);
		List<History> listHistory = checkOut.createHistory(listCart);
		Bill bill = checkOut.CheckOrder(listCart);
		billRepository.save(bill); // save the bill to Bill Repository
		historyRepository.save(listHistory); // save purchased products to History Repository
		return bill;
	}

	/*
	 * HISTORY
	 */
	// Get the order history for a customer
	@PostMapping("/customer/history")
	public List<Bill> getOderHistory(@RequestBody Map<String, String> body) {
		int customerId = Integer.parseInt(body.get("text"));
		return billRepository.findByCustomerId(customerId);
	}

	// Get list of the most orderedd products, missions

}
