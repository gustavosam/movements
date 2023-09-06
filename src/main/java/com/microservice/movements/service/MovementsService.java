package com.microservice.movements.service;

import com.microservice.movements.documents.MovementsDocuments;
import com.microservice.movements.model.Movements;
import java.util.List;

/**
 * Esta interfaz contiene métodos que será implementados por MovementServiceImpl.
 * */

public interface MovementsService {

  List<MovementsDocuments> findByCustomerDocumentAndAccountNumber(
          String customerDocument, String accountNumber);

  List<MovementsDocuments> findByCustomerDocumentAndCardNumber(
          String customerDocument, String cardNumber);

  List<MovementsDocuments> findByCustomerDocumentAndCreditId(
          String customerDocument, String creditId);

  void saveMovement(
          Movements saveMovements);
}
