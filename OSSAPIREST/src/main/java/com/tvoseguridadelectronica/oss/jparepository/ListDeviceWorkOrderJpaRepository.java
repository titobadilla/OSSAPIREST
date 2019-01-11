package com.tvoseguridadelectronica.oss.jparepository;

import com.tvoseguridadelectronica.oss.domain.ListDeviceWorkOrder;
import com.tvoseguridadelectronica.oss.domain.ListDeviceWorkOrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface ListDeviceWorkOrderJpaRepository extends JpaRepository<ListDeviceWorkOrder, ListDeviceWorkOrderId> {
}
