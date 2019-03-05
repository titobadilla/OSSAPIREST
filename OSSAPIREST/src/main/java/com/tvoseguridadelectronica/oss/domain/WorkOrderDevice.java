package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.*;

@Entity
@Table(name = "Work_order_device")
public class WorkOrderDevice {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private WorkOrderDeviceId id;

    @Column(name = "quantity")
    private int quantity;
}
