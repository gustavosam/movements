package com.microservice.movements.repository;

import com.microservice.movements.documents.MovementsDocuments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementsRepository extends MongoRepository<MovementsDocuments, String> {

    List<MovementsDocuments> findByCustomerDocumentAndAccountNumber(String customerDocument, String accountNumber );

    List<MovementsDocuments> findByCustomerDocumentAndCardNumber( String customerDocument, String cardNumber);

    List<MovementsDocuments> findByCustomerDocumentAndCreditId(String customerDocument, String creditId);
}
