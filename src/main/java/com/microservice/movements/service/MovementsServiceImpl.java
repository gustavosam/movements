package com.microservice.movements.service;

import com.microservice.movements.documents.MovementsDocuments;
import com.microservice.movements.repository.MovementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementsServiceImpl implements MovementsService {

    @Autowired
    private MovementsRepository movementsRepository;


    @Override
    public List<MovementsDocuments> findByCustomerDocumentAndAccountNumber(String customerDocument, String accountNumber) {
        return movementsRepository.findByCustomerDocumentAndAccountNumber(customerDocument, accountNumber);
    }

    @Override
    public List<MovementsDocuments> findByCustomerDocumentAndCardNumber(String customerDocument, String cardNumber) {
        return movementsRepository.findByCustomerDocumentAndCardNumber(customerDocument, cardNumber);
    }

    @Override
    public List<MovementsDocuments> findByCustomerDocumentAndCreditId(String customerDocument, String creditId) {
        return movementsRepository.findByCustomerDocumentAndCreditId(customerDocument, creditId);
    }
}
