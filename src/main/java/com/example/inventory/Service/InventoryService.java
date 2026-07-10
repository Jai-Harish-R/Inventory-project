package com.example.inventory.Service;

import com.example.inventory.Entity.Inventory;
import com.example.inventory.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository invrep;

    // Add New Item
    public Inventory addItem(Inventory inventory){
        return invrep.save(inventory);
    }

    // Show All Inventory

    // Reduce Stock
    public String reduceStock(Long itemID, Integer quantity){

        Inventory item = invrep.findById(itemID).orElse(null);

        if(item == null)
            return "Item Not Found";

        if(item.getQuantity() < quantity)
            return "Insufficient Stock";

        item.setQuantity(item.getQuantity() - quantity);

        invrep.save(item);

        return "Stock Reduced Successfully";
    }

    // Increase Stock
    public String addStock(Long itemID, Integer quantity){

        Inventory item = invrep.findById(itemID).orElse(null);

        if(item == null)
            return "Item Not Found";

        item.setQuantity(item.getQuantity() + quantity);

        invrep.save(item);

        return "Stock Added Successfully";
    }
}