package com.tvoseguridadelectronica.oss.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Address_description")
public class AddressDescription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

  
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public AddressDescription(String description, Address address) {
        this.description = description;
        this.address = address;
    }

    public AddressDescription() {
    	this.address=new Address();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

     public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AddressDescription{" +
                "id:" + id +
                ", description:'" + description +
                ", address:" + address +
                '}';
    }
}
