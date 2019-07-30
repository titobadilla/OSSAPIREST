package com.tvoseguridadelectronica.oss.domain;

public class Report {
	private int id;
	private String description;
	private String startDate;
	private String endDate;
	private String state;
	private String nameClient;
	private String nameWorkOrderType;
	
	public Report(int id, String description, String startDate, String endDate, String state, String nameClient,
			String nameWorkOrderType) {
		this.id = id;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.state = state;
		this.nameClient = nameClient;
		this.nameWorkOrderType = nameWorkOrderType;
	}

	public Report() {
		
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getNameWorkOrderType() {
		return nameWorkOrderType;
	}

	public void setNameWorkOrderType(String nameWorkOrderType) {
		this.nameWorkOrderType = nameWorkOrderType;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", state=" + state + ", nameClient=" + nameClient + ", nameWorkOrderType=" + nameWorkOrderType + "]";
	}
	
	
	
	

}
