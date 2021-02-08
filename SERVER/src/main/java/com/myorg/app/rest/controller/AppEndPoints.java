package com.myorg.app.rest.controller;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.myorg.app.repositories.PackageRepository;
import com.myorg.app.repositories.ProductRepository;
import com.myorg.app.service.LiveExchangeRatesService;
import com.myorg.app.model.Convertcurrency;
import com.myorg.app.model.Package;
import com.myorg.app.model.Product;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping(path = "/api/v1")

public class AppEndPoints {

	@Autowired
    private PackageRepository packageRepository;
	
	@Autowired
    private ProductRepository productRepository;

	@Autowired
	private LiveExchangeRatesService liveExchangeRatesService;

	@GetMapping("/packages")
	public Iterable<Package> retrieveAllPackage(){
		return packageRepository.findAll();
	}
		
	
	@GetMapping("/packages/{id}" )
	public Package retrievePackage(@PathVariable long id) {
		Optional<Package> packag = packageRepository.findById(id);
		if (!packag.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no package found with id-" + id);
		return packag.get();
	}
	
	
	@GetMapping("/products/{id}")
	public Product retrieveProduct(@PathVariable long id) {
		Optional<Product> product = productRepository.findById(id);
		if (!product.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no product found with id-" + id);
		return product.get();
	}
	
	
	@PostMapping(path ="/packages", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createPackage(@RequestBody Package packag) {
		String responseMessage = "Package created";
		try {
			Package savedPackage = packageRepository.save(packag);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPackage.getId()).toUri();
			return ResponseEntity.created(location).build();
		}
		catch(Exception e) {
			responseMessage = "Failed to created Package";
		}
		return ResponseEntity.ok(responseMessage);
	}
	
	
	@PostMapping("/products")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		Product savedProduct = productRepository.save(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProduct.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping("/packages/{id}")
	public ResponseEntity<Object> updatePackage(@RequestBody Package packag, @PathVariable long id) {
		Optional<Package> packageOptional = packageRepository.findById(id);
		if (!packageOptional.isPresent())
			return ResponseEntity.notFound().build();
		packag.setId(id);
		packageRepository.save(packag);
		return ResponseEntity.noContent().build();
	}
	
	
	@DeleteMapping("/packages/{id}")
	public ResponseEntity<Object> deletePackage(@PathVariable long id) {
		String responseMessage = "Package id: "+id+" deleted";
		try {
		packageRepository.deleteById(id);
		}catch (Exception e) { 
			responseMessage = "Delete Failed";
		}
		return ResponseEntity.ok(responseMessage);
	}
	
	
	@PostMapping("/convertcurrency")
	public ResponseEntity<Convertcurrency> convertCurrency(@RequestBody Convertcurrency convertcurrency) {
		Convertcurrency convertedCurrency = new Convertcurrency();
		if (convertedCurrency.getAmount().doubleValue() <= 0) {
			return new ResponseEntity<>(convertedCurrency, HttpStatus.NO_CONTENT);
		}
		try {
			BigDecimal convertedAmt = liveExchangeRatesService.convert(convertcurrency.getFromCurrency(),convertcurrency.getToCurrency(),convertcurrency.getAmount());
			convertcurrency.setConvertedAmount(convertedAmt);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Failed to get exchange rates."+ e.getMessage());
		}
		return new ResponseEntity<>(convertedCurrency, HttpStatus.OK);
	}

}
