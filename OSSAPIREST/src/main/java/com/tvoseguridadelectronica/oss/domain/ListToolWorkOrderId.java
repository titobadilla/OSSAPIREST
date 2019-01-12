package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ListToolWorkOrderId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "list_work_order_id")
    private int listWorkOrderId ;

    @Column(name = "tool_id")
    private int toolId;

    public ListToolWorkOrderId() {
    }

    public ListToolWorkOrderId(int listWorkOrderId, int toolId) {
        this.listWorkOrderId = listWorkOrderId;
        this.toolId = toolId;
    }

    public int getListWorkOrderId() {
        return listWorkOrderId;
    }

    public void setListWorkOrderId(int listWorkOrderId) {
        this.listWorkOrderId = listWorkOrderId;
    }

    public int getToolId() {
        return toolId;
    }

    public void setToolId(int toolId) {
        this.toolId = toolId;
    }
}
