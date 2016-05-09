/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.domain;

import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author smonty
 * @author pirochta.jiri@gmail.com
 */
@Entity
public class WarehouseCardEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_warehouseCard;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_WAREHOUSEMAN")    
    private WarehousemanEntity id_warehouseman;
    
    @NotNull
    private Date dateOfCreation;
	
    public  WarehouseCardEntity() {
        
    }
	
    public  WarehouseCardEntity(WarehousemanEntity id_warehouseman, Date dateOfCreation) {
        this.id_warehouseman = id_warehouseman;
        this.dateOfCreation = dateOfCreation;
    }

	public int getId_warehouseCard()
	{
		return id_warehouseCard;
	}

	public void setId_warehouseCard(int id_warehouseCard)
	{
		this.id_warehouseCard = id_warehouseCard;
	}

	public WarehousemanEntity getId_warehouseman()
	{
		return id_warehouseman;
	}

	public void setId_warehouseman(WarehousemanEntity id_warehouseman)
	{
		this.id_warehouseman = id_warehouseman;
	}

	public Date getDateOfCreation()
	{
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation)
	{
		this.dateOfCreation = dateOfCreation;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WarehouseCardEntity)) return false;

        WarehouseCardEntity warehouseCard = (WarehouseCardEntity) o;

        if (getId_warehouseCard() != warehouseCard.getId_warehouseCard()){
			return false;
		}
        if (getId_warehouseman() != warehouseCard.getId_warehouseman()){
			return false;
		}
		if (getDateOfCreation() != warehouseCard.getDateOfCreation()){
			return false;
		}
		
		return true;
    }

    @Override
    public int hashCode() {
        int result = getId_warehouseCard();
        result = 31 * result + Objects.hashCode(getId_warehouseman());
		result = 31 * result + getDateOfCreation().hashCode();
        return result;
    }
}
