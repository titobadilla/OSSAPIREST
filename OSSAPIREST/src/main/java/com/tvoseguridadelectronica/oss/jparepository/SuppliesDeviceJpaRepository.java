package com.tvoseguridadelectronica.oss.jparepository;


import com.tvoseguridadelectronica.oss.domain.SuppliesDevice;
import com.tvoseguridadelectronica.oss.domain.SuppliesDeviceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface SuppliesDeviceJpaRepository extends JpaRepository<SuppliesDevice, SuppliesDeviceId> {
}
