package com.tvoseguridadelectronica.oss.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvoseguridadelectronica.oss.domain.TelephoneEmployee;

@Repository
public interface TelephoneEmployeeJpaRepository extends JpaRepository<TelephoneEmployee,Integer>{
	
	List<TelephoneEmployee> findByEmployeeId(String id);
}
