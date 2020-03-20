package edu.miu.cs.cs425.eshopping.service.serviceImpl;

import edu.miu.cs.cs425.eshopping.model.Items;
import edu.miu.cs.cs425.eshopping.repository.IItemRepo;
import edu.miu.cs.cs425.eshopping.service.IItemsServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemsServImpl implements IItemsServ {
    private IItemRepo itemRepo;

    @Autowired
    public ItemsServImpl(IItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Override
    public Items addItems(Items item) {
        return itemRepo.save(item);
    }

    @Override
    public Optional<Items> getItems(long id) {
        return itemRepo.findById(id);
    }

    @Override
    public void deleteItem(Items item) {
        itemRepo.delete(item);
    }

    @Override
    public List<Items> getAllItems(String search) {
        if (search.equals("all"))
            return itemRepo.findAll();
        return itemRepo.findAll();
    }
}
