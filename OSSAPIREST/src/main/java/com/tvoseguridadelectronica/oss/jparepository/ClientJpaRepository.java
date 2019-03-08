package com.tvoseguridadelectronica.oss.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tvoseguridadelectronica.oss.domain.Client;

import java.util.List;

@Repository
public interface ClientJpaRepository  extends JpaRepository<Client,String>{
	
	Client findByContactNameIsLike(String contactName);

	List<Client> findByGroup_IdGroup (int idGroup);

}
