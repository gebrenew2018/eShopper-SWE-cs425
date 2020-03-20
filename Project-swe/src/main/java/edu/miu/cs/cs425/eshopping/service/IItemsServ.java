package edu.miu.cs.cs425.eshopping.service;

import edu.miu.cs.cs425.eshopping.model.Items;

import java.util.List;
import java.util.Optional;

public interface IItemsServ {
    public abstract Items addItems(Items item);
    public abstract Optional<Items> getItems(long id);
    public abstract void deleteItem(Items item);
    public abstract List<Items> getAllItems(String search);
}
