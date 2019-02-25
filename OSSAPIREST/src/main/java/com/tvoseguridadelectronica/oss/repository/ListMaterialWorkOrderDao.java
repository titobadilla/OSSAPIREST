package com.tvoseguridadelectronica.oss.repository;

import com.tvoseguridadelectronica.oss.domain.ListMaterialWorkOrder;
import com.tvoseguridadelectronica.oss.domain.ListWorkOrder;
import com.tvoseguridadelectronica.oss.domain.Material;
import com.tvoseguridadelectronica.oss.jparepository.ListWorkOrderJpaRepository;
import com.tvoseguridadelectronica.oss.jparepository.MaterialJpaRepository;
import com.tvoseguridadelectronica.oss.restcontroller.ListWorkOrderRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ListMaterialWorkOrderDao {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    ListWorkOrderJpaRepository listWorkOrderJpaRepository;
    MaterialJpaRepository materialJpaRepository;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource);
    }

    class ListMaterialRowMapper implements RowMapper<ListMaterialWorkOrder> {

        @Override
        public ListMaterialWorkOrder mapRow(ResultSet rs, int i) throws SQLException {

            ListMaterialWorkOrder listMaterial = new ListMaterialWorkOrder();

            ListWorkOrder listWorkOrder = listWorkOrderJpaRepository.findById(rs.getInt("list_work_order_id")).get();
            listMaterial.getId().setListWorkOrder(listWorkOrder);

            Material material = materialJpaRepository.findById(rs.getInt("material_id")).get();
            listMaterial.getId().setMaterial(material);

            listMaterial.setQuantity(rs.getInt("quantity"));

            return listMaterial;
        }
    }

    public List<ListMaterialWorkOrder> findByIdList(int listId){

        System.out.println("metodod "+listId);

        String sqlProcedure = "execute OSS_List_Work_Order_Material "+listId;
        return this.jdbcTemplate.query(sqlProcedure, new ListMaterialRowMapper());


    }

}
