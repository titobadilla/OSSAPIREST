package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ListToolWorkOrderId implements Serializable {

    @ManyToOne
    private ListWorkOrder listWorkOrder;

    @ManyToOne
    private Tool tool;

    public ListToolWorkOrderId(ListWorkOrder listWorkOrder, Tool tool) {
        this.listWorkOrder = listWorkOrder;
        this.tool = tool;
    }

    public ListToolWorkOrderId() {
        this.listWorkOrder = new ListWorkOrder();
        this.tool = new Tool();
    }
}
