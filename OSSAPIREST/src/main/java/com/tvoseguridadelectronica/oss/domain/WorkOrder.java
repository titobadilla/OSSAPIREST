package com.tvoseguridadelectronica.oss.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Work_order")
public class WorkOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "client_id")
	Client client;

	@ManyToMany
	@JsonManagedReference
	Employee employee;

	@ManyToOne
	@JoinColumn(name = "list_work_order_id")
	ListWorkOrder listWorkOrder;

	@OneToOne
	@JoinColumn(name = "work_order_detail_id")
	WorkOrderDetail workOrderDetail;

	@ManyToOne
	@JoinColumn(name = "work_order_type_id")
	WorkOrderType workOrderType;

	public WorkOrder(String description, Client client, Employee employee, ListWorkOrder listWorkOrder, WorkOrderDetail workOrderDetail, WorkOrderType workOrderType) {
		this.description = description;
		this.client = client;
		this.employee = employee;
		this.listWorkOrder = listWorkOrder;
		this.workOrderDetail = workOrderDetail;
		this.workOrderType = workOrderType;
	}

	public WorkOrder() {
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ListWorkOrder getListWorkOrder() {
		return listWorkOrder;
	}

	public void setListWorkOrder(ListWorkOrder listWorkOrder) {
		this.listWorkOrder = listWorkOrder;
	}

	public WorkOrderDetail getWorkOrderDetail() {
		return workOrderDetail;
	}

	public void setWorkOrderDetail(WorkOrderDetail workOrderDetail) {
		this.workOrderDetail = workOrderDetail;
	}

	public WorkOrderType getWorkOrderType() {
		return workOrderType;
	}

	public void setWorkOrderType(WorkOrderType workOrderType) {
		this.workOrderType = workOrderType;
	}
}
