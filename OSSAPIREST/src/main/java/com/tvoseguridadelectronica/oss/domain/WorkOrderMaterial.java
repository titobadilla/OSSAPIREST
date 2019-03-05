package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.*;

@Entity
@Table(name = "Work_order_material")
public class WorkOrderMaterial {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private WorkOrderMaterialId id;

    @Column(name = "quantity")
    private int quantity;
}
