package com.microservice.movements.service;

import com.microservice.movements.documents.MovementsDocuments;
import com.microservice.movements.model.Movements;
import com.microservice.movements.repository.MovementsRepository;
import com.microservice.movements.service.mappers.MapMovement;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
  public List<MovementsDocuments> findByCustomerDocumentAndAccountNumber(
          String customerDocument, String accountNumber) {

    return movementsRepository
            .findByClientDocumentAndAccountNumber(customerDocument, accountNumber);
  }

  @Override
  public List<MovementsDocuments> findByCustomerDocumentAndCardNumber(
          String customerDocument, String cardNumber) {

    return movementsRepository.findByClientDocumentAndCardNumber(customerDocument, cardNumber);
  }

  @Override
  public List<MovementsDocuments> findByCustomerDocumentAndCreditId(
          String customerDocument, String creditId) {

    return movementsRepository.findByClientDocumentAndCreditNumber(customerDocument, creditId);
  }

  @Override
  public void saveMovement(Movements saveMovements) {

    MovementsDocuments movement = mapMovement.mapMovementToMovementDocument(saveMovements);
    movement.setMovementDate(LocalDate.now());

    movementsRepository.save(movement);
  }
}
