package com.myorg.app.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String name;
	 private String descriptions;
	 private String currencyType;
	 private BigDecimal itemPrice;
	 
	 @JsonBackReference
	 @ManyToOne(fetch = FetchType.EAGER, optional = false)   
	 @JoinColumn(name = "package_id", nullable = false)
	 private Package packages;	 
}
