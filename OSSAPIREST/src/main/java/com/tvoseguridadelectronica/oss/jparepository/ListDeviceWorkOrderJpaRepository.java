package com.tvoseguridadelectronica.oss.jparepository;

import com.tvoseguridadelectronica.oss.domain.ListDeviceWorkOrder;
import com.tvoseguridadelectronica.oss.domain.ListDeviceWorkOrderId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface ListDeviceWorkOrderJpaRepository extends JpaRepository<ListDeviceWorkOrder, ListDeviceWorkOrderId> {
	List<ListDeviceWorkOrder> findByIdListWorkOrderId(int id);
}
