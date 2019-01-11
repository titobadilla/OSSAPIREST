package com.tvoseguridadelectronica.oss.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "List_work_order_device")
public class ListToolWorkOrder implements Serializable {

    @Autowired
    @EmbeddedId
    private ListToolWorkOrder id;

    @ManyToOne
    @JoinColumn(name = "list_work_order_id")
    private ListWorkOrder listWorkOrder;

    @ManyToOne
    @JoinColumn(name = "tool_id")
    private Tool tool;

    @Column(name = "quantity")
    private int quantity;

    public ListToolWorkOrder(ListWorkOrder listWorkOrder, Tool tool, int quantity) {
        this.listWorkOrder = listWorkOrder;
        this.tool = tool;
        this.quantity = quantity;
    }

    public ListToolWorkOrder() {
        this.listWorkOrder = new ListWorkOrder();
        this.tool = new Tool();
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
