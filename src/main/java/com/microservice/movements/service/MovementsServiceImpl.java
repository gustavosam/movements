package com.microservice.movements.service;

import com.microservice.movements.documents.MovementsDocuments;
import com.microservice.movements.model.Movements;
import com.microservice.movements.repository.MovementsRepository;
import com.microservice.movements.service.mappers.MapMovement;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * Esta clase implementa la lógica de negocio de movimientos.
 * */
@Service
public class MovementsServiceImpl implements MovementsService {

  @Autowired
  private MovementsRepository movementsRepository;

  @Autowired
  private MapMovement mapMovement;


  @Override
  public Flux<Movements> findByCustomerDocumentAndAccountNumber(
          String customerDocument, String accountNumber) {

    Flux<MovementsDocuments> movementsDocumentsFlux = movementsRepository
            .findByClientDocumentAndAccountNumber(customerDocument, accountNumber);

    return movementsDocumentsFlux
            .filter(Objects::nonNull)
            .map(movementsDocuments -> mapMovement.mapMovementsDocumentToMovements(movementsDocuments));
  }

  @Override
  public Flux<Movements> findByCustomerDocumentAndCardNumber(
          String customerDocument, String cardNumber) {

    Flux<MovementsDocuments> movementsDocumentsFlux = movementsRepository.findByClientDocumentAndCardNumber(customerDocument, cardNumber);

    return movementsDocumentsFlux
            .filter(Objects::nonNull)
            .map(movementsDocuments -> mapMovement.mapMovementsDocumentToMovements(movementsDocuments));
  }

  @Override
  public Flux<Movements> findByCustomerDocumentAndCreditId(
          String customerDocument, String creditId) {

    Flux<MovementsDocuments> movementsDocumentsFlux = movementsRepository.findByClientDocumentAndCreditNumber(customerDocument, creditId);

    return movementsDocumentsFlux
            .filter(Objects::nonNull)
            .map(movementsDocuments -> mapMovement.mapMovementsDocumentToMovements(movementsDocuments));
  }

  @Override
  public Mono<Void> saveMovement(Mono<Movements> movements) {

    Mono<MovementsDocuments> movementsDocumentsMono = movements.flatMap(movement -> {

      MovementsDocuments movementsDocuments = mapMovement.mapMovementToMovementDocument(movement);
      movementsDocuments.setMovementDate(LocalDate.now());

      return movementsRepository.save(movementsDocuments) ;
    });

    return movementsDocumentsMono.then();
  }
}
