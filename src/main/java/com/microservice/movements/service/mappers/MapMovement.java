package com.microservice.movements.service.mappers;

import com.microservice.movements.documents.MovementsDocuments;
import com.microservice.movements.model.Movements;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapMovement {

  Movements mapMovementsDocumentToMovements(MovementsDocuments movementsDocuments);

  MovementsDocuments mapMovementToMovementDocument(Movements movements);
}
