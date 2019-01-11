package com.tvoseguridadelectronica.oss.domain;

<<<<<<< HEAD
import java.io.Serializable;

public class ListWorkOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
=======
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "List_work_order")
public class ListWorkOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public ListWorkOrder(String name) {
        this.name = name;
    }

    public ListWorkOrder() {
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
