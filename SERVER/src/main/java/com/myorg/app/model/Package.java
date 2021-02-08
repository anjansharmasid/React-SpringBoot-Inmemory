package com.myorg.app.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;


@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "packages")
public class Package {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description; 	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "packages", fetch = FetchType.EAGER,cascade = CascadeType.ALL)  
	private Set<Product> products;
	
	private String currencyType; 
	private BigDecimal price;
	
    
    public BigDecimal getPrice() {
    	price = new BigDecimal(0); 
    	products.forEach(p->this.price=this.price.add(p.getItemPrice()));
    	return price.setScale(2, RoundingMode.HALF_EVEN);
    }
    
}
