package com.example.springbootresttemplate.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springbootresttemplate.product.Product;

@RestController
public class ProductController {
	@Autowired
	RestTemplate restTemplate;

	@PostMapping(value = "/template/products")
	public Product createProducts(@RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);

		return restTemplate.exchange("http://localhost:9190/addProduct", HttpMethod.POST, entity, Product.class)
				.getBody();
	}

	@GetMapping(value = "/template/products")
	public String getProductList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(headers);

		return restTemplate.exchange("http://localhost:9190/products", HttpMethod.GET, entity, String.class).getBody();
	}

//	@GetMapping(value = "/template/product/{id}")
//	public String getProductById(@PathVariable("id") String id) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<Product> entity = new HttpEntity<Product>(headers);
//
//		return restTemplate.exchange("http://localhost:9190//product/" + id, HttpMethod.GET, entity, String.class)
//				.getBody();
//	}

	@GetMapping(value = "/template/product/{id}")
	public String getProductById(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(headers);

		return restTemplate.exchange("http://localhost:9190//product/" + id, HttpMethod.GET, entity, String.class)
				.getBody();

	}

	@PutMapping(value = "/template/products/{id}")
	public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);
		System.out.println(id);
		return restTemplate.exchange("http://localhost:9190/update/" + id, HttpMethod.PUT, entity, String.class)
				.getBody();
	}

	@DeleteMapping(value = "/template/products/{id}")
	public String deleteProduct(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(headers);

		return restTemplate.exchange("http://localhost:9190/delete/" + id, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}
}
