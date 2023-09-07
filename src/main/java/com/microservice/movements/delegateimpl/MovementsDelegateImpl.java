package com.microservice.movements.delegateimpl;

import com.microservice.movements.api.MovementApiDelegate;
import com.microservice.movements.model.Movements;
import com.microservice.movements.service.MovementsService;
import com.microservice.movements.service.mappers.MapMovement;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Esta clase implementa los métodos generados por Open API.
 * */

@Service
public class MovementsDelegateImpl implements MovementApiDelegate {

  @Autowired
  private MovementsService movementsService;

  @Autowired
  private MapMovement mapMovement;

  @Override
  public ResponseEntity<List<Movements>> movementsByAccount(String clientId, String accountNumber) {

    return ResponseEntity.status(HttpStatus.OK).body(
            movementsService.findByCustomerDocumentAndAccountNumber(clientId, accountNumber)
                    .stream()
                    .filter(Objects::nonNull)
                    .map(movementsDocuments -> mapMovement.mapMovementsDocumentToMovements(movementsDocuments))
                    .collect(Collectors.toList())
    );
  }

  @Override
  public ResponseEntity<List<Movements>> movementsByCard(String clientId, String cardNumber) {

    return ResponseEntity.status(HttpStatus.OK).body(
            movementsService.findByCustomerDocumentAndCardNumber(clientId, cardNumber)
                    .stream()
                    .filter(Objects::nonNull)
                    .map(movementsDocuments -> mapMovement.mapMovementsDocumentToMovements(movementsDocuments))
                    .collect(Collectors.toList())
    );

  }

  @Override
  public ResponseEntity<List<Movements>> movementsByCredit(String clientId, String creditNumber) {

    return ResponseEntity.status(HttpStatus.OK).body(
            movementsService.findByCustomerDocumentAndCreditId(clientId, creditNumber)
                    .stream()
                    .filter(Objects::nonNull)
                    .map(movementsDocuments -> mapMovement.mapMovementsDocumentToMovements(movementsDocuments))
                    .collect(Collectors.toList())
    );
  }

  @Override
  public ResponseEntity<Void> saveMovement(Movements movements) {
    movementsService.saveMovement(movements);
    return ResponseEntity.ok().build();
  }
}
