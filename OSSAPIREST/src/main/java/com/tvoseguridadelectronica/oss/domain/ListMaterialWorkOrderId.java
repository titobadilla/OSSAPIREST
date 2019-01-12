package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ListMaterialWorkOrderId implements Serializable {

    @Column(name = "list_work_order_id")
    private int listWorkOrderId ;

    @Column(name = "material_id")
    private int materialId;

    public ListMaterialWorkOrderId() {
    }

    public ListMaterialWorkOrderId(int listWorkOrderId, int materialId) {
        this.listWorkOrderId = listWorkOrderId;
        this.materialId = materialId;
    }

    public int getListWorkOrderId() {
        return listWorkOrderId;
    }

    public void setListWorkOrderId(int listWorkOrderId) {
        this.listWorkOrderId = listWorkOrderId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Override
    public String toString() {
        return "ListMaterialWorkOrderId{" +
                "listWorkOrderId=" + listWorkOrderId +
                ", materialId=" + materialId +
                '}';
    }
}
