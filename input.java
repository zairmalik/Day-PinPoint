package com.learn.uzair.daypinpoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.joda.time.DateTime;
import org.joda.time.chrono.IslamicChronology;

public class input extends AppCompatActivity {

    private EditText dayInput, monthInput, yearInput;
    private YearCode yearCode = new YearCode();
    private int[] leapMonth = {5,1,2,5,0,3,5,1,4,6,2,4};
    private int[] normalMonth = {6,2,2,5,0,3,5,1,4,6,2,4};
    private int i, monthCodeSet = 0, yearCodeSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        dayInput = findViewById(R.id.dayinput);
        monthInput = findViewById(R.id.monthinput);
        yearInput = findViewById(R.id.yearinput);
    }

    public void calculate(View view){
        Intent intent = new Intent(getApplicationContext(),result.class);
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int finalResultInteger = 0;
        String finalResultString = null;

        String dayString = dayInput.getText().toString();
        String monthString = monthInput.getText().toString();
        String yearString = yearInput.getText().toString();

        if (TextUtils.isEmpty(dayString)){
            dayInput.setError("Day cannot be empty.");
            return;
        }

        if (TextUtils.isEmpty(monthString)){
            monthInput.setError("Month cannot be empty.");
            return;
        }

        if (TextUtils.isEmpty(yearString)){
            yearInput.setError("Year cannot be empty.");
            return;
        }

        int dayInteger = Integer.parseInt(dayString);
        int monthInteger = Integer.parseInt(monthString);
        int yearInteger = Integer.parseInt(yearString);

        if (dayInteger > 31){
            Toast.makeText(this,"Day cannot be more than 31.",Toast.LENGTH_LONG).show();
            return;
        }

        if (monthInteger > 12){
            Toast.makeText(this,"Month cannot be more than 12.",Toast.LENGTH_LONG).show();
            return;
        }

        if (yearInteger < 1600 || yearInteger > 2399){
            Toast.makeText(this,"Year out of bound.",Toast.LENGTH_LONG).show();
            return;
        }

        int dayRemainder = dayInteger % 7;

        if (yearInteger < 1700){
            finalResultInteger = dateToCode21stCentury(yearInteger + 400,monthInteger,dayRemainder);
        }
        else if (yearInteger < 1800){
            finalResultInteger = dateToCodeOtherCentury(yearInteger,monthInteger,dayRemainder,1700,300,5);
        }
        else if(yearInteger < 1900){
            finalResultInteger = dateToCodeOtherCentury(yearInteger,monthInteger,dayRemainder,1800,200,3);
        }
        else if(yearInteger < 2000){
            finalResultInteger = dateToCodeOtherCentury(yearInteger,monthInteger,dayRemainder,1900,100,1);
        }
        else if (yearInteger < 2100){
            finalResultInteger = dateToCode21stCentury(yearInteger,monthInteger,dayRemainder);
        }
        else if (yearInteger < 2200){
            finalResultInteger = dateToCodeOtherCentury(yearInteger,monthInteger,dayRemainder,2100,-100,5);
        }
        else if (yearInteger < 2300){
            finalResultInteger = dateToCodeOtherCentury(yearInteger,monthInteger,dayRemainder,2200,-200,3);
        }
        else if (yearInteger < 2400){
            finalResultInteger = dateToCodeOtherCentury(yearInteger,monthInteger,dayRemainder,2300,-300,1);
        }

        for (i = 0; i <= finalResultInteger; i++){
            finalResultString = daysOfWeek[i];
        }

        DateTime dtISO = new DateTime(yearInteger,monthInteger,dayInteger,0,0,0);
        DateTime dtIslamic = dtISO.withChronology(IslamicChronology.getInstance());

        String date = dayString + "/" + monthString + "/" + yearString;
        String islamicDateString = dtIslamic.toString().substring(0,10);

        intent.putExtra("Result",finalResultString);
        intent.putExtra("Date",date);
        intent.putExtra("Islamic Date",islamicDateString);
        startActivity(intent);
    }

    private int dateToCode21stCentury(int year, int month, int day){
        if(year % 4 == 0){
            for (i = 0; i < month; i++){
                monthCodeSet = leapMonth[i];
            }

            yearCodeSet = yearCode.leapYear(year);
        }
        else{
            for (i = 0; i < month; i++){
                monthCodeSet = normalMonth[i];
            }

            yearCodeSet = yearCode.normalYear(year);
        }

        return (day + monthCodeSet + yearCodeSet) % 7;
    }

    private int dateToCodeOtherCentury(int year, int month, int day, int firstYearOfCentury, int numOfYearsDeviate, int centuryCode){
        if (year != firstYearOfCentury && year % 4 == 0){
            for (i = 0; i < month; i++){
                monthCodeSet = leapMonth[i];
            }

            yearCodeSet = yearCode.leapYear(year + numOfYearsDeviate);
        }
        else if (year == firstYearOfCentury){
            for (i = 0; i < month; i++){
                monthCodeSet = normalMonth[i];
            }

            yearCodeSet = yearCode.leapYear(year + numOfYearsDeviate);
        }
        else{
            for (i = 0; i < month; i++){
                monthCodeSet = normalMonth[i];
            }

            yearCodeSet = yearCode.normalYear(year + numOfYearsDeviate);
        }

        return ((day + monthCodeSet + yearCodeSet) + centuryCode) % 7;
    }
}
