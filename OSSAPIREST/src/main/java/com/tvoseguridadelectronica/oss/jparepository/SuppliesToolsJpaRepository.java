package com.tvoseguridadelectronica.oss.jparepository;

import com.tvoseguridadelectronica.oss.domain.SuppliesToolId;
import com.tvoseguridadelectronica.oss.domain.SuppliesTool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface SuppliesToolsJpaRepository extends JpaRepository<SuppliesTool, SuppliesToolId>{
}
