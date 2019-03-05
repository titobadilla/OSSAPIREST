package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.*;

@Entity
@Table(name = "Work_order_tool")
public class WorkOrderTool {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private WorkOrderToolId id;

    @Column(name = "quantity")
    private int quantity;
}
