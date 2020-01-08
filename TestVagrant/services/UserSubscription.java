package TestVagrant.services;

import TestVagrant.calculator.ItemCalculator;
import TestVagrant.entity.Frequency;
import TestVagrant.entity.Items;
import TestVagrant.entity.User;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


public class UserSubscription extends MonthlyExpense {

    private User user;
    private HashMap<Items, Enum<Frequency>> orderItems;
    private  Calendar calendar;



    public UserSubscription(User user, Calendar calendar, HashMap<Items, Enum<Frequency>> orderItems,ItemCalculator itemCalculator) {
        this.user = user;
        this.calendar = calendar;
        this.itemCalculator = itemCalculator;
        this.orderItems = orderItems;
    }

    @Override
    public HashMap<Items, Enum<Frequency>> getItemByFrequency() {
        return orderItems;
    }

    @Override
    public Calendar getCalendar() {
        return this.calendar;
    }


    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HashMap<Items, Enum<Frequency>> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(HashMap<Items, Enum<Frequency>> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "UserSubscription{" +
                "user=" + user +
                ", orderItems=" + orderItems +
                ", calendar=" + calendar +
                '}';
    }
}
