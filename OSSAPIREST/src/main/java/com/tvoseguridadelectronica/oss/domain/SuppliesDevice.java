package com.tvoseguridadelectronica.oss.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "List_work_order_device")
public class SuppliesDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SuppliesDeviceId id;

    @Column(name = "quantity")
    private int quantity;

    public SuppliesDevice( int quantity) {
        this.quantity = quantity;
    }

    public SuppliesDevice() {
        this.id = new SuppliesDeviceId();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public SuppliesDeviceId getId() {
        return id;
    }

    public void setId(SuppliesDeviceId id) {
        this.id = id;
    }

	@Override
	public String toString() {
		return "ListDeviceWorkOrder [id=" + id + ", quantity=" + quantity + "]";
	}
    
    
}
