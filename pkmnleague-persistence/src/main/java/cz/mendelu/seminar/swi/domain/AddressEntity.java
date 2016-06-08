package cz.mendelu.seminar.swi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author smonty
 */
@Entity
public class AddressEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_address;
    
    @NotNull
    private String city;
    
    @NotNull
    private String street;
    
    @NotNull
    private int houseNumber;
    
    public AddressEntity() {
        
    }
    
    public AddressEntity(String city, String street, int houseNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (! (obj instanceof AddressEntity) ) {
            return false;
        }
        
        AddressEntity ae = (AddressEntity) obj;
        
        if (
                (this.city != ae.getCity()) ||
                (this.houseNumber != ae.getHouseNumber()) ||
                (this.street != ae.getStreet())
                ) {
            return false;
        } else {
            return true;
        }
        
    }

    @Override
    public int hashCode() {
        int hashCode = 13;
        if (this.city != null) {
            hashCode *= 13 * this.city.hashCode();
        }
        
        if (this.street != null) {
            hashCode *= 13 * this.street.hashCode();
        }
        
        hashCode *= 13 * this.houseNumber;
        return hashCode;
    }

	public int getId_address()
	{
		return id_address;
	}

	public void setId_address(int id_address)
	{
		this.id_address = id_address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public int getHouseNumber()
	{
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber)
	{
		this.houseNumber = houseNumber;
	}
    
}
