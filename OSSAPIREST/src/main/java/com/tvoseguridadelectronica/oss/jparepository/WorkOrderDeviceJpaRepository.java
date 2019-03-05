package com.tvoseguridadelectronica.oss.jparepository;

import com.tvoseguridadelectronica.oss.domain.WorkOrderDevice;
import com.tvoseguridadelectronica.oss.domain.WorkOrderDeviceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderDeviceJpaRepository extends JpaRepository<WorkOrderDevice, WorkOrderDeviceId> {
}
