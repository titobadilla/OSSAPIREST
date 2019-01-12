package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ListDeviceWorkOrderId implements Serializable {

    @Column(name = "list_work_order_id")
    private int listWorkOrderId ;

    @Column(name = "id_device")
    private int deviceId;

    public ListDeviceWorkOrderId() {
    }

    public ListDeviceWorkOrderId(int listWorkOrderId, int deviceId) {
        this.listWorkOrderId = listWorkOrderId;
        this.deviceId = deviceId;
    }

    public int getListWorkOrderId() {
        return listWorkOrderId;
    }

    public void setListWorkOrderId(int listWorkOrderId) {
        this.listWorkOrderId = listWorkOrderId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "ListDeviceWorkOrderId{" +
                "listWorkOrderId=" + listWorkOrderId +
                ", deviceId=" + deviceId +
                '}';
    }
}
