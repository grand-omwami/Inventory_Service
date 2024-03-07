package com.Dsfx.Inventory_Service.Controller;

import com.Dsfx.Inventory_Service.DTO.CardsDTO;
import com.Dsfx.Inventory_Service.Model.Cards;
import com.Dsfx.Inventory_Service.Service.CardsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/v1")
public class CardController {

    public CardsService cardService;



    @PostMapping("/ADD")
    public ResponseEntity<Cards> addCardToInventory(@RequestBody CardsDTO cardsDTO) {

        Cards newCard = cardService.addCardToInventory(cardsDTO);
        return new ResponseEntity<>(newCard, HttpStatus.CREATED);


    }

    @GetMapping("/GETALL")
    public ResponseEntity<List<Cards>> getAllCards() throws ChangeSetPersister.NotFoundException {

        List<Cards> allCards = cardService.getAllCards();
        return new ResponseEntity<>(allCards, HttpStatus.OK);

    }



    @GetMapping("/RETRIEVE")
    public ResponseEntity<Cards> getByCardId(@RequestParam Long cardId) throws ChangeSetPersister.NotFoundException {

        Cards card = cardService.getByCardId(cardId);
        if (card != null) {
            return new ResponseEntity<>(card, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/UPDATE")
    public ResponseEntity<List<Cards>> updateInventory(@RequestParam Long cardId) throws ChangeSetPersister.NotFoundException {

        List<Cards> updatedCards = cardService.updateInventory(cardId);
        if (updatedCards != null && !updatedCards.isEmpty()) {
            return new ResponseEntity<>(updatedCards, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/DELETE")
    public ResponseEntity<List<Cards>> deleteCardsFromInventory(@RequestParam Long cardId) throws ChangeSetPersister.NotFoundException {

        List<Cards> deletedCards = cardService.deleteCardsFromInventory(cardId);
        if (deletedCards != null && !deletedCards.isEmpty()) {
            return new ResponseEntity<>(deletedCards, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }}
//  @PostMapping("/uploadExcelFile")
//  public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
//    String fileName = file.getOriginalFilename();
//    if (fileName == null || fileName.isEmpty()) {
//      model.addAttribute("message", "No file uploaded!");
//      return "excel";
//    }
//
//    try {
//      if (file.isEmpty()) {
//        model.addAttribute("message", "No file uploaded!");
//        return "excel";
//      }
//
//      byte[] bytes = file.getBytes();
//      String contentType = file.getContentType();
//      if (contentType == null) {
//        model.addAttribute("message", "Invalid file format!");
//        return "excel";
//      }
//
//      // Perform file validation and sanitization here
//
//      // Save the file to the repository
//
//      cardRepository.add(bytes, fileName, contentType);
//
//      model.addAttribute("message", "File: " + fileName + " has been uploaded successfully!");
//    } catch (IOException e) {
//      model.addAttribute("message", "Error uploading file: " + e.getMessage());
//      return "excel";
//    }
//
//    return "excel";
//  }}

