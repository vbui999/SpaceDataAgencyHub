/*
*@author toanb
*@date 17 kwi 2019
**/
package com.me.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.me.model.Product;
import com.me.repository.BillRepository;
import com.me.repository.CartRepository;
import com.me.repository.HistoryRepository;
import com.me.repository.MissionRepository;
import com.me.repository.ProductRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class, secure = false)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductRepository productRepository;
	@MockBean
	private MissionRepository missionRepository;
	@MockBean
	private CartRepository cartRepository;
	@MockBean
	private BillRepository billRepository;
	@MockBean
	private HistoryRepository historyRepository;

	Product mockProduct = new Product(1, "Ranga all", Timestamp.valueOf("1975-08-01 00:00:01"), 2, (float) 100.00, "");
	List<Product> listMockProduct = new ArrayList<Product>();
	//String exampleCourseJson = "{\"productId\":1,\"missionName\":\"Ranga all\",\"takenDate\":176079601000,\"footprint\":2,\"price\":100.0,\"url\":\"\"}";

	//Test for get one Product by Id = 1 (Get Rest Service)
	@Test
	public void getOneProduct() throws Exception {
		Mockito.when(productRepository.findOne(1)).thenReturn(mockProduct);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "{\"productId\":1,\"missionName\":\"Ranga all\",\"takenDate\":176079601000,\"footprint\":2,\"price\":100.0,\"url\":\"\"}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	//Test for show all Product (Get Rest Service)
	@Test
	public void getAllProduct() throws Exception {
		listMockProduct.add(mockProduct);
		Mockito.when(productRepository.findAll()).thenReturn(listMockProduct);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "[{\"productId\":1,\"missionName\":\"Ranga all\",\"takenDate\":176079601000,\"footprint\":2,\"price\":100.0,\"url\":\"\"}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	

	
	
	
}
