package com.shop.bridge.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.shop.bridge.Application;
import com.shop.bridge.pojo.GenericResponse;
import com.shop.bridge.pojo.Products;

@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductIntegrationTest {

	@LocalServerPort
	private int port;

	@Sql({ "schema.sql", "data.sql" })
	@Test
	public void testAllEmployees() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		GenericResponse responseEntity = restTemplate.getForObject("http://localhost:" + port + "/employees",
				GenericResponse.class);
		System.out.println(responseEntity);
	}

	@Test
	public void testAddEmployee() {
		TestRestTemplate restTemplate = new TestRestTemplate();

		Products product = new Products(null, null, "OnePlus 6T", "OnePlus", "OnePlus 6T 128GB 8GB RAm", "50000");
		ResponseEntity<String> responseEntity = restTemplate
				.postForEntity("http://localhost:" + port + "/api/v1/products", product, String.class);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}

}
