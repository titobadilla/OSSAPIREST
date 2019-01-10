package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ListDeviceWorkOrderId implements Serializable {

    @ManyToOne
    private ListWorkOrder listWorkOrder;

    @ManyToOne
    private Tool tool;

    public ListDeviceWorkOrderId(ListWorkOrder listWorkOrder, Tool tool) {
        this.listWorkOrder = listWorkOrder;
        this.tool = tool;
    }

    public ListDeviceWorkOrderId() {
        this.listWorkOrder = new ListWorkOrder();
        this.tool = new Tool();
    }
}
