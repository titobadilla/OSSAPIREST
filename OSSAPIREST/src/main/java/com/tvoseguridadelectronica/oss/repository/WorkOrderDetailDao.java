package com.tvoseguridadelectronica.oss.repository;

import com.tvoseguridadelectronica.oss.domain.Report;
import com.tvoseguridadelectronica.oss.domain.WorkOrder;
import com.tvoseguridadelectronica.oss.domain.WorkOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class WorkOrderDetailDao {

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

    public List<WorkOrderDetail> workOrderDetailsByDates(String startDate, String endDate){
        String sqlProcedure = "{call OSS_Work_Order_Detail_By_Date(?,?)}";

      List<WorkOrderDetail> list = this.jdbcTemplate.query(sqlProcedure, new WorkOrderDetailExtractor(),startDate,endDate);

      return list;

    }

    private static final class WorkOrderDetailExtractor implements ResultSetExtractor<List<WorkOrderDetail>> {

        @Override
        public List<WorkOrderDetail> extractData(ResultSet rs) throws SQLException, DataAccessException {
            // TODO Auto-generated method stub
            Map<Integer, WorkOrderDetail> map = new HashMap<Integer, WorkOrderDetail>();
            WorkOrderDetail detail = null;

            while (rs.next()) {
                Integer id = rs.getInt("id");
                detail = map.get(id);
                if (detail == null) {
                    detail = new WorkOrderDetail();
                    detail.setId(id);
                    detail.setDate(rs.getDate("date"));
                    detail.setCheckIn(rs.getString("check_in"));
                    detail.setCheckOut(rs.getString("check_out"));
                    detail.setDescription(rs.getString("description"));
                    detail.setInvoiceId(rs.getInt("invoice_id"));
                    detail.setManagerName(rs.getString("manager_name"));
                    map.put(id, detail);

                } // End if
            }
            return new ArrayList<WorkOrderDetail>(map.values());
        }

    }// WorkOrdersReportExtractor
}
