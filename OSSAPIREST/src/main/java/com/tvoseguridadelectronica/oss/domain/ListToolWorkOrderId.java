package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ListToolWorkOrderId implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "list_work_order_id")
    private ListWorkOrder listWorkOrder ;

    @ManyToOne
    @JoinColumn(name = "tool_id")
    private Tool tool;

    public ListToolWorkOrderId() {
    }

    public ListToolWorkOrderId(ListWorkOrder listWorkOrder, Tool tool) {
        this.listWorkOrder = listWorkOrder;
        this.tool = tool;
    }

    public ListWorkOrder getListWorkOrder() {
        return listWorkOrder;
    }

    public void setListWorkOrder(ListWorkOrder listWorkOrder) {
        this.listWorkOrder = listWorkOrder;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
}
