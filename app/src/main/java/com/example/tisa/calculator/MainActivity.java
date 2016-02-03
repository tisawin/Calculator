package com.example.tisa.calculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private CalculationService cs;
    private TextView resultScreen;
    private Button button;
    //global member holds new number to calculate
    private String secondNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cs = new CalculationService();
    }

    //listeners to pressed numbers
    public void tapZero(View view){
        //declare button variable
        button = (Button) findViewById(R.id.button0);

        //display on screen
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();
        resultScreen.setText(existingString+button.getText().toString());

    }

    public void tapOne(View view){
        //declare button variable
        button = (Button) findViewById(R.id.button1);

        //display on screen
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();
        resultScreen.setText(existingString+button.getText().toString());

    }
    public void tapTwo(View view){
        //declare button variable
        button = (Button) findViewById(R.id.button2);

        //display on screen
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();
        resultScreen.setText(existingString+button.getText().toString());

    }
    public void tapThree(View view){
        //declare button variable
        button = (Button) findViewById(R.id.button3);

        //display on screen
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();
        resultScreen.setText(existingString+button.getText().toString());

    }
    public void tapFour(View view){
        //declare button variable
        button = (Button) findViewById(R.id.button4);

        //display on screen
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();
        resultScreen.setText(existingString+button.getText().toString());
    }
    public void tapFive(View view){
        //declare button variable
        button = (Button) findViewById(R.id.button5);

        //display on screen
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();
        resultScreen.setText(existingString+button.getText().toString());

    }
    public void tapSix(View view){
        //declare button variable
        button = (Button) findViewById(R.id.button6);

        //display on screen
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();
        resultScreen.setText(existingString+button.getText().toString());

    }
    public void tapSeven(View view){
        //declare button variable
        button = (Button) findViewById(R.id.button7);

        //display on screen
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();
        resultScreen.setText(existingString+button.getText().toString());

    }
    public void tapEight(View view){
        //declare button variable
        button = (Button) findViewById(R.id.button8);

        //display on screen
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();
        resultScreen.setText(existingString+button.getText().toString());

    }
    public void tapNine(View view){
        //declare button variable
        button = (Button) findViewById(R.id.button9);

        //display on screen
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();
        resultScreen.setText(existingString+button.getText().toString());

    }

    public void tapDecimal(View view){
        //declare button variable
        button = (Button) findViewById(R.id.buttonDecimal);

        //display on screen
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();

        if (cs.isNullOrBlank(existingString)){
            ErrorSyntaxMessage();
            return;
        }
        if (!existingString.substring(existingString.length() - 1).equals(".")) {
            resultScreen.setText(existingString + button.getText().toString());
        } else {
            ErrorSyntaxMessage();
        }
    }

    //listener to pressed operators
    public void tapDivide(View view){
        if (!isValidOperator()){
            ErrorSyntaxMessage();
            //exit method
            return;
        }

        //declare existing text on result panel
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();

        //declare button variable
        button = (Button) findViewById(R.id.buttonDivide);
        String buttonText = button.getText().toString();

        //add symbol to result panel text
        resultScreen.setText(existingString + buttonText);

    }
    public void tapMultiply(View view){
        if (!isValidOperator()){
            ErrorSyntaxMessage();
            //exit method
            return;
        }

        //declare existing text on result panel
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();

        //declare button variable
        button = (Button) findViewById(R.id.buttonMultiply);
        String buttonText = button.getText().toString();

        //add symbol to result panel text
        resultScreen.setText(existingString + buttonText);

    }
    public void tapSubtract(View view){
        if (!isValidOperator()){
            ErrorSyntaxMessage();
            //exit method
            return;
        }
        //declare existing text on result panel
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();

        //declare button variable
        button = (Button) findViewById(R.id.buttonSubtract);
        String buttonText = button.getText().toString();

        //add symbol to result panel text
        resultScreen.setText(existingString + buttonText);


    }
    public void tapAdd(View view){
        if (!isValidOperator()){
            ErrorSyntaxMessage();
            //exit method
            return;
        }
        //declare existing text on result panel
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String existingString = resultScreen.getText().toString();

        //declare button variable
        button = (Button) findViewById(R.id.buttonAdd);
        String buttonText = button.getText().toString();

        //add symbol to result panel text
        resultScreen.setText(existingString + buttonText);


    }

    //click listeners to function buttons
    public void tapClear(View view){
        String clearedResultScreenText = getResources().getString(R.string.blank);
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        resultScreen.setText("");
        resultScreen.setHint(clearedResultScreenText);
        cs = new CalculationService();
    }

    public void tapBackSpace(View view){
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String expression = resultScreen.getText().toString();
        if (!cs.isNullOrBlank(expression)){
            expression = expression.substring(0, expression.length()-1);
        }
        resultScreen.setText(expression);
    }

    public void tapEnter(View view){
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String finalResults = resultScreen.getText().toString();
        if (cs.IsValid(finalResults)) {
            double result = cs.CalculationHandler(finalResults);
            resultScreen.setText(String.valueOf(result));
        } else {
            ErrorSyntaxMessage();
        }

    }



    //method to check if number is the first inputted number
    public boolean isFirstInputNumber (){
        boolean isFirstNum = true;
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String resultText = resultScreen.getText().toString();
        //if result textview contains any of the operators, the number input is not the first number
        if (resultText.contains("/")||resultText.contains("*")||resultText.contains("-")||resultText.contains("+")){
            isFirstNum=false;
        }

        return isFirstNum;
    }
    //method to check if there is a number before any operator symbols
    public boolean isValidOperator (){
        boolean isValid = true;
        resultScreen = (TextView) findViewById(R.id.textViewResult);
        String clearedResultScreenText = getResources().getString(R.string.blank);

        if (resultScreen.getText().toString().equals("")){
            isValid = false;
        }
        return isValid;
    }
    //method to display syntax error message to users
    public void ErrorSyntaxMessage(){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage("Operator Syntax Error.  Please try check your input.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    //method to determine new number entered
    public String DetermineNewNumber (String existingResult){
        /*
        existingResult= existingResult.replaceAll("/", "~");
        existingResult= existingResult.replace("*", "~");
        existingResult= existingResult.replace("+", "~");
        existingResult= existingResult.replaceAll("-", "~");
        String[] array = existingResult.split("~");*/
        String[] array = existingResult.split("\\D+");
        int lastElement = array.length;
        return array[lastElement];
    }
}
