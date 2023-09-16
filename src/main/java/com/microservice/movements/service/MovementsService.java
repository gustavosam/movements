package com.microservice.movements.service;

import com.microservice.movements.model.Movements;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Esta interfaz contiene métodos que será implementados por MovementServiceImpl.
 * */

public interface MovementsService {

  Flux<Movements> findByCustomerDocumentAndAccountNumber(
          String customerDocument, String accountNumber);

  Flux<Movements> findByCustomerDocumentAndCardNumber(
          String customerDocument, String cardNumber);

  Flux<Movements> findByCustomerDocumentAndCreditId(
          String customerDocument, String creditId);

  Mono<Void> saveMovement(
          Mono<Movements> movements);
}
