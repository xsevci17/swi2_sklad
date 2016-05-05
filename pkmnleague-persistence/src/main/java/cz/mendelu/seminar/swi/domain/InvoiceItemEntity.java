/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.domain;

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
public class InvoiceItemEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_invoiceItem;
	
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_INVOICE")    
    private InvoiceEntity id_invoice;
	
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PRODUCT")    
    private ProductEntity id_product;
	
    @NotNull
    private String unit;
	
    @NotNull
    private Double amount;
	
    private String description;
	
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
        
        if (! (obj instanceof InvoiceItemEntity) ) {
            return false;
        }
        
        InvoiceItemEntity ie = (InvoiceItemEntity) obj;
        
        if (
                (this.unit != ie.getUnit()) ||
                (this.amount != ie.getAmount()) ||
                (this.description != ie.getDescription())
                ) {
            return false;
        } else {
            return true;
        }
        
    }

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 89 * hash + Objects.hashCode(this.unit);
		hash = 89 * hash + Objects.hashCode(this.amount);
		hash = 89 * hash + Objects.hashCode(this.description);
		return hash;
	}

	public int getId_invoiceItem()
	{
		return id_invoiceItem;
	}

	public void setId_invoiceItem(int id_invoiceItem)
	{
		this.id_invoiceItem = id_invoiceItem;
	}

	public InvoiceEntity getId_invoice()
	{
		return id_invoice;
	}

	public void setId_invoice(InvoiceEntity id_invoice)
	{
		this.id_invoice = id_invoice;
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
    
	
}
