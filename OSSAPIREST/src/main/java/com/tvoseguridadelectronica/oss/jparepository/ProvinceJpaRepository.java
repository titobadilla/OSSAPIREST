package com.tvoseguridadelectronica.oss.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvoseguridadelectronica.oss.domain.Province;


@Repository
public interface ProvinceJpaRepository extends JpaRepository<Province,String>{

}
