package com.microservice.movements.repository;

import com.microservice.movements.documents.MovementsDocuments;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Esta interfaz contiene los métodos necesarios para el crud con movementsDocuments.
 * */
@Repository
public interface MovementsRepository extends ReactiveMongoRepository<MovementsDocuments, String> {

  Flux<MovementsDocuments> findByClientDocumentAndAccountNumber(
          String customerDocument, String accountNumber);

  Flux<MovementsDocuments> findByClientDocumentAndCardNumber(
          String customerDocument, String cardNumber);

  Flux<MovementsDocuments> findByClientDocumentAndCreditNumber(
          String customerDocument, String creditId);
}
