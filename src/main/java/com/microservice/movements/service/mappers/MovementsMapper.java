package com.microservice.movements.service.mappers;

import com.microservice.movements.documents.MovementsDocuments;
import com.microservice.movements.model.Movements;

/**
 * Esta clase contiene métodos mappers.
 * */
public class MovementsMapper {

  /**
   * Este método permite convertir una clase MovementDocs a Movements.
   * */
  public static Movements mapMovementsDocumentToMovements(MovementsDocuments movementsDocuments) {
    Movements movements = new Movements();

    movements.setMovementNumber(movementsDocuments.getMovementNumber());
    movements.setMovementType(movementsDocuments.getMovementType());
    movements.setClientDocument(movementsDocuments.getClientDocument());
    movements.setAccountType(movementsDocuments.getAccountType());
    movements.setAccountNumber(movementsDocuments.getAccountNumber());
    movements.setCardNumber(movementsDocuments.getCardNumber());
    movements.setCreditNumber(movementsDocuments.getCreditNumber());
    movements.setAmount(movementsDocuments.getAmount());
    movements.setMovementDate(movementsDocuments.getMovementDate());

    return movements;
  }
}
