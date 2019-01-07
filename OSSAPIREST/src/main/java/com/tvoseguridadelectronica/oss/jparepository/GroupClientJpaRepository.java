package com.tvoseguridadelectronica.oss.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvoseguridadelectronica.oss.domain.GroupClient;

@Repository
public interface GroupClientJpaRepository  extends JpaRepository<GroupClient,Integer>{

}
