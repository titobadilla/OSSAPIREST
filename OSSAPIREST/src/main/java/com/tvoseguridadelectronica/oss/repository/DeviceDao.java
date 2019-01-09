package com.tvoseguridadelectronica.oss.repository;

import com.tvoseguridadelectronica.oss.domain.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

@Repository
public class DeviceDao {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcCall=new SimpleJdbcCall(dataSource);
    }

    public Device updateDevice(Device device) throws SQLException {

        SqlParameterSource parameterSource= new MapSqlParameterSource()
                .addValue("quantity", device.getQuantity())
                .addValue("id",device.getId());

        simpleJdbcCall.setProcedureName("OSS_Device_Update_Quantity");
        Map<String, Object> outParameters= simpleJdbcCall.execute(parameterSource);

        return device;
    }

}
