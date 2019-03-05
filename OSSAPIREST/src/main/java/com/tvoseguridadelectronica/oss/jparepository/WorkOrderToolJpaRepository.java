package com.tvoseguridadelectronica.oss.jparepository;

import com.tvoseguridadelectronica.oss.domain.WorkOrderTool;
import com.tvoseguridadelectronica.oss.domain.WorkOrderToolId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderToolJpaRepository extends JpaRepository<WorkOrderTool, WorkOrderToolId> {
}
