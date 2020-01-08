package TestVagrant.calculator;

import TestVagrant.entity.Items;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.HashMap;


public class DailyCalculator implements Expense {

    @Override
    public float getItemExpenseByFrequency(Items item, Calendar calendar) {


        DayOfWeek[] dayOfWeeks = DayOfWeek.values();

        float monthlyPrice = 0;

        HashMap<Integer,Float> itemPrices =  item.getItemPrices();
        for(int i = 0 ; i<= 6 ; i++ ){
           float pricePerItem =  itemPrices.get(i);
           int numberOfDays =  getNumberOfMonthByDay(calendar,dayOfWeeks[i]);
            monthlyPrice += pricePerItem*numberOfDays;
        }

      return monthlyPrice;
    }



    private    int countDayOccurenceInMonth(DayOfWeek dow, YearMonth month) {
        LocalDate start = month.atDay(1).with(TemporalAdjusters.nextOrSame(dow));
        return (int) ChronoUnit.WEEKS.between(start, month.atEndOfMonth()) + 1;
    }

    public   int getNumberOfMonthByDay(Calendar c,DayOfWeek dow){

      //  System.out.println("c:"+c);
      //  System.out.println("dow:"+dow);
        return countDayOccurenceInMonth(dow, YearMonth.of(c.get(Calendar.YEAR),c.get(Calendar.MONTH)+1));
    }


}
