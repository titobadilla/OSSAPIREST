package com.tvoseguridadelectronica.oss.jparepository;

import com.tvoseguridadelectronica.oss.domain.DeviceState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceStateJpaRepository extends JpaRepository<DeviceState,Integer> {
}
