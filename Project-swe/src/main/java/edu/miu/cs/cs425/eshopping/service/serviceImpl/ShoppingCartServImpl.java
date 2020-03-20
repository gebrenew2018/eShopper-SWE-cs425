package edu.miu.cs.cs425.eshopping.service.serviceImpl;

import edu.miu.cs.cs425.eshopping.model.ShoppingCart;
import edu.miu.cs.cs425.eshopping.repository.IShoppingCartRepo;
import edu.miu.cs.cs425.eshopping.service.IShppoingCartServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShoppingCartServImpl implements IShppoingCartServ {
    private IShoppingCartRepo shoppingCartRepo;

    @Autowired
    public ShoppingCartServImpl(IShoppingCartRepo shoppingCartRepo) {
        this.shoppingCartRepo = shoppingCartRepo;
    }

    @Override
    public ShoppingCart addItemTocart(ShoppingCart shoppingCart) {
        return shoppingCartRepo.save(shoppingCart);
    }

    @Override
    public ShoppingCart addPayment(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public ShoppingCart getShoppingCart(long id) {
        return null;
    }

    @Override
    public void deleteShoppingCart(long id) {

    }

    @Override
    public List<ShoppingCart> getAllFromCart(long id) {
        return shoppingCartRepo.findAll();
    }
}
