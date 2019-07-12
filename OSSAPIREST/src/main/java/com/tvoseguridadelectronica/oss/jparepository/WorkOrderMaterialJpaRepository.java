package com.tvoseguridadelectronica.oss.jparepository;

import com.tvoseguridadelectronica.oss.domain.WorkOrderMaterial;
import com.tvoseguridadelectronica.oss.domain.WorkOrderMaterialId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderMaterialJpaRepository extends JpaRepository<WorkOrderMaterial, WorkOrderMaterialId> {
	
}
