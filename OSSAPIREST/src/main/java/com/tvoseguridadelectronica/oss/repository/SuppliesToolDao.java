package com.tvoseguridadelectronica.oss.repository;

import com.tvoseguridadelectronica.oss.domain.SuppliesTools;
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
public class SuppliesToolDao {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource);
    }

    class ListToolRowMapper implements RowMapper<SuppliesTools> {

        @Override
        public SuppliesTools mapRow(ResultSet rs, int i) throws SQLException {

            SuppliesTools listTool = new SuppliesTools();
            listTool.getId().getListWorkOrder().setId(rs.getInt("list_work_order_id"));
            listTool.getId().getTool().setId(rs.getInt("Tool_id"));
            listTool.setQuantity(rs.getInt("quantity"));

            return listTool;
        }
    }

    public List<SuppliesTools> findByIdList(int listId){

        String sqlProcedure = "{call OSS_List_Work_Order_Tool (?)}";

        List<SuppliesTools> suppliesTools = this.jdbcTemplate.query(sqlProcedure, new ListToolRowMapper(),listId);

        return suppliesTools;

    }
    
}
