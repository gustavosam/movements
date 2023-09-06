package com.microservice.movements.repository;

import com.microservice.movements.documents.MovementsDocuments;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interfaz contiene los métodos necesarios para el crud con movementsDocuments.
 * */
@Repository
public interface MovementsRepository extends MongoRepository<MovementsDocuments, String> {

  List<MovementsDocuments> findByClientDocumentAndAccountNumber(
          String customerDocument, String accountNumber);

  List<MovementsDocuments> findByClientDocumentAndCardNumber(
          String customerDocument, String cardNumber);

  List<MovementsDocuments> findByClientDocumentAndCreditNumber(
          String customerDocument, String creditId);
}
