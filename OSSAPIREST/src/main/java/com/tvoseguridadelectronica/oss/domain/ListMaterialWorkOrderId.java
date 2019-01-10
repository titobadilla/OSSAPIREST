package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ListMaterialWorkOrderId implements Serializable {

    @ManyToOne
    private ListWorkOrder listWorkOrder;

    @ManyToOne
    private Tool tool;

    public ListMaterialWorkOrderId(ListWorkOrder listWorkOrder, Tool tool) {
        this.listWorkOrder = listWorkOrder;
        this.tool = tool;
    }

    public ListMaterialWorkOrderId() {
        this.listWorkOrder = new ListWorkOrder();
        this.tool = new Tool();
    }
}
