// Developer Regression test. 
// To be run from development with a running server in place on local host.
package com.myorg.app.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.myorg.app.model.Convertcurrency;
import com.myorg.app.model.Package;
import com.myorg.app.model.Product;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApiEndPointTestRegression  {
	
	@LocalServerPort
	private int port=8443;

	private String host = "localhost:";
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@SuppressWarnings("unchecked")
	
	private void retrieveAllPackageTest () throws Exception {
		assertThat(this.restTemplate.getForObject("http://"+host+":" + port + "/packages",
				List.class)).asList();
	}

	
	private void retrievePackageTest () throws Exception {
		assertThat(this.restTemplate.getForObject("http://"+host+":" + port + "/packages/1",
				Package.class)).isNotNull();
	}
	
	
	private void retrieveProductTest () throws Exception {
		assertThat(this.restTemplate.getForObject("http://"+host+":" + port + "/products/1",
				Package.class)).isNotNull();
	}
	
	
	private void createPackageTest () throws Exception {
		String baseUrl = "http://"+host+":" + port + "/packages";
		URI uri = new URI(baseUrl);
		Package pack = new Package();
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("X-COM-PERSIST", "true");  
	    headers.set("Content-Type", "text/plain");
	    headers.set("Authorization", "Basic " + "btoa('admin:password')");
	    HttpEntity<Package> request = new HttpEntity<>(pack, headers);
	    ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	    assertEquals(201, result.getStatusCodeValue());
	}
	
	
	private void createProductTest () throws Exception {
		String baseUrl = "http://"+host+":" + port + "/products";
		URI uri = new URI(baseUrl);
		Product product = new Product();
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("X-COM-PERSIST", "true");  
	    headers.set("Content-Type", "text/plain");
	    headers.set("Authorization", "Basic " + "btoa('admin:password')");
	    HttpEntity<Product> request = new HttpEntity<>(product, headers);
	    ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	    assertEquals(201, result.getStatusCodeValue());
		
	}
	
	
	private void updatePackageTest () throws Exception {
		String baseUrl = "http://"+host+":" + port + "/packages/1";
		URI uri = new URI(baseUrl);
		Package pack = new Package();
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("X-COM-PERSIST", "true");  
	    headers.set("Content-Type", "text/plain");
	    headers.set("Authorization", "Basic " + "btoa('admin:password')");
	    HttpEntity<Package> request = new HttpEntity<>(pack, headers);
	    ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	    assertEquals(201, result.getStatusCodeValue());
	
	}
	
	
	private void deletePackageTest () throws Exception {
		String baseUrl ="http://"+host+":" + port + "/packages/1";
		URI uri = new URI(baseUrl);
		Convertcurrency convertcurrency = new Convertcurrency();
		Package pack = new Package();
		HttpHeaders headers = new HttpHeaders();
	    headers.set("X-COM-PERSIST", "true");  
	    headers.set("Content-Type", "text/plain");
	    headers.set("Authorization", "Basic " + "btoa('admin:password')");
	    HttpEntity<Convertcurrency> request = new HttpEntity<>(convertcurrency, headers);
	    ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	    assertEquals(201, result.getStatusCodeValue());
	}
	
	
	
	private void convertCurrencyTest () throws Exception {
		String baseUrl = "http://"+host+":" + port + "/convertcurrency";
		URI uri = new URI(baseUrl);
		Convertcurrency convertcurrency = new Convertcurrency();
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("X-COM-PERSIST", "true");  
	    headers.set("Content-Type", "text/plain");
	    headers.set("Authorization", "Basic " + "btoa('admin:password')");
	    HttpEntity<Convertcurrency> request = new HttpEntity<>(convertcurrency, headers);
	    ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	    assertEquals(201, result.getStatusCodeValue());
	}
	
	
	public void doRegressionTest() throws Exception {
		retrieveAllPackageTest ();
		retrievePackageTest ();
		retrieveProductTest ();
		createPackageTest () ;
		createProductTest ();
		updatePackageTest ();
		deletePackageTest ();
		convertCurrencyTest ();
	}
}
