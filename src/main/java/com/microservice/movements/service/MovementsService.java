package com.microservice.movements.service;

import com.microservice.movements.documents.MovementsDocuments;

import java.util.List;

public interface MovementsService {

    List<MovementsDocuments> findByCustomerDocumentAndAccountNumber(String customerDocument, String accountNumber );

    List<MovementsDocuments> findByCustomerDocumentAndCardNumber( String customerDocument, String cardNumber);

    List<MovementsDocuments> findByCustomerDocumentAndCreditId(String customerDocument, String creditId);
}
