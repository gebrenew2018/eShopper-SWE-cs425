package edu.miu.cs.cs425.eshopping.controller;
import edu.miu.cs.cs425.eshopping.model.Items;
import edu.miu.cs.cs425.eshopping.model.ShoppingCart;
import edu.miu.cs.cs425.eshopping.service.ICustomerServ;
import edu.miu.cs.cs425.eshopping.service.IItemsServ;
import edu.miu.cs.cs425.eshopping.service.IShppoingCartServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {
    @Autowired
    private IShppoingCartServ shoppingCartServ;
    @Autowired
    private IItemsServ iItemsServ;
    @Autowired
    ICustomerServ customerServ;

    @PostMapping
    public ShoppingCart addItemsToCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartServ.addItemTocart(shoppingCart);
    }
    @GetMapping
    public String saysomethig() {return "hello";}
    @GetMapping("/list/{id}")
    public List<Optional<Items>> getItemsFromcart(@PathVariable long id) {
        List<ShoppingCart> ls= shoppingCartServ.getAllFromCart(id);
        List<Optional<Items>> items = new ArrayList<>();
        for(ShoppingCart sc: ls){
            Optional<Items> it= iItemsServ.getItems(sc.getCartId());
            items.add(it);
        }
        return items;
    }
}
