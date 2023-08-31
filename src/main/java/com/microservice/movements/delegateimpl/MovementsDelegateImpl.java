package com.microservice.movements.delegateimpl;

import com.microservice.movements.api.CustomerApiDelegate;
import com.microservice.movements.model.Movements;
import com.microservice.movements.service.MovementsService;
import com.microservice.movements.service.mappers.MovementsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MovementsDelegateImpl implements CustomerApiDelegate {

    @Autowired
    private MovementsService movementsService;

    @Override
    public ResponseEntity<List<Movements>> getMovementsByAccount(String customerId, String accountNumber){

        return ResponseEntity.status(HttpStatus.OK).body(
                movementsService.findByCustomerDocumentAndAccountNumber(customerId, accountNumber)
                        .stream().filter(Objects::nonNull).map(MovementsMapper::mapMovementsDocumentToMovements).collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<List<Movements>> getMovementsByCard(String customerId, String cardNumber){

        return ResponseEntity.status(HttpStatus.OK).body(
                movementsService.findByCustomerDocumentAndCardNumber(customerId, cardNumber)
                        .stream().filter(Objects::nonNull).map(MovementsMapper::mapMovementsDocumentToMovements).collect(Collectors.toList())
        );

    }

    @Override
    public ResponseEntity<List<Movements>> getMovementsByCredit(String customerId, String creditNumber){

        return ResponseEntity.status(HttpStatus.OK).body(
                movementsService.findByCustomerDocumentAndCreditId(customerId, creditNumber)
                        .stream().filter(Objects::nonNull).map(MovementsMapper::mapMovementsDocumentToMovements).collect(Collectors.toList())
        );
    }
}
