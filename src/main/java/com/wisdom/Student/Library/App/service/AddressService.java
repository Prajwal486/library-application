package com.wisdom.Student.Library.App.service;

import com.wisdom.Student.Library.App.entity.Address;
import com.wisdom.Student.Library.App.repository.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAddress(){
        return addressRepository.findAll();
    }
    public Optional<Address> findById(Long id){
        return addressRepository.findById(id);
    }
    public Address createAddress( Address address){
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id,Address address){
        if (!addressRepository.existsById(id)){
            return null;
        }
        address.setStudentId(id);
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id){
        if (!addressRepository.existsById(id)){
            throw new EntityNotFoundException("address not found with this ID:"+id);
        }
        addressRepository.deleteById(id);
    }

}
