package com.tvoseguridadelectronica.oss.domain;

<<<<<<< HEAD
import java.io.Serializable;

public class WorkOrderType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
=======
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Word_order_type")
public class WorkOrderType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public WorkOrderType(String name) {
        this.name = name;
    }

    public WorkOrderType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
>>>>>>> 21f8744ae3f6a7144c4d9b9e76c12757b91bb1fe
}
