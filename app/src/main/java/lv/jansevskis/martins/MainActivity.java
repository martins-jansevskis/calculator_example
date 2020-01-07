package lv.jansevskis.martins;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView calculation;
    Boolean firstNumberEntered = false;
    Integer firstNumberValue = 0;
    Integer secondNumberValue = 0;
    String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = findViewById(R.id.calculation);

        // Group of numbers
        Button n_0 = findViewById(R.id.n_0);
        Button n_1 = findViewById(R.id.n_1);
        Button n_2 = findViewById(R.id.n_2);
        Button n_3 = findViewById(R.id.n_3);
        Button n_4 = findViewById(R.id.n_4);
        Button n_5 = findViewById(R.id.n_5);
        Button n_6 = findViewById(R.id.n_6);
        Button n_7 = findViewById(R.id.n_7);
        Button n_8 = findViewById(R.id.n_8);
        Button n_9 = findViewById(R.id.n_9);

        n_0.setOnClickListener(this);
        n_1.setOnClickListener(this);
        n_2.setOnClickListener(this);
        n_3.setOnClickListener(this);
        n_4.setOnClickListener(this);
        n_5.setOnClickListener(this);
        n_6.setOnClickListener(this);
        n_7.setOnClickListener(this);
        n_8.setOnClickListener(this);
        n_9.setOnClickListener(this);

        // Group of functions
        Button f_plus = findViewById(R.id.f_plus);
        f_plus.setOnClickListener(this);

        Button f_minus = findViewById(R.id.f_minus);
        f_minus.setOnClickListener(this);

        Button f_multiply = findViewById(R.id.f_multiply);
        f_multiply.setOnClickListener(this);

        Button f_divide = findViewById(R.id.f_divide);
        f_divide.setOnClickListener(this);

        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(this);

        Button result = findViewById(R.id.result);
        result.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.n_0:
                calculation.append("0");
                convertFirst();
                convertSecond("0");
                break;
            case R.id.n_1:
                calculation.append("1");
                convertFirst();
                convertSecond("1");
                break;
            case R.id.n_2:
                calculation.append("2");
                convertFirst();
                convertSecond("2");
                break;
            case R.id.n_3:
                calculation.append("3");
                convertFirst();
                convertSecond("3");
                break;
            case R.id.n_4:
                calculation.append("4");
                convertFirst();
                convertSecond("4");
                break;
            case R.id.n_5:
                calculation.append("5");
                convertFirst();
                convertSecond("5");
                break;
            case R.id.n_6:
                calculation.append("6");
                convertFirst();
                convertSecond("6");
                break;
            case R.id.n_7:
                calculation.append("7");
                convertFirst();
                convertSecond("7");
                break;
            case R.id.n_8:
                calculation.append("8");
                convertFirst();
                convertSecond("8");
                break;
            case R.id.n_9:
                calculation.append("9");
                convertFirst();
                convertSecond("9");
                break;
            case R.id.f_plus:
                operation = "+";
                if (!firstNumberEntered) {
                    calculation.append("+");
                    firstNumberEntered = true;
                }
                break;
            case R.id.f_minus:
                operation = "-";
                if (!firstNumberEntered) {
                    calculation.append("-");
                    firstNumberEntered = true;
                }
                break;
            case R.id.f_divide:
                operation = "/";
                if (!firstNumberEntered) {
                    calculation.append("/");
                    firstNumberEntered = true;
                }
                break;
            case R.id.f_multiply:
                operation = "*";
                if (!firstNumberEntered) {
                    calculation.append("*");
                    firstNumberEntered = true;
                }
                break;
            case R.id.clear:
                calculation.setText("");
                firstNumberEntered = false;
                firstNumberValue = 0;
                secondNumberValue = 0;
                break;
            case R.id.result:
                calculation.append("=");

                Double result= calculate();
                calculation.append(result.toString());
                firstNumberEntered = false;
                operation = "";
                break;
        }
    }

    private void convertFirst() {
        if (!firstNumberEntered) {
            firstNumberValue = Integer.parseInt(calculation.getText().toString());
        }
    }

    private void convertSecond(String value) {
        if (firstNumberEntered) {
            String s_representation = secondNumberValue.toString();
            s_representation += value;
            secondNumberValue = Integer.parseInt(s_representation);
        }
    }

    private double calculate() {
        double result = 0;
        switch (operation) {
            case "+":
                result = firstNumberValue + secondNumberValue;
                break;
            case "-":
                result = firstNumberValue - secondNumberValue;
                break;
            case "*":
                result = firstNumberValue * secondNumberValue;
                break;
            case "/":
                result = firstNumberValue / secondNumberValue;
                break;
        }
        return result;
    }
}
