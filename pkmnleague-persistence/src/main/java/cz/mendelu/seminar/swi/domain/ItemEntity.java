/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.domain;

import cz.mendelu.seminar.swi.dao.IIssueSlip;
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
public class ItemEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_item;
	
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ISSUESLIP")    
    private IssueSlipEntity id_issueSlip;
	
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PRODUCT")    
    private ProductEntity id_product;
	
    @NotNull
    private String unit;
	
    @NotNull
    private Double amount;
	
    private String itemName;
	
    public ItemEntity(IssueSlipEntity isueSlip, ProductEntity product, String unit, Double amount, String itemName) {
        this.id_issueSlip = isueSlip;
        this.id_product = product;
        this.unit = unit;
        this.amount = amount;
        this.itemName = itemName;
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
        
        if (! (obj instanceof ItemEntity) ) {
            return false;
        }
        
        ItemEntity ie = (ItemEntity) obj;
        
        if (
            (this.unit != ie.getUnit()) ||
            (this.id_issueSlip != ie.getId_issueSlip()) ||
            (this.id_product != ie.getId_product()) ||
            (this.amount != ie.getAmount()) ||
            (this.itemName != ie.getItemName())
        ) {
            return false;
        } else {
            return true;
        }
        
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.unit);
        hash = 79 * hash + Objects.hashCode(this.amount);
        hash = 79 * hash + Objects.hashCode(this.id_issueSlip);
        hash = 79 * hash + Objects.hashCode(this.id_product);
        hash = 79 * hash + Objects.hashCode(this.itemName);
        return hash;
    }

    public int getId_item()
    {
            return id_item;
    }

    public void setId_item(int id_item)
    {
            this.id_item = id_item;
    }

    public IssueSlipEntity getId_issueSlip()
    {
        return id_issueSlip;
    }

    public void setId_issueSlip(IssueSlipEntity id_issueSlip)
    {
            this.id_issueSlip = id_issueSlip;
    }

    public ProductEntity getId_product()
    {
            return id_product;
    }

    public void setId_product(ProductEntity id_product)
    {
            this.id_product = id_product;
    }

    public String getUnit()
    {
            return unit;
    }

    public void setUnit(String unit)
    {
            this.unit = unit;
    }

    public Double getAmount()
    {
            return amount;
    }

    public void setAmount(Double amount)
    {
            this.amount = amount;
    }

    public String getItemName()
    {
            return itemName;
    }

    public void setItemName(String itemName)
    {
            this.itemName = itemName;
    }
}
