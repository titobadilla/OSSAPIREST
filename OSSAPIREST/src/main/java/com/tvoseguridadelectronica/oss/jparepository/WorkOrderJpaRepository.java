package com.tvoseguridadelectronica.oss.jparepository;

import com.tvoseguridadelectronica.oss.domain.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOrderJpaRepository extends JpaRepository<WorkOrder,Integer> {
}
