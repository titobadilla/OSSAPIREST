package com.tvoseguridadelectronica.oss.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.tvoseguridadelectronica.oss.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.tvoseguridadelectronica.oss.domain.KitWorkOrder;


@Repository
public class WorkOrderDao {
	
	 private JdbcTemplate jdbcTemplate;
	    private SimpleJdbcCall simpleJdbcCall;

	    @Autowired
	    public void setDataSource(DataSource dataSource){
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	        this.simpleJdbcCall = new SimpleJdbcCall(dataSource);
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
	    
	    
	    
	    private static final class WorkOrdersByStartDateLikeExtractor implements ResultSetExtractor<List<WorkOrder>> {

			@Override
			public List<WorkOrder> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Map<Integer, WorkOrder> map = new HashMap<Integer, WorkOrder>();
				WorkOrder workOrder = null;
				String dateStart;
				String dateEnd;
				

				while (rs.next()) {
					Integer id = rs.getInt("id");
					workOrder = map.get(id);
					if (workOrder == null) {
						workOrder = new WorkOrder();
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
						client.setAddressDescription(new AddressDescription(rs.getInt("address_description_id")
						,rs.getString("address_description")
						,new Province(rs.getString("province_id"),rs.getString("province_name")),
						new Canton(new CantonId(rs.getString("canton_id"),new Province())
								,rs.getString("canton_name")),
						new District(new DistrictId(rs.getString("district_id"),new Province(),new Canton())
								,rs.getString("district_name"))));
						workOrder.setClient(client);
						workOrder.setWorkOrderType(new WorkOrderType(rs.getInt("work_order_type_id"),rs.getString("name")));
						KitWorkOrder kitWorkOrder =new KitWorkOrder();
						kitWorkOrder.setId(rs.getInt("list_work_order_id"));
						workOrder.setListWorkOrder(kitWorkOrder);
						map.put(id, workOrder);

					} // End if
					
				}

				return new ArrayList<WorkOrder>(map.values());
			}

		}// WorkOrdersByStartDateLikeExtractor

}

