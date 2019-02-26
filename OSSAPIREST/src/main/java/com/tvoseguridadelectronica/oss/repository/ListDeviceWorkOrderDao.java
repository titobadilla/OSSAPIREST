package com.tvoseguridadelectronica.oss.repository;

import com.tvoseguridadelectronica.oss.domain.ListDeviceWorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ListDeviceWorkOrderDao {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource);
    }

    class ListDeviceRowMapper implements RowMapper<ListDeviceWorkOrder> {

        @Override
        public ListDeviceWorkOrder mapRow(ResultSet rs, int i) throws SQLException {

            ListDeviceWorkOrder listDevice = new ListDeviceWorkOrder();
            listDevice.getId().getListWorkOrder().setId(rs.getInt("list_work_order_id"));
            listDevice.getId().getDevice().setId(rs.getInt("Device_id"));
            listDevice.setQuantity(rs.getInt("quantity"));

            return listDevice;
        }
    }

    public List<ListDeviceWorkOrder> findByIdList(int listId){

        String sqlProcedure = "{call OSS_List_Work_Order_Device (?)}";

        List<ListDeviceWorkOrder> listDeviceWorkOrders = this.jdbcTemplate.query(sqlProcedure, new ListDeviceRowMapper(),listId);

        return listDeviceWorkOrders;

    }

}
