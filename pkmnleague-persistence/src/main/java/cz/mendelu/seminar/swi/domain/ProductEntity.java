/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author smonty
 * @author zabi
 * @author pirochta.jiri@gmail.com
 */
@Entity
public class ProductEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_product;
	
    @NotNull
    @Column(nullable = false)
    private String title;

    @NotNull
    @Column(nullable = false)
    private String type;
	
    @NotNull
    @Column(nullable = false)
    private String description;

    public ProductEntity(String title, String type, String description) {
        this.title = title;
        this.type = type;
        this.description = description;
    }
    
    public int getId_product()
    {
            return this.id_product;
    }

    public void setId_product(int id_product)
    {
            this.id_product = id_product;
    }

    public String getTitle()
    {
            return title;
    }

    public void setTitle(String title)
    {
            this.title = title;
    }

    public String getType()
    {
            return type;
    }

    public void setType(String type)
    {
            this.type = type;
    }

    public String getDescription()
    {
            return description;
    }

    public void setDescription(String description)
    {
            this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;

        ProductEntity product = (ProductEntity) o;

        if (getId_product() != product.getId_product()){
			return false;
		}
		if (getTitle().equals(product.getTitle())){
			return false;
		}
		if (getType() != null ? !getType().equals(product.getType()) : product.getType() != null){
			return false;
		}
		if (getDescription() != null ? !getDescription().equals(product.getDescription()) : product.getDescription() != null){
			return false;
		}
		
		return true;
    }

    @Override
    public int hashCode() {
        int result = getId_product();
        result = 31 * result + getTitle().hashCode();
		result = 31 * result + getType().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }
}
