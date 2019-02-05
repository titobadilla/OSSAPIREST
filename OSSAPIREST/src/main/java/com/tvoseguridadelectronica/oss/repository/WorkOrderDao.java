package com.tvoseguridadelectronica.oss.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.tvoseguridadelectronica.oss.domain.Address;
import com.tvoseguridadelectronica.oss.domain.AddressDescription;
import com.tvoseguridadelectronica.oss.domain.Client;
import com.tvoseguridadelectronica.oss.domain.Color;
import com.tvoseguridadelectronica.oss.domain.ListWorkOrder;
import com.tvoseguridadelectronica.oss.domain.WorkOrder;
import com.tvoseguridadelectronica.oss.domain.WorkOrderType;


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
	    
	    
	    
	    private static final class WorkOrdersByStartDateLikeExtractor implements ResultSetExtractor<List<WorkOrder>> {

			@Override
			public List<WorkOrder> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Map<Integer, WorkOrder> map = new HashMap<Integer, WorkOrder>();
				WorkOrder workOrder = null;
				int date;
				int month;
				int year;
				int hour;
				int minute;
				int second;
				int nano=0;
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
						year=Integer.parseInt(dateStart.substring(0, 3));
						month=Integer.parseInt(dateStart.substring(5, 6));
						date=Integer.parseInt(dateStart.substring(8, 9));
						hour=Integer.parseInt(dateStart.substring(11, 12));
						minute=Integer.parseInt(dateStart.substring(14, 15));
						second=Integer.parseInt(dateStart.substring(17, 18));	
						workOrder.setStartDate(new Timestamp(year,month,date,hour,minute,second,nano));
						dateEnd=rs.getString("end_date");
						year=Integer.parseInt(dateEnd.substring(0, 3));
						month=Integer.parseInt(dateEnd.substring(5, 6));
						date=Integer.parseInt(dateEnd.substring(8, 9));
						hour=Integer.parseInt(dateEnd.substring(11, 12));
						minute=Integer.parseInt(dateEnd.substring(14, 15));
						second=Integer.parseInt(dateEnd.substring(17, 18));
						workOrder.setEndDate(new Timestamp(year,month,date,hour,minute,second,nano));
						workOrder.setColor(new Color(rs.getInt("color_id"),rs.getString("color"),rs.getString("state")));
						Client client=new Client();
						client.setId(rs.getString("client_id"));
						client.setContactName(rs.getString("contact_name"));
						client.setContactLastName(rs.getString("contact_last_name"));
						client.setName(rs.getString("name_client"));
						client.setAddressDescription(new AddressDescription(rs.getInt("address_description_id")
						,rs.getString("address_description")
						,new Address(rs.getInt("address_id"),rs.getString("province"),rs.getString("district"),rs.getString("canton"))));
						workOrder.setClient(client);
						workOrder.setWorkOrderType(new WorkOrderType(rs.getInt("work_order_type_id"),rs.getString("name")));
						ListWorkOrder listWorkOrder=new ListWorkOrder();
						listWorkOrder.setId(rs.getInt("list_work_order_id"));
						workOrder.setListWorkOrder(listWorkOrder);						
						map.put(id, workOrder);

					} // End if
					
				}

				return new ArrayList<WorkOrder>(map.values());
			}

		}// WorkOrdersByStartDateLikeExtractor

}

