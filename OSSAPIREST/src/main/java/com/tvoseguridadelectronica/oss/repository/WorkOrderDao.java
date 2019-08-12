package com.tvoseguridadelectronica.oss.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import javax.sql.DataSource;

import com.tvoseguridadelectronica.oss.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.tvoseguridadelectronica.oss.domain.KitWorkOrder;


@Repository
public class WorkOrderDao {
	
	 private JdbcTemplate jdbcTemplate;
	    private SimpleJdbcCall simpleJdbcCallRemoveWorkOrderMaterialsById;

	    private SimpleJdbcCall simpleJdbcCallRemoveWorkOrderDevicesById;

	    private SimpleJdbcCall simpleJdbcCallRemoveWorkOrderToolsById;	    

	    private SimpleJdbcCall simpleJdbcCallReportWorkOrderByTypeAndDate;

	    private SimpleJdbcCall simpleJdbcCallReportWorkOrderByClientAndDate;

	    @Autowired
	    public void setDataSource(DataSource dataSource){
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	        this.simpleJdbcCallRemoveWorkOrderDevicesById = new SimpleJdbcCall(dataSource);
	        this.simpleJdbcCallRemoveWorkOrderMaterialsById = new SimpleJdbcCall(dataSource);
	        this.simpleJdbcCallRemoveWorkOrderToolsById = new SimpleJdbcCall(dataSource);
	        this.simpleJdbcCallReportWorkOrderByTypeAndDate=new SimpleJdbcCall(dataSource);
	        this.simpleJdbcCallReportWorkOrderByClientAndDate=new SimpleJdbcCall(dataSource);	        
	    }
	    
	    public List<Report> reportWorkOrderByClientAndDate(int clientId,String startDate,String endDate){
	    	String sqlProcedure = "{call OSS_Report_Work_Order_By_Client_And_Date(?,?,?)}";

			List<Report> reportList = this.jdbcTemplate.query(sqlProcedure, new WorkOrdersReportExtractor(),clientId,startDate,endDate);
			return reportList;    	
	    	
	    }

	    public List<WorkOrder> getAllByFilter(){
			String sqlProcedure = "{call OSS_Get_Work_Order()}";

	    	List<WorkOrder> workOrders = this.jdbcTemplate.query(sqlProcedure, new WorkOrderExtractor());

	    	return workOrders;
		}
	    
	    public List<Report> reportWorkOrderByTypeAndDate(int typeId,String startDate,String endDate){
	    	String sqlProcedure = "{call OSS_Report_Work_Order_By_Type_And_Date(?,?,?)}";

			List<Report> reportList = this.jdbcTemplate.query(sqlProcedure, new WorkOrdersReportExtractor(),typeId,startDate,endDate);
			return reportList;    	
	    	
	    }
	    
	    
	    public List<WorkOrder> findWorkOrdersByStartDateLike(String date){
	    	String sqlProcedure = "{call OSS_Work_Orders_By_Start_Date(?)}";

			List<WorkOrder> listWorkOrders = this.jdbcTemplate.query(sqlProcedure, new WorkOrdersByStartDateLikeExtractor(),date);
			return listWorkOrders;    	
	    	
	    }
	    
	    public List<WorkOrder> findWorkOrdersByWeekWithStartDateAndEndDateLike(String dateStart,String dateEnd){
	    	String sqlProcedure = "{call OSS_Work_Orders_By_Week_With_Start_Date_And_End_Date(?,?)}";

			List<WorkOrder> listWorkOrders = this.jdbcTemplate.query(sqlProcedure, new WorkOrdersByStartDateLikeExtractor(),dateStart,dateEnd);
			return listWorkOrders;    	
	    	
	    }
	    
	    public List<WorkOrder> findWorkOrdersByMonthAndYear(String date){
	    	String sqlProcedure = "{call OSS_Work_Orders_By_Month_And_Year(?)}";

			List<WorkOrder> listWorkOrders = this.jdbcTemplate.query(sqlProcedure, new WorkOrdersByStartDateLikeExtractor(),date);
			return listWorkOrders;    	
	    	
	    }
	    
	    public void removeWorkOrderMaterialsById(int id){
	    	
	    	 SqlParameterSource parameterSource= new MapSqlParameterSource()
	                 .addValue("id", id);

	    	 simpleJdbcCallRemoveWorkOrderMaterialsById.setProcedureName("OSS_Work_Orders_Remove_Materials_By_Id");
	    	 simpleJdbcCallRemoveWorkOrderMaterialsById.execute(parameterSource);			  	
	    	
	    }
	    
	    public void removeWorkOrderDevicesById(int id){
	    	
	    	 SqlParameterSource parameterSource= new MapSqlParameterSource()
	                 .addValue("id", id);

	    	 simpleJdbcCallRemoveWorkOrderDevicesById.setProcedureName("OSS_Work_Orders_Remove_Devices_By_Id");
	    	 simpleJdbcCallRemoveWorkOrderDevicesById.execute(parameterSource);			  	
	    	
	    }
	    
	    public void removeWorkOrderToolsById(int id){
	    	
	    	 SqlParameterSource parameterSource= new MapSqlParameterSource()
	                 .addValue("id", id);

	    	 simpleJdbcCallRemoveWorkOrderToolsById.setProcedureName("OSS_Work_Orders_Remove_Tools_By_Id");
	    	 simpleJdbcCallRemoveWorkOrderToolsById.execute(parameterSource);			  	
	    	
	    }
	    
	    
	    
	    private static final class WorkOrdersByStartDateLikeExtractor implements ResultSetExtractor<List<WorkOrder>> {

			@Override
			public List<WorkOrder> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Map<Integer, WorkOrder> map = new HashMap<Integer, WorkOrder>();
				WorkOrder workOrder = null;
				String dateStart;
				String dateEnd;
				Employee employee;
				

				while (rs.next()) {
					Integer id = rs.getInt("id");
					employee=new Employee();
					employee.setName(rs.getString("name_employee"));
					employee.setLastName(rs.getString("last_name_employee"));
					workOrder = map.get(id);					
					if (workOrder == null) {
						workOrder = new WorkOrder();
						workOrder.getEmployees().add(employee);
						workOrder.setId(id);
						workOrder.setDescription(rs.getString("description"));
						dateStart=rs.getString("start_date");
						workOrder.setStartDate(Timestamp.valueOf(dateStart));
						dateEnd=rs.getString("end_date");
						workOrder.setEndDate(Timestamp.valueOf(dateEnd));
						workOrder.setColor(new Color(rs.getInt("color_id"),rs.getString("color"),rs.getString("state")));
						Client client=new Client();
						client.setId(rs.getString("client_id"));
						client.setContactName(rs.getString("contact_name"));
						client.setContactLastName(rs.getString("contact_last_name"));
						client.setName(rs.getString("name_client"));
						District d=new District();
						Canton c=new Canton();
						Province p=new Province();
						c.setName(rs.getString("canton_name"));
						c.getCantonId().setId(rs.getString("canton_id"));
						d.setName(rs.getString("district_name"));
						d.getDistrictId().setId(rs.getString("district_id"));
						d.getDistrictId().getCanton().setName(rs.getString("canton_name"));
						d.getDistrictId().getCanton().getCantonId().setId(rs.getString("canton_id"));;
						p.setId(rs.getString("province_id"));
						p.setName(rs.getString("province_name"));
						d.getDistrictId().setCanton(c);
						d.getDistrictId().getCanton().getCantonId().setProvince(p);
						client.setAddressDescription(new AddressDescription(rs.getInt("address_description_id")
						,rs.getString("address_description"),d));
						workOrder.setClient(client);
						workOrder.setWorkOrderType(new WorkOrderType(rs.getInt("work_order_type_id"),rs.getString("name")));
						KitWorkOrder kitWorkOrder =new KitWorkOrder();
						kitWorkOrder.setId(rs.getInt("kit_work_order_id"));
						workOrder.setkitWorkOrder(kitWorkOrder);	
						map.put(id, workOrder);

					} // End if
					else {
						workOrder.getEmployees().add(employee);
						map.put(id, workOrder);
					}
					
				}

				return new ArrayList<WorkOrder>(map.values());
			}

		}// WorkOrdersByStartDateLikeExtractor
	    
	    
	    private static final class WorkOrdersReportExtractor implements ResultSetExtractor<List<Report>> {

			@Override
			public List<Report> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Map<Integer, Report> map = new HashMap<Integer, Report>();
				Report report = null;

				while (rs.next()) {
					Integer id = rs.getInt("id");					
					report = map.get(id);					
					if (report == null) {
						report = new Report();
						report.setId(id);
						report.setDescription(rs.getString("description"));
						report.setStartDate(rs.getString("start_date"));
						report.setEndDate(rs.getString("end_date"));
						report.setState(rs.getString("state"));
						report.setNameClient(rs.getString("name_client"));
						report.setNameWorkOrderType(rs.getString("name_work_order_type"));
						map.put(id, report);

					} // End if								
				}
				return new ArrayList<Report>(map.values());
			}

		}// WorkOrdersReportExtractor

	private static final class WorkOrderExtractor implements ResultSetExtractor<List<WorkOrder>> {

		@Override
		public List<WorkOrder> extractData(ResultSet rs) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			Map<Integer, WorkOrder> map = new HashMap<Integer, WorkOrder>();
			WorkOrder workOrder = null;

			while (rs.next()) {
				Integer id = rs.getInt("id");
				workOrder = map.get(id);
				if (workOrder == null) {
					workOrder = new WorkOrder();
					workOrder.setId(id);
					workOrder.setDescription(rs.getString("description"));
					workOrder.setStartDate(new Timestamp(System.currentTimeMillis()));
					workOrder.setEndDate(new Timestamp(System.currentTimeMillis()));
					workOrder.setColor(null);
					workOrder.setClient(null);
					workOrder.setWorkOrderType(null);
					workOrder.setkitWorkOrder(null);


					map.put(id, workOrder);

				} // End if
			}
			return new ArrayList<WorkOrder>(map.values());
		}

	}// WorkOrdersReportExtractor

}

