/*
*@author toanb
*@date 17 kwi 2019
**/
package com.me.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ManagerControllerTest {

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
	@MockBean
	ManagerController managerController;
	
	Product mockProduct = new Product(2, "My Mission", Timestamp.valueOf("1990-03-01 00:00:01"), 2, (float) 100.1,
			"/images/my_mission1.jpg");
	List<Product> listMockProduct = new ArrayList<Product>();
	Map<String, String> body = new HashMap<String, String>();
	String exampleJson = "{\r\n" + "  \"productId\": 2,\r\n" + "  \"missionName\": \"My Mission\",\r\n"
			+ "  \"takenDate\": \"1990-03-01 00:00:01\",\r\n" + "  \"footprint\": 2,\r\n" + "  \"price\": 100.1,\r\n"
			+ "  \"url\": \"/images/my_mission1.jpg\"\r\n" + "}";

	
	// Test for adding one Product (POST Rest Service)
	@Test
	public void addProduct() throws Exception {
		body.put("productId", "2");
		body.put("missionName", "My Mission");
		body.put("takenDate", "1990-03-01 00:00:01");
		body.put("footprint", "2");
		body.put("price", "100.1");
		body.put("url", "/images/my_mission1.jpg");
		//ManagerController managerController = new ManagerController();

		Mockito.when(managerController.addProduct(body)).thenReturn(mockProduct);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manager/product")
				.accept(MediaType.APPLICATION_JSON).content(exampleJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "{\"productId\":2,\"missionName\":\"My Mission\",\"takenDate\":636246001000,\"footprint\":2,\"price\":100.1,\"url\":\"/images/my_mission1.jpg\"}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
}
