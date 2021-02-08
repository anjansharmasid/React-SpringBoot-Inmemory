package com.myorg.app.rest.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.myorg.app.repositories.PackageRepository;
import com.myorg.app.repositories.ProductRepository;
import com.myorg.app.service.LiveExchangeRatesService;
import com.myorg.app.model.Package;
import com.myorg.app.model.Product;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/v1")
public class ApplicationHealth {

	@Autowired
    private PackageRepository packageRepository;
	
	@Autowired
    private ProductRepository productRepository;

	@Autowired
	private LiveExchangeRatesService liveExchangeRatesService;
	
	@GetMapping(path="/", produces = "application/json")
    public String getApplicationIndex() {
		String status = "Sorry application is not working !";
		String api_response = "Failed to get api response";
		try {
			liveExchangeRatesService.convert("INR", "GBP", new BigDecimal(100));
			api_response = getDummyPackage().getName();
			status = "Application is working fine!";
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Failed to get exchange rates."+ e.getMessage());
		}
		
		return message + example + api_response + "</br>" + status;
    }	
	
	private Package getDummyPackage() {
		Package pack = new Package();
		pack.setName("Test Name"+ new Timestamp(System.currentTimeMillis()));
		pack.setDescription("Test Descriptions for packages ");
		pack.setCurrencyType("USD");
		pack = packageRepository.save(pack);
		Set<Product> products = new HashSet<Product>();
		for(long n = 1; n < 3 ; n++) {		
			Product prod = new Product();
			prod.setPackages(pack);
			prod.setName("Test product name " + new Timestamp(System.currentTimeMillis()));
			prod.setDescriptions("Test product description "+ n);
			prod.setCurrencyType("USD");
			prod.setItemPrice( new BigDecimal(21.67));
			prod = productRepository.save(prod);
			products.add(prod);
		}
		pack.setProducts(products);
		pack.getPrice();
		Package pack2 = packageRepository.save(pack);
		return pack2;
	}
	
	
	final String message ="Available services: \r\n" 
			+ "Get all packages  ->  /packages \r\n"
			+ "Get a packages    ->  /packages/{id} \r\n"
			+ "Get a product     ->  /products/{id} \r\n"
			+ "Post a Package    ->  /packages{Package Json} \r\n"
			+ "Post a product    ->  /products{products Json} \r\n"
			+ "Update a packages ->  /packages/{id}{Package Json} \r\n"
			+ "Delete a package  ->  /packages/{id}\r\n"
			+ "Post Currency to convert -> /convertcurrency{ConvertionInformation Json}"
			+ "\r\n"
			+ "Services response codes: \r\n"
			+ "		200 - SUCESS\r\n"
			+ "		404 - RESOURCE NOT FOUND\r\n"
			+ "		400 - BAD REQUEST\r\n"
			+ "		201 - CREATED\r\n"
			+ "		401 - UNAUTHORIZED\r\n"
			+ "		415 - UNSUPPORTED TYPE\r\n"
			+ "		500 - SERVER ERROR\r\n"
			+ "\r\n";
	
    final String example = "Exampe of Packages Json is given below: \r\n" +
    		"[\r\n"
    		+ "   {\r\n"
    		+ "      \"id\":1,\r\n"
    		+ "      \"name\":\"Test Name 1\",\r\n"
    		+ "      \"description\":\"Test Descriptions for packages \",\r\n"
    		+ "      \"products\":[\r\n"
    		+ "         {\r\n"
    		+ "            \"defaultCurrencyType\":\"USD\",\r\n"
    		+ "            \"id\":1,\r\n"
    		+ "            \"name\":\"Test product name 1\",\r\n"
    		+ "            \"descriptions\":\"Test product description 1\",\r\n"
    		+ "            \"currencyType\":\"USD\",\r\n"
    		+ "            \"itemPrice\":21.67,\r\n"
    		+ "            \"usdprice\":10\r\n"
    		+ "         },\r\n"
    		+ "         {\r\n"
    		+ "            \"defaultCurrencyType\":\"USD\",\r\n"
    		+ "            \"id\":2,\r\n"
    		+ "            \"name\":\"Test product name 2\",\r\n"
    		+ "            \"descriptions\":\"Test product description 2\",\r\n"
    		+ "            \"currencyType\":\"USD\",\r\n"
    		+ "            \"itemPrice\":21.67,\r\n"
    		+ "            \"usdprice\":10\r\n"
    		+ "         }\r\n"
    		+ "      ],\r\n"
    		+ "      \"currencyType\":\"USD\",\r\n"
    		+ "      \"price\":20.00\r\n"
    		+ "   }\r\n"
    		+ "]";
    		
	/**
	 	200 - SUCESS
		404 - RESOURCE NOT FOUND
		400 - BAD REQUEST
		201 - CREATED
		401 - UNAUTHORIZED
		415 - UNSUPPORTED TYPE - Representation not supported for the resource
		500 - SERVER ERROR
		
		GET : Should not update anything. Should be idempotent (same result in multiple calls). Possible Return Codes 200 (OK) + 404 (NOT FOUND) +400 (BAD REQUEST)
		POST : Should create new resource. Ideally return JSON with link to newly created resource. Same return codes as get possible. In addition : Return code 201 (CREATED) is possible.
		PUT : Update a known resource. ex: update client details. Possible Return Codes : 200(OK)
		DELETE : Used to delete a resource.
	
		
		The API must support the following:
		o Create a package
		o Retrieve a package
		o Update a package
		o Delete a package
		o List all packages
	 */
}
