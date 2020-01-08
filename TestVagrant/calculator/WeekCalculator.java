package TestVagrant.calculator;

import TestVagrant.entity.Items;

import java.util.Calendar;


public class WeekCalculator implements Expense {

    @Override
    public float getItemExpenseByFrequency(Items item, Calendar calendar) {
       float priceOfWeek =  item.getItemPrices().get(getConsideredDayOfWeekForPrice());
       return getNumberOfWeeksInMonth(calendar)* priceOfWeek;
    }

    public int getConsideredDayOfWeekForPrice(){
        // means monday;
        return 0;
    }

    private int getNumberOfWeeksInMonth(Calendar calendar){
        return calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
    }

}
