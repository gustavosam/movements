package com.microservice.movements.service.mappers;

import com.microservice.movements.documents.MovementsDocuments;
import com.microservice.movements.model.Movements;

public class MovementsMapper {

    public static Movements mapMovementsDocumentToMovements(MovementsDocuments movementsDocuments){
        Movements movements = new Movements();

        movements.setMovementNumber(movementsDocuments.getMovementNumber());
        movements.setMovementType(movementsDocuments.getMovementType());
        movements.setCustomerDocument(movementsDocuments.getCustomerDocument());
        movements.setAccountType(movementsDocuments.getAccountType());
        movements.setAccountNumber(movementsDocuments.getAccountNumber());
        movements.setCardNumber(movementsDocuments.getCardNumber());
        movements.setCreditId(movementsDocuments.getCreditId());
        movements.setAmount(movementsDocuments.getAmount());
        movements.setMovementDate(movementsDocuments.getMovementDate());

        return movements;
    }
}
