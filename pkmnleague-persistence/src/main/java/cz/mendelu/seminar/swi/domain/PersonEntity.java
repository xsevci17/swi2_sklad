/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.domain;

import java.util.Date;
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
 * @author vit
 * @author pirochta.jiri@gmail.com
 */
@Entity
public class PersonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_person;
 
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ADDRESS")    
    private AddressEntity id_address;

    @NotNull
    private String name;
	
    @NotNull
    private String surname;
     
    private Date dateOfBirth;
    
    public PersonEntity() {
    
    }
   
    public PersonEntity(int id_person, AddressEntity id_address, String name, String surname, Date dateOfBirth) {
        this.id_person = id_person;
        this.id_address = id_address;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId_person()
    {
            return id_person;
    }

    public void setId_person(int id_person)
    {
            this.id_person = id_person;
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonEntity)) return false;

        PersonEntity person = (PersonEntity) o;

        if (getId_person() != person.getId_person()){
			return false;
		}
		if (getId_address() != person.getId_address()){
			return false;
		}
        if (getName().equals(person.getName())){
            return false;
        }
        if (getSurname().equals(person.getSurname())){
            return false;
        }
        if (getDateOfBirth() != person.getDateOfBirth()){
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId_person();
        result = 31 * result + getName().hashCode();
		result = 31 * result + getSurname().hashCode();
        result = 31 * result + getDateOfBirth().hashCode();
        return result;
    }
}
