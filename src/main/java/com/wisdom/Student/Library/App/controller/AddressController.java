package com.wisdom.Student.Library.App.controller;

import com.wisdom.Student.Library.App.entity.Address;
import com.wisdom.Student.Library.App.entity.Student;
import com.wisdom.Student.Library.App.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> getAddress(){
        List<Address> address=addressService.getAddress();
        if (address.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(address);
    }
    @GetMapping("{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id){
        Optional<Address> address=addressService.findById(id);
        if (address.isPresent()){
            return ResponseEntity.ok(address.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        Address createdAddress=addressService.createAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }
    @PutMapping("{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id,@RequestBody Address address){
        Address updatedAddress= addressService.updateAddress(id,address);
        if (updatedAddress==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedAddress);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }

}
