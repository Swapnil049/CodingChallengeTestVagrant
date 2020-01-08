package TestVagrant.calculator;

import TestVagrant.entity.Frequency;
import TestVagrant.entity.Items;

import java.util.Calendar;


public interface Expense {

    public float getItemExpenseByFrequency(Items item , Calendar calendar);

}
