package edu.miu.cs.cs425.eshopping.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemId;
    @NotNull(message = "Item Name is required")
    private String itemName;
    @NotNull(message = "Category is required")
    private String category;
    @NotNull(message = "Collection is required")
    private String collectionType;
    @NotNull(message = "Item image is required")
    private String itemImage;
    private int price;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    private ShoppingCart shoppingCart;

    public Items() {
    }
    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
