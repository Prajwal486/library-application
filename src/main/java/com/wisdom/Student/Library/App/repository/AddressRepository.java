package com.wisdom.Student.Library.App.repository;

import com.wisdom.Student.Library.App.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

}
