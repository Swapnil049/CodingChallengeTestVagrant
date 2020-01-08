package TestVagrant.calculator;

import TestVagrant.entity.Frequency;
import TestVagrant.entity.Items;

import java.util.Calendar;


public class ItemCalculator {

    Expense dailyExpense = new DailyCalculator();
    Expense weeklyExpense = new WeekCalculator();
    Expense biWeekExpense = new BiWeeklyCalculator();


    public float getExpenseByMonth(Items item, Enum<Frequency> frequencyEnum, Calendar c){

        if(frequencyEnum == Frequency.Daily){

           return dailyExpense.getItemExpenseByFrequency(item,c);
        }
        else if(frequencyEnum == Frequency.Weekly){

            return weeklyExpense.getItemExpenseByFrequency(item,c);
        }
        else if(frequencyEnum == Frequency.BiWeekly){
            return biWeekExpense.getItemExpenseByFrequency(item,c);
        }
        return -1;
    }
}
