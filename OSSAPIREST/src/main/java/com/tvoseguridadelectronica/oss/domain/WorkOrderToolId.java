package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Embeddable
public class WorkOrderToolId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 	@ManyToOne
	    @JoinColumn(name = "work_order_id")
	 	@JsonIgnoreProperties({"listWorkOrderDevices","listWorkOrderMaterials","listWorkOrderTools"})
	    private WorkOrder workOrder ;

	    @ManyToOne
	    @JoinColumn(name = "tool_id")
	    private Tool tool;

		public WorkOrderToolId(WorkOrder workOrder, Tool tool) {
			this.workOrder = workOrder;
			this.tool = tool;
		}

		public WorkOrderToolId() {
			this.workOrder=new WorkOrder();
			this.tool=new Tool();
		}

		public WorkOrder getWorkOrder() {
			return workOrder;
		}

		public void setWorkOrder(WorkOrder workOrder) {
			this.workOrder = workOrder;
		}

		public Tool getTool() {
			return tool;
		}

		public void setTool(Tool tool) {
			this.tool = tool;
		}

		@Override
		public String toString() {
			return "WorkOrderToolId [workOrder=" + workOrder + ", tool=" + tool + "]";
		}
		
		
	    
	    

}
