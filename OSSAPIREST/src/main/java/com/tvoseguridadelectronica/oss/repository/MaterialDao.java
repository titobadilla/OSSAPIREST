package com.tvoseguridadelectronica.oss.repository;

import com.tvoseguridadelectronica.oss.domain.Material;
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
public class MaterialDao {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcCall=new SimpleJdbcCall(dataSource);
    }

    public void updateMaterial(Material material) throws SQLException {

        SqlParameterSource parameterSource= new MapSqlParameterSource()
                .addValue("quantity", material.getQuantity())
                .addValue("id",material.getId());

        simpleJdbcCall.setProcedureName("OSS_Material_Update_Quantity");
        Map<String, Object> outParameters= simpleJdbcCall.execute(parameterSource);

    }
}
