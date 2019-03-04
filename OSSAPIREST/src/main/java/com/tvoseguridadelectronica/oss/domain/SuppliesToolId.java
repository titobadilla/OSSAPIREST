package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class SuppliesToolId implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "kit_work_order_id")
    private KitWorkOrder listWorkOrder ;

    @ManyToOne
    @JoinColumn(name = "tool_id")
    private Tool tool;

    public SuppliesToolId() {
    }

    public SuppliesToolId(KitWorkOrder kitWorkOrder, Tool tool) {
        this.listWorkOrder = kitWorkOrder;
        this.tool = tool;
    }

    public KitWorkOrder getListWorkOrder() {
        return listWorkOrder;
    }

    public void setListWorkOrder(KitWorkOrder kitWorkOrder) {
        this.listWorkOrder = kitWorkOrder;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
}
