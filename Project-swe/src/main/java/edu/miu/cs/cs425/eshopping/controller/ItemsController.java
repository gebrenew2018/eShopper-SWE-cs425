package edu.miu.cs.cs425.eshopping.controller;

import edu.miu.cs.cs425.eshopping.model.Customer;
import edu.miu.cs.cs425.eshopping.model.Items;
import edu.miu.cs.cs425.eshopping.service.ICustomerServ;
import edu.miu.cs.cs425.eshopping.service.IItemsServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//@RequestMapping("/items")
//@RestController
//@CrossOrigin(origins="http://localhost:4200")
//@RequestMapping(value="/api/items")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/items"})
public class ItemsController {
    @Autowired
    private IItemsServ iItemsServ;

    @GetMapping("/list/{search}")
    public List<Items> getAllItems(@PathVariable String search) {
        return iItemsServ.getAllItems(search);
    }

    @PostMapping
    public Items addItems(@RequestBody Items item) {
        return iItemsServ.addItems(item);
    }

    @PutMapping("/edit/{id}")
    public Items updateItem(@PathVariable long id, @RequestBody Items items) {
        Items result = iItemsServ.getItems(id).orElse(items);
        result.setItemName(items.getItemName());
        result.setPrice(items.getPrice());
        result.setCategory(items.getCategory());
        result.setItemImage(items.getItemImage());
        Items updated = iItemsServ.addItems(result);
        return updated;
    }

    @DeleteMapping("delete-item/{itemId}")
    public boolean deleteItem(@PathVariable("itemId") long id) {
        Items result = iItemsServ.getItems(id).get();
         iItemsServ.deleteItem(result);
         return true;
    }

    @GetMapping("/detail/{id}")
    public Items getItem(@PathVariable long id) {
        Items result = iItemsServ.getItems(id).get();
        return result;
    }
}
