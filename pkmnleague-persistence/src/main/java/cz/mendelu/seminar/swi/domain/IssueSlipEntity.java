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
import javax.validation.constraints.NotNull;

/**
 *
 * @author smonty
 */
@Entity
public class IssueSlipEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_issueSlip;
		
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_WAREHOUSECARD")    
    private WarehouseCardEntity id_warehouseCard;
	
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_WAREHOUSEMAN")    
    private WarehousemanEntity id_warehouseman;
	
    @NotNull
    private Date dateOfCreation;

    public IssueSlipEntity () {
    
    }
    
    public IssueSlipEntity (WarehouseCardEntity id_warehouseCard, WarehousemanEntity id_warehouseman, Date dateOfCreation) {
        this.id_warehouseCard = id_warehouseCard;
        this.id_warehouseman = id_warehouseman;
        this.dateOfCreation = dateOfCreation;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (! (obj instanceof IssueSlipEntity) ) {
            return false;
        }
        
        IssueSlipEntity tmpEntity = (IssueSlipEntity) obj;
        
        if (
            (this.id_warehouseCard != tmpEntity.getId_warehouseCard()) ||
            (this.id_warehouseman != tmpEntity.getId_warehouseman()) ||
            (this.dateOfCreation != tmpEntity.getDateOfCreation())
        ) {
            return false;
        }
        
        return true;     
    }

    @Override
    public int hashCode()
    {
        int hash = 15;
        hash = 99 * hash + Objects.hashCode(this.id_warehouseCard);
        hash = 99 * hash + Objects.hashCode(this.id_warehouseman);
        hash = 99 * hash + Objects.hashCode(this.dateOfCreation);
        return hash;
    }

	public int getId_issueSlip()
	{
		return id_issueSlip;
	}

	public void setId_issueSlip(int id_issueSlip)
	{
		this.id_issueSlip = id_issueSlip;
	}

	public WarehouseCardEntity getId_warehouseCard()
	{
		return id_warehouseCard;
	}

	public void setId_warehouseCard(WarehouseCardEntity id_warehouseCard)
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
}
