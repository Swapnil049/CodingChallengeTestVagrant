package TestVagrant.services;

import TestVagrant.calculator.ItemCalculator;
import TestVagrant.entity.Frequency;
import TestVagrant.entity.Items;
import TestVagrant.entity.User;
import com.sun.javafx.UnmodifiableArrayList;

import java.util.*;


public class Application {

    // populate items ie product set
    List<Items> itemsSet = new ArrayList<Items>();

    List<User> users = new ArrayList<>();

    ItemCalculator itemCalculator = new ItemCalculator();

    List<UserSubscription> userSubscriptionList = new ArrayList<UserSubscription>();


    public Application(){
        populateItemSet();
        populateUser();
        setUserSubscriptionList();

    }

    public void populateItemSet(){

        HashMap<Integer,Float> milkItemPrices = new HashMap<Integer,Float>();
        for(int i =0 ; i< 7; i++){
            milkItemPrices.put(i,new Float(20+i));
        }
        Items item1 = new Items("tonedMilk",milkItemPrices,"milk");
        itemsSet.add(item1);

        HashMap<Integer,Float> PaperItemPrices = new HashMap<Integer,Float>();
        for(int i =0 ; i< 7; i++){
            PaperItemPrices.put(i,new Float(2.5+i));
        }
        Items item2 = new Items("TOI",PaperItemPrices,"paper");
        itemsSet.add(item2);


        System.out.println("items set:"+itemsSet);


    }

    public void populateUser(){

        User user1 = new User("123","A1");
        User user2 = new User("124","A2");
        users.add(user1);
        users.add(user2);

        System.out.println("user set:"+itemsSet);


    }

    public void setUserSubscriptionList(){
        Calendar calendar = Calendar.getInstance();

        HashMap<Items, Enum<Frequency>> orderItems = new HashMap<Items, Enum<Frequency>>();
        orderItems.put(itemsSet.get(0),Frequency.Daily);
        orderItems.put(itemsSet.get(1),Frequency.Weekly);
        UserSubscription userSubscription1 = new UserSubscription(users.get(0),calendar,orderItems,itemCalculator);

        System.out.println("userSubscription1:"+userSubscription1);
        userSubscriptionList.add(userSubscription1);


        HashMap<Items, Enum<Frequency>> orderItems2 = new HashMap<Items, Enum<Frequency>>();
        orderItems2.put(itemsSet.get(1),Frequency.BiWeekly);
        UserSubscription userSubscription2 = new UserSubscription(users.get(1),calendar,orderItems2,itemCalculator);
        System.out.println("userSubscription2:"+userSubscription2);
        userSubscriptionList.add(userSubscription2);

    }

    public void showMonthlySubsription(){

        for(UserSubscription us: userSubscriptionList ){

            System.out.println("For user:"+us.getUser());
            System.out.println("monthly price:");
            System.out.println(us.calculateMonthlyExpense());

        }

    }






    public static void main(String[] args) {

        Application ap = new Application();
        ap.showMonthlySubsription();

    }
}
