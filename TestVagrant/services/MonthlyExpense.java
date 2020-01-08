package TestVagrant.services;

import TestVagrant.calculator.ItemCalculator;
import TestVagrant.entity.Frequency;
import TestVagrant.entity.Items;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


public abstract class MonthlyExpense {

    /*

 ItemCalculator itemCalculator;

    Calendar calendar = Calendar.getInstance(); //get instance
calendar.set(Calendar.DAY_OF_WEEK, 3);  //make it be a Tuesday (crucial)
//optionally set the month you want here
calendar.set(Calendar.MONTH, 4) //May
calendar.getActualMaximum(Calendar.DAY_OF_WEEK_IN_MONTH); //for this month (what you want)
calendar.getMaximum(Calendar.DAY_OF_WEEK_IN_MONTH); //for any month (not so useful)
     */

    public  ItemCalculator itemCalculator;
    public abstract HashMap<Items,Enum<Frequency>> getItemByFrequency();

    public abstract Calendar getCalendar();

    public float calculateMonthlyExpense(){

        HashMap<Items,Enum<Frequency>>  itemFrequency = getItemByFrequency();

        Calendar c = getCalendar();
        Float sum = itemFrequency.entrySet().stream().map(entry-> getExpenseByItemByFrquency(entry.getKey(),entry.getValue(),c)).reduce(new Float(0), Float::sum);

        return sum;

    }

    private float getExpenseByItemByFrquency(Items item ,Enum<Frequency> frequencyEnum,Calendar calendar){

        return itemCalculator.getExpenseByMonth(item,frequencyEnum,calendar);


    }



}
