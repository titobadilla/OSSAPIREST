package com.tvoseguridadelectronica.oss.repository;

import com.tvoseguridadelectronica.oss.domain.SuppliesMaterial;
import com.tvoseguridadelectronica.oss.domain.KitWorkOrder;
import com.tvoseguridadelectronica.oss.domain.Material;
import com.tvoseguridadelectronica.oss.jparepository.KitWorkOrderJpaRepository;
import com.tvoseguridadelectronica.oss.jparepository.MaterialJpaRepository;
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
public class SuppliesMaterialDao {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    KitWorkOrderJpaRepository kitWorkOrderJpaRepository;
    MaterialJpaRepository materialJpaRepository;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource);
    }

    class ListMaterialRowMapper implements RowMapper<SuppliesMaterial> {

        @Override
        public SuppliesMaterial mapRow(ResultSet rs, int i) throws SQLException {

            SuppliesMaterial listMaterial = new SuppliesMaterial();

            KitWorkOrder kitWorkOrder = kitWorkOrderJpaRepository.findById(rs.getInt("list_work_order_id")).get();
            listMaterial.getId().setkitWorkOrder(kitWorkOrder);

            Material material = materialJpaRepository.findById(rs.getInt("material_id")).get();
            listMaterial.getId().setMaterial(material);

            listMaterial.setQuantity(rs.getInt("quantity"));

            return listMaterial;
        }
    }

    public List<SuppliesMaterial> findByIdList(int listId){

        System.out.println("metodod "+listId);

        String sqlProcedure = "execute OSS_List_Work_Order_Material "+listId;
        return this.jdbcTemplate.query(sqlProcedure, new ListMaterialRowMapper());


    }

}
