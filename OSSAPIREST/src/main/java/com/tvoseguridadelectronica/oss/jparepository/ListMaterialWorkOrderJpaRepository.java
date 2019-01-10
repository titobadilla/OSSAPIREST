package com.tvoseguridadelectronica.oss.jparepository;

import com.tvoseguridadelectronica.oss.domain.ListMaterialWorkOrder;
import com.tvoseguridadelectronica.oss.domain.ListMaterialWorkOrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListMaterialWorkOrderJpaRepository extends JpaRepository<ListMaterialWorkOrder, ListMaterialWorkOrderId> {
}
