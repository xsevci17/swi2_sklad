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
 * @author smonty
 */
@Entity
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_invoice;
	    
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CUSTOMER")    
    private CustomerEntity id_customer;
	
    @NotNull
    private Date dateOfCreation;
	
    public InvoiceEntity(CustomerEntity cust, Date dateOfCreation) {
        this.id_customer = cust;
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
        
        if (! (obj instanceof InvoiceEntity) ) {
            return false;
        }
        
        InvoiceEntity ie = (InvoiceEntity) obj;
        
        if (
                (this.dateOfCreation != ie.getDateOfCreation())
				
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
            hash = 17 * hash + Objects.hashCode(this.dateOfCreation);
            return hash;
    }

    public int getId_invoice()
    {
            return id_invoice;
    }

    public void setId_invoice(int id_invoice)
    {
            this.id_invoice = id_invoice;
    }

    public CustomerEntity getId_customer()
    {
            return id_customer;
    }

    public void setId_customer(CustomerEntity id_customer)
    {
            this.id_customer = id_customer;
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
