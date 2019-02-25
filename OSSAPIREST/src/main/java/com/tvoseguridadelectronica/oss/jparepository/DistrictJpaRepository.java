package com.tvoseguridadelectronica.oss.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvoseguridadelectronica.oss.domain.District;
import com.tvoseguridadelectronica.oss.domain.DistrictId;

@Repository
public interface DistrictJpaRepository extends JpaRepository<District, DistrictId>{

}
