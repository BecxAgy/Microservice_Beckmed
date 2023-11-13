package com.ms.mspatient.repositories;


import com.ms.mspatient.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
