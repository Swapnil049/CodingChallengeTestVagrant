package TestVagrant.entity;

import java.util.HashMap;


public class Items {

    private String itemName;

    // 0 -> monday
    // 6 -> sunday
    private HashMap<Integer,Float> ItemPrices = new HashMap<Integer,Float>();

    private String category;

    public Items(String itemName, HashMap<Integer, Float> itemPrices, String category) {
        this.itemName = itemName;
        ItemPrices = itemPrices;
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public HashMap<Integer, Float> getItemPrices() {
        return ItemPrices;
    }

    public void setItemPrices(HashMap<Integer, Float> itemPrices) {
        ItemPrices = itemPrices;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Items{" +
                "itemName='" + itemName + '\'' +
                ", ItemPrices=" + ItemPrices +
                ", category='" + category + '\'' +
                '}';
    }
}
