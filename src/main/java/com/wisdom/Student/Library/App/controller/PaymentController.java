package com.wisdom.Student.Library.App.controller;

import com.wisdom.Student.Library.App.entity.Payment;
import com.wisdom.Student.Library.App.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @GetMapping
    public ResponseEntity<List<Payment>> getPayment(){
        List<Payment> payments=paymentService.getPayment();
        if (payments.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(payments);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id){
        Optional<Payment> payments=paymentService.findById(id);
        if(payments.isPresent()){
            return ResponseEntity.ok(payments.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment){
        Payment createdPayments=paymentService.createPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPayments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id,@RequestBody Payment payment){
        Payment updatedPayments=paymentService.updatePayment(id,payment);
        if (updatedPayments==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedPayments);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id){
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

}
