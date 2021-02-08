package com.myorg.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myorg.app.model.Package;


@Repository
public interface PackageRepository extends CrudRepository<Package, Long>{

	//Package save(Package packag);
	//Packages findByName(String name);
}
