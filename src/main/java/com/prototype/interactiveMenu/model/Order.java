package com.prototype.interactiveMenu.model;


import java.util.HashMap;
import java.util.List;

public class Order {

    private static int count = 1;
    private int id;
    private HashMap<Item,Integer> items;
    private CarDetails carDetails;
    private double totalAmt;

    public double getTotalAmt() {
        for(Item item : items.keySet()){
            totalAmt+=item.getItemPrice()*items.get(item);
        }
        return totalAmt;
    }

    public void setTotalAmt(double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Order(HashMap<Item, Integer> items, CarDetails carDetails) {
        this.items = items;
        this.carDetails = carDetails;
        this.id=++count;
    }

    @Override
    public String toString() {
        return "Order " +
                "ID : " + id +
                "\n\n" + formatOrder(items) +
                "\n" + carDetails.toString()
                + "\n\nTotal Amount : " + getTotalAmt()+"Dinar"
                ;
    }
    private String formatOrder(HashMap<Item,Integer> itemList){
        String formattedMsg = "ITEM                    Qty\n";
        for (Item item : itemList.keySet()) {
            formattedMsg = formattedMsg + item.getItemName() + ", " + item.getItemPrice()+"Dinar" + "        "+
                    itemList.get(item)+"\n";
        }
        return formattedMsg;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Item,Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<Item,Integer> items) {
        this.items = items;
    }

    public CarDetails getCarDetails() {
        return carDetails;
    }

    public void setCarDetails(CarDetails carDetails) {
        this.carDetails = carDetails;
    }


}
