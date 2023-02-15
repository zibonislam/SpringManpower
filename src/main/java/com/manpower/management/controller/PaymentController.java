package com.manpower.management.controller;

import com.manpower.management.entity.PaymentEntity;

import com.manpower.management.repository.PaymentRepository;
import com.manpower.management.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class PaymentController {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    private PostRepository postRepository;


    @PostMapping("/payment/posts")
    PaymentEntity newPost(@RequestBody PaymentEntity newPayment) {
        System.out.println("test Hit");

        return paymentRepository.save(newPayment);
    }


    @GetMapping("/payment/posts")
    List<PaymentEntity> getAll() {
        System.out.println("test Hit");

        return paymentRepository.findAll();
    }
    // Single item

    @GetMapping("/payment/posts/{id}")
    PaymentEntity one(@PathVariable Long id) {
        Optional<PaymentEntity> paymentEntity =  paymentRepository.findById(id);
        return paymentEntity.get();
    }

    @PutMapping("/payment/posts/{id}")
    PaymentEntity payment(@RequestBody PaymentEntity paymentEntity, @PathVariable Long id) {

        return paymentRepository.findById(id)
                .map(post -> {
                    post.setName(paymentEntity.getName());
                    post.setNumber(paymentEntity.getNumber());
                    post.setExpiry(paymentEntity.getExpiry());
                    post.setCvc(paymentEntity.getCvc());
                    post.setCity(paymentEntity.getCity());
                    post.setZipcode(paymentEntity.getZipcode());

                    return paymentRepository.save(post);
                })
                .orElseGet(() -> {
                    paymentEntity.setId(id);
                    return paymentRepository.save(paymentEntity);
                });
    }

}
