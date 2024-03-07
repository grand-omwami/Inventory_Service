package com.Dsfx.Inventory_Service.Repository;

import com.Dsfx.Inventory_Service.Model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Cards, Long> {


}