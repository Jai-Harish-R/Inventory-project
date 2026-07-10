package com.example.inventory.Controller;

import com.example.inventory.Entity.Inventory;
import com.example.inventory.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    @Autowired
    private InventoryService invser;

    @PostMapping
    public Inventory addItem(@RequestBody Inventory inventory){
        return invser.addItem(inventory);
    }


    @PutMapping("/reduce")
    public String reduceStock(@RequestParam Long itemID,
                              @RequestParam Integer quantity){
        return invser.reduceStock(itemID, quantity);
    }

    @PutMapping("/add")
    public String addStock(@RequestParam Long itemID,
                           @RequestParam Integer quantity){
        return invser.addStock(itemID, quantity);
    }

}