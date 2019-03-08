package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@Embeddable
public class SuppliesToolId implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "kit_work_order_id")
	@JsonIgnoreProperties({"listSuppliesDevices","listSuppliesMaterials","listSuppliesTools"})
    private KitWorkOrder kitWorkOrder ;

    @ManyToOne
    @JoinColumn(name = "tool_id")
    private Tool tool;

    public SuppliesToolId() {
    }

    public SuppliesToolId(KitWorkOrder kitWorkOrder, Tool tool) {
        this.kitWorkOrder = kitWorkOrder;
        this.tool = tool;
    }

    public KitWorkOrder getkitWorkOrder() {
        return kitWorkOrder;
    }

    public void setkitWorkOrder(KitWorkOrder kitWorkOrder) {
        this.kitWorkOrder = kitWorkOrder;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
}
