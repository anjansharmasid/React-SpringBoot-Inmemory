package com.myorg.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.myorg.app.model.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	//Products findByName(String name);
}
