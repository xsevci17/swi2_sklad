package cz.mendelu.seminar.swi.domain;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author smonty
 */
@Entity
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_customer;
    
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ADDRESS")
    private AddressEntity id_address;
    
    @NotNull
    private String name;
    
    @NotNull
    private String surname;
    
    private Date dateOfBirth;
    
    @NotNull
    private long ICO;

    public CustomerEntity() {
        
    }
    
    public CustomerEntity(AddressEntity adr, String name, String surname, Date dateOfBirth, long ICO) {
        this.id_address = adr;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.ICO = ICO;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (! (obj instanceof CustomerEntity)) {
            return false;
        }
        
        CustomerEntity ce = (CustomerEntity) obj;
        if (
                (this.name != ce.getName()) ||
                (this.surname != ce.getSurname()) ||
                (this.dateOfBirth != ce.getDateOfBirth()) ||
                (this.ICO != ce.getICO())
                ) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        int hashCode = 13;
        
        if (this.name != null) {
            hashCode *= 13 * this.name.hashCode();
        }
        
        if (this.surname != null) {
            hashCode *= 13 * this.surname.hashCode();
        }
        
        if (this.dateOfBirth != null) {
            hashCode *= 13 * this.dateOfBirth.hashCode();
        }
        
        hashCode *= 13 * this.ICO;
        
        return hashCode;
    }
    
	public int getId_customer()
	{
		return id_customer;
	}

	public void setId_customer(int id_customer)
	{
		this.id_customer = id_customer;
	}

	public AddressEntity getId_address()
	{
		return id_address;
	}

	public void setId_address(AddressEntity id_address)
	{
		this.id_address = id_address;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	public long getICO()
	{
		return ICO;
	}

	public void setICO(long ICO)
	{
		this.ICO = ICO;
	}
	
}
