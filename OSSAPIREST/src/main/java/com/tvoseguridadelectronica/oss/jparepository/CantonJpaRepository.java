package com.tvoseguridadelectronica.oss.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvoseguridadelectronica.oss.domain.Canton;
import com.tvoseguridadelectronica.oss.domain.CantonId;

@Repository
public interface CantonJpaRepository extends JpaRepository<Canton,CantonId>{

	List<Canton> findByCantonIdProvinceId(String id);

}
