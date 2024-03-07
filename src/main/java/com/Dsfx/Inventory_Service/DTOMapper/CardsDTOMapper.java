package com.Dsfx.Inventory_Service.DTOMapper;

import com.Dsfx.Inventory_Service.DTO.CardsDTO;
import com.Dsfx.Inventory_Service.Model.Cards;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardsDTOMapper {
    CardsDTOMapper INSTANCE = Mappers.getMapper(CardsDTOMapper.class);

    default Cards mapCards() {
        return mapCards(null);
    }

    Cards mapCards(CardsDTO cardsDTO);

    Cards MappedCards(CardsDTO cardsDTO);

}


