package edu.miu.cs.cs425.eshopping.service;

import edu.miu.cs.cs425.eshopping.model.ShoppingCart;

import java.util.List;

public interface IShppoingCartServ {
    public abstract ShoppingCart addItemTocart(ShoppingCart shoppingCart);
    public abstract ShoppingCart addPayment(ShoppingCart shoppingCart);
    public abstract ShoppingCart getShoppingCart(long id);
    public abstract void deleteShoppingCart(long id);
    public abstract List<ShoppingCart> getAllFromCart(long id);
}
