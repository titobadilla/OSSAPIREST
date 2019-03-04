package com.tvoseguridadelectronica.oss.domain;

<<<<<<< HEAD:OSSAPIREST/src/main/java/com/tvoseguridadelectronica/oss/domain/ListMaterialWorkOrder.java

=======
>>>>>>> 1426caa72a9a7bc051b29b258c9bade6b8483f79:OSSAPIREST/src/main/java/com/tvoseguridadelectronica/oss/domain/SuppliesMaterial.java
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "List_work_order_material")
public class SuppliesMaterial implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SuppliesMaterialId id;

    @Column(name = "quantity")
    private float quantity;

<<<<<<< HEAD:OSSAPIREST/src/main/java/com/tvoseguridadelectronica/oss/domain/ListMaterialWorkOrder.java
    public ListMaterialWorkOrder(float quantity) {
=======
    public SuppliesMaterial(int quantity) {
>>>>>>> 1426caa72a9a7bc051b29b258c9bade6b8483f79:OSSAPIREST/src/main/java/com/tvoseguridadelectronica/oss/domain/SuppliesMaterial.java
        this.quantity = quantity;
    }

    public SuppliesMaterial() {
        this.id = new SuppliesMaterialId();
    }

    public SuppliesMaterialId getId() {
        return id;
    }

    public void setId(SuppliesMaterialId id) {
        this.id = id;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
