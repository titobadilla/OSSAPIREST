package com.tvoseguridadelectronica.oss.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvoseguridadelectronica.oss.domain.Telephone;

@Repository
public interface TelephoneJpaRepository extends JpaRepository<Telephone,Integer>{

}
