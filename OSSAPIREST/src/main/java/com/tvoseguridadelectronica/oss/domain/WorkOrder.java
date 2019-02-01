package com.tvoseguridadelectronica.oss.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tvoseguridadelectronica.oss.utilities.FormatDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
	
	@Column(name = "start_date")
	private Timestamp startDate;
	
	@Column(name = "end_date")
	private Timestamp endDate;
	
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;

	@ManyToOne
	@JoinColumn(name = "client_id")
	Client client;

	@ManyToMany
	@JoinTable(name = "Work_order_employee", joinColumns = 
			@JoinColumn(name = "work_order_id", referencedColumnName="id"),
			inverseJoinColumns =  @JoinColumn(name = "employee_id",referencedColumnName="id") )
	List<Employee> employees;

	@ManyToOne
	@JoinColumn(name = "list_work_order_id")
	ListWorkOrder listWorkOrder;

	@OneToOne(mappedBy="workOrder")
	@JsonBackReference
	WorkOrderDetail workOrderDetail;

	@ManyToOne
	@JoinColumn(name = "work_order_type_id")
	WorkOrderType workOrderType;

	public WorkOrder(String description,Timestamp startDate,Timestamp endDate,Color color ,Client client, List<Employee> employees, ListWorkOrder listWorkOrder, WorkOrderDetail workOrderDetail, WorkOrderType workOrderType) {
		this.description = description;
		this.client = client;
		this.employees = employees;
		this.listWorkOrder = listWorkOrder;
		this.workOrderDetail = workOrderDetail;
		this.workOrderType = workOrderType;
		this.startDate=startDate;
		this.endDate=endDate;
		this.color=color;
	}

	public WorkOrder() {
		this.client=new Client();
		this.employees=new ArrayList<>();
		this.listWorkOrder=new ListWorkOrder();
		this.workOrderType=new WorkOrderType();
		this.color=new Color();
		
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
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

	public String getStartDate() {
		return FormatDate.sdf.format(startDate);
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return FormatDate.sdf.format(endDate);
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	
	public String getNameClientOptional(){
		return this.client.getName();
	}
	
	public String getLocationClientOptional(){
		
		String address=this.client.getAddressDescription().getAddress().getProvince() 
				+ ", "+ this.client.getAddressDescription().getAddress().getCanton()
				+", "+ this.client.getAddressDescription().getAddress().getDistrict()
				+"; "+  this.client.getAddressDescription().getDescription();
		
		return address;
	}
	
	@Override
	public String toString() {
		return "WorkOrder [id=" + id + ", description=" + description + ", startDate=" + startDate.toGMTString() + ", endDate="
				+ endDate + ", color=" + color + ", client=" + client + ", employees=" + employees + ", listWorkOrder="
				+ listWorkOrder + ", workOrderDetail=" + workOrderDetail + ", workOrderType=" + workOrderType + "]";
	}

	
	
	
}
