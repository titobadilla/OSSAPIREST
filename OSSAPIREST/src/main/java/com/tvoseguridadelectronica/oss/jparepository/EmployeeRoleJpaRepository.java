package com.tvoseguridadelectronica.oss.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tvoseguridadelectronica.oss.domain.EmployeeRole;

@Repository
public interface EmployeeRoleJpaRepository extends JpaRepository<EmployeeRole,Integer>{

}
