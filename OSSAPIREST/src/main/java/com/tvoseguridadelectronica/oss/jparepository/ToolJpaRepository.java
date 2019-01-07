package com.tvoseguridadelectronica.oss.jparepository;

import com.tvoseguridadelectronica.oss.domain.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolJpaRepository extends JpaRepository<Tool,Integer> {
}
