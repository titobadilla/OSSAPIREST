package com.tvoseguridadelectronica.oss.jparepository;

import com.tvoseguridadelectronica.oss.domain.SuppliesMaterial;
import com.tvoseguridadelectronica.oss.domain.SuppliesMaterialId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliesMaterialJpaRepository extends JpaRepository<SuppliesMaterial, SuppliesMaterialId> {
}
