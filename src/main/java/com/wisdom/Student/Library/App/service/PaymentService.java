package com.wisdom.Student.Library.App.service;

import com.wisdom.Student.Library.App.entity.Payment;
import com.wisdom.Student.Library.App.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getPayment(){
        return paymentRepository.findAll();
    }
    public Optional<Payment> findById(Long id){
        return paymentRepository.findById(id);
    }

    public Payment createPayment(Payment payment){
        return paymentRepository.save(payment);
    }
    public Payment updatePayment(Long id,Payment payment){
        if (!paymentRepository.existsById(id)){
            return null;
        }
        return paymentRepository.save(payment);
    }
    public void deletePayment(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Payment not found with this id:" + id);
        }
        paymentRepository.deleteById(id);
    }
}
