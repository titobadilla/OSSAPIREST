package com.tvoseguridadelectronica.oss.jparepository;

import com.tvoseguridadelectronica.oss.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelJpaRepository extends JpaRepository<Model,Integer> {
}
