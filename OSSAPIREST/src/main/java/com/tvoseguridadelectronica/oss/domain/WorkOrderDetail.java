package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;

@Entity
@Table(name = "Work_order_detail")
public class WorkOrderDetail  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "check_in")
    private String checkIn;

    @Column(name = "check_out")
    private String checkOut;

    @Column(name = "description")
    private String description;

    @Column(name = "invoice_id")
    private int invoiceId;

    @Column(name = "manager_name")
    private String managerName;
    
    @OneToOne
	@JoinColumn(name = "work_order_id")
	@JsonManagedReference
    private WorkOrder workOrder;

    public WorkOrderDetail(Date date, String checkIn, String checkOut, String description, int invoiceId, String managerName) {
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.description = description;
        this.invoiceId = invoiceId;
        this.managerName = managerName;
    }

    public WorkOrderDetail() {
    	this.date=new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

	public WorkOrder getWorkOrder() {
		return workOrder;
	}

	public void setWorkOrder(WorkOrder workOrder) {
		this.workOrder = workOrder;
	}

	@Override
	public String toString() {
		return "WorkOrderDetail [id=" + id + ", date=" + date + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", description=" + description + ", invoiceId=" + invoiceId + ", managerName=" + managerName
				+ ", workOrder=" + workOrder + "]";
	}

	
}
