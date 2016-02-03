package com.example.tisa.calculator;

import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.Stack;
import java.util.*;


/**
 * Created by TISA on 2/2/2016.
 */
public class CalculationService {
    private int result;

    public CalculationService(){
        result=0;
    }

    public void Set (String stringNumber){
        result = Integer.parseInt(stringNumber);
    }

    public double CalculationHandler (String expression){
        expression = expression.replaceAll(" ", "");
        expression = expression.replaceAll("\\+", " + ");
        expression = expression.replaceAll("\\-", " - ");
        expression = expression.replaceAll("\\*", " * ");
        expression = expression.replaceAll("\\/", " \\/ ");
        expression = expression.replaceAll("  ", " ");

        LinkedList<String> symb = new LinkedList<String>(Arrays.asList(expression.split(" ")));
        if (symb.contains("*") || symb.contains("/"))
            for (int i = 0; i < symb.size(); i++)
                if (symb.get(i).equals("*")) {
                    symb.set(i, "" + ((Double.parseDouble(symb.get(i - 1)) * Double.parseDouble(symb.get(i + 1)))));
                    symb.remove(i + 1);
                    symb.remove(i - 1);
                } else if (symb.get(i).equals("/")) {
                    symb.set(i, "" + ((Double.parseDouble(symb.get(i - 1)) / Double.parseDouble(symb.get(i + 1)))));
                    symb.remove(i + 1);
                    symb.remove(i - 1);
                }
        double val = Double.parseDouble(symb.get(0));
        if (symb.contains("+") || symb.contains("-"))
            for (int i = 0; i < symb.size(); i++)
                if (symb.get(i).equals("+"))
                    val += Double.parseDouble(symb.get(i + 1));
                else if (symb.get(i).equals("-"))
                    val -= Double.parseDouble(symb.get(i + 1));
        if (Math.ceil(val) == Math.floor(val))
            return new Integer((int) val);
        return (double) val;
    }

    public boolean IsValid (String stringNumber){
        boolean isValid = true;

        if (isNullOrBlank(stringNumber)){
            isValid = false;
        }
        else if (stringNumber.substring(stringNumber.length()-1).matches("/|\\+|\\*|-")){
            isValid = false;
        }


        return isValid;
    }

    public static boolean isNullOrBlank(String string) {
        return string == null || string.trim().length() == 0;
    }


}
