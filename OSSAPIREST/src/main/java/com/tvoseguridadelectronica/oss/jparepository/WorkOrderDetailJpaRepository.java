package com.tvoseguridadelectronica.oss.jparepository;

import com.tvoseguridadelectronica.oss.domain.WorkOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public  interface WorkOrderDetailJpaRepository extends JpaRepository<WorkOrderDetail, Integer> {


   ArrayList<WorkOrderDetail> findWorkOrderDetailByDateBetween (Date f1, Date f2);
}
