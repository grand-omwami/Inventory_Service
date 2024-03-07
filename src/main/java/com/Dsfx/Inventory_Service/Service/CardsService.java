package com.Dsfx.Inventory_Service.Service;

import com.Dsfx.Inventory_Service.DTO.CardsDTO;
import com.Dsfx.Inventory_Service.DTOMapper.CardsDTOMapper;
import com.Dsfx.Inventory_Service.Model.Cards;
import com.Dsfx.Inventory_Service.Repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CardsService {
    public CardRepository cardRepository;
    public CardsDTOMapper cardsDTOMapper;

    public Cards addCardToInventory(CardsDTO cardsDTO) {

        Cards card = cardsDTOMapper.INSTANCE.MappedCards(cardsDTO);
        return cardRepository.save(card);
    }

    public List<Cards> getAllCards() throws ChangeSetPersister.NotFoundException {

        List<Cards> allCards = cardRepository.findAll();
        if (allCards.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        return allCards;

    }

    public Cards getByCardId(Long cardId) throws ChangeSetPersister.NotFoundException {

        Optional<Cards> cardOptional = cardRepository.findById(cardId);
        if (cardOptional.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        return cardOptional.get();

    }

    public List<Cards> updateInventory(Long cardId) throws ChangeSetPersister.NotFoundException {

        Optional<Cards> cardOptional = cardRepository.findById(cardId);
        if (cardOptional.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }

        Cards existingCard = cardOptional.get();



        Cards updatedCard = cardRepository.save(existingCard);

        return Collections.singletonList(updatedCard); // Return a list with the updated card

    }

    public List<Cards> deleteCardsFromInventory(Long cardId) throws ChangeSetPersister.NotFoundException {

        Optional<Cards> cardOptional = cardRepository.findById(cardId);
        if (cardOptional.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }

        Cards deletedCard = cardOptional.get();


        cardRepository.delete(deletedCard);

        return Collections.singletonList(deletedCard); // Return a list with the deleted card

    }
}
