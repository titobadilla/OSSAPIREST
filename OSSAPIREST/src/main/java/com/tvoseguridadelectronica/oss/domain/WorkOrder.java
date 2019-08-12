package com.tvoseguridadelectronica.oss.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tvoseguridadelectronica.oss.utilities.FormatDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
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
	@JoinColumn(name = "kit_work_order_id")
    KitWorkOrder kitWorkOrder;
	
	@OneToMany(mappedBy="id.workOrder")
	private List<WorkOrderDevice> listWorkOrderDevices;
	
	@OneToMany(mappedBy="id.workOrder")
	private List<WorkOrderMaterial> listWorkOrderMaterials;
	
	@OneToMany(mappedBy="id.workOrder")
	private List<WorkOrderTool> listWorkOrderTools;

	@OneToOne(mappedBy="workOrder")
	@JsonBackReference
	WorkOrderDetail workOrderDetail;

	@ManyToOne
	@JoinColumn(name = "work_order_type_id")
	WorkOrderType workOrderType;

	public WorkOrder(String description, Timestamp startDate, Timestamp endDate, Color color , 
			Client client, List<Employee> employees, KitWorkOrder kitWorkOrder, 
			WorkOrderDetail workOrderDetail, WorkOrderType workOrderType,List<WorkOrderDevice> listWorkOrderDevices,
			List<WorkOrderMaterial> listWorkOrderMaterials,List<WorkOrderTool> listWorkOrderTools) {
		this.description = description;
		this.client = client;
		this.employees = employees;
		this.kitWorkOrder = kitWorkOrder;
		this.workOrderDetail = workOrderDetail;
		this.workOrderType = workOrderType;
		this.startDate=startDate;
		this.endDate=endDate;
		this.color=color;
		this.listWorkOrderDevices=listWorkOrderDevices;
		this.listWorkOrderMaterials=listWorkOrderMaterials;
		this.listWorkOrderTools=listWorkOrderTools;
	}

	public WorkOrder() {
		this.client=new Client();
		this.employees=new ArrayList<>();
		this.kitWorkOrder=new KitWorkOrder();
		this.workOrderType=new WorkOrderType();
		this.color=new Color();
		this.listWorkOrderDevices=new ArrayList<>();
		this.listWorkOrderMaterials=new ArrayList<>();
		this.listWorkOrderTools=new ArrayList<>();
		
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

	public KitWorkOrder getkitWorkOrder() {
		return kitWorkOrder;
	}

	public void setkitWorkOrder(KitWorkOrder kitWorkOrder) {
		this.kitWorkOrder = kitWorkOrder;
	}
	
	public List<WorkOrderDevice> getListWorkOrderDevices() {
		return listWorkOrderDevices;
	}

	public void setListWorkOrderDevices(List<WorkOrderDevice> listWorkOrderDevices) {
		this.listWorkOrderDevices = listWorkOrderDevices;
	}

	public List<WorkOrderMaterial> getListWorkOrderMaterials() {
		return listWorkOrderMaterials;
	}

	public void setListWorkOrderMaterials(List<WorkOrderMaterial> listWorkOrderMaterials) {
		this.listWorkOrderMaterials = listWorkOrderMaterials;
	}

	public List<WorkOrderTool> getListWorkOrderTools() {
		return listWorkOrderTools;
	}

	public void setListWorkOrderTools(List<WorkOrderTool> listWorkOrderTools) {
		this.listWorkOrderTools = listWorkOrderTools;
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
			return this.client!=null?this.client.getName():"";
	}
	
	public String getLocationClientOptional(){
		String address = "";
		if(client!=null) {
			address = this.client.getAddressDescription().getDistrict().getDistrictId().getCanton().getCantonId().getProvince().getName()
					+ ", " + this.client.getAddressDescription().getDistrict().getDistrictId().getCanton().getName()
					+ ", " + this.client.getAddressDescription().getDistrict().getName()
					+ "; " + this.client.getAddressDescription().getDescription();
		}
			return address;

	}

	@Override
	public String toString() {
		if(startDate==null) {
			return "";
		}
		
		return "WorkOrder [id=" + id + ", description=" + description + ", startDate=" + startDate.toGMTString() + ", endDate="
				+ endDate + ", color=" + color + ", client=" + client + ", employees=" + employees + ", kitWorkOrder="
				+ kitWorkOrder + ", listWorkOrderDevices=" + listWorkOrderDevices + ", listWorkOrderMaterials="
				+ listWorkOrderMaterials + ", listWorkOrderTools=" + listWorkOrderTools + ", workOrderDetail="
				+ workOrderDetail + ", workOrderType=" + workOrderType + "]";
	}
		
	
}
