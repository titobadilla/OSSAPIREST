package com.tvoseguridadelectronica.oss.domain;

<<<<<<< HEAD
import java.io.Serializable;
=======
import com.fasterxml.jackson.annotation.JsonManagedReference;
>>>>>>> 21f8744ae3f6a7144c4d9b9e76c12757b91bb1fe

import javax.persistence.*;

@Entity
@Table(name = "Model")
public class Model implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Model() {
    }

    public Model(String name) {
        this.name = name;
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
}
