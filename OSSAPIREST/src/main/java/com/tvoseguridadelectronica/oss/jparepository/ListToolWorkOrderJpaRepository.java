package com.tvoseguridadelectronica.oss.jparepository;

import com.tvoseguridadelectronica.oss.domain.ListToolWorkOrder;
import com.tvoseguridadelectronica.oss.domain.ListToolWorkOrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface ListToolWorkOrderJpaRepository extends JpaRepository<ListToolWorkOrder, ListToolWorkOrderId>{
}
