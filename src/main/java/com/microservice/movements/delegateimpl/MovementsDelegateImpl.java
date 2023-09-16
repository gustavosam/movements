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
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
  public Mono<ResponseEntity<Flux<Movements>>> movementsByAccount(String clientId,
                                                                  String accountNumber,
                                                                  ServerWebExchange exchange) {

    Flux<Movements> movementsFlux = movementsService.findByCustomerDocumentAndAccountNumber(clientId, accountNumber);

    return Mono.just(ResponseEntity.ok(movementsFlux));
  }

  @Override
  public Mono<ResponseEntity<Flux<Movements>>> movementsByCard(String clientId,
                                                               String cardNumber,
                                                               ServerWebExchange exchange) {

    Flux<Movements> movementsFlux = movementsService.findByCustomerDocumentAndCardNumber(clientId, cardNumber);

    return Mono.just(ResponseEntity.ok(movementsFlux));
  }

  @Override
  public Mono<ResponseEntity<Flux<Movements>>> movementsByCredit(String clientId,
                                                                 String creditNumber,
                                                                 ServerWebExchange exchange) {

    Flux<Movements> movementsFlux = movementsService.findByCustomerDocumentAndCreditId(clientId, creditNumber);

    return Mono.just(ResponseEntity.ok(movementsFlux));
  }

  @Override
  public Mono<ResponseEntity<Void>> saveMovement(Mono<Movements> movements,
                                                 ServerWebExchange exchange) {


    Mono<Void> voidMono = movementsService.saveMovement(movements);

    return voidMono.map(ResponseEntity::ok);
  }
}
