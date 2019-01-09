package com.tvoseguridadelectronica.oss.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Address_description")
public class AddressDescription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "client_id")
    @JsonManagedReference
    private Client client;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonManagedReference
    private Address address;

    public AddressDescription(String description, Client client, Address address) {
        this.description = description;
        this.client = client;
        this.address = address;
    }

    public AddressDescription() {
    	this.client=new Client();
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
                ", description:'" + description + '\'' +
                ", client:" + client +
                ", address:" + address +
                '}';
    }
}
