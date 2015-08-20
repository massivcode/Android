package com.example.massivcode.simplecalc;

import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Vibrator vibe;
    Calculator calc;

    TextView textView;
    TextView textView2;
    Button clear, divide, multi, backspace, minus, plus, percent, equal, dot, toggleSign;
    Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        calc = Calculator.getInstance();

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        textView2.setTextColor(Color.GREEN);

        clear = (Button) findViewById(R.id.clear);
        divide = (Button) findViewById(R.id.divide);
        multi = (Button) findViewById(R.id.multi);
        backspace = (Button) findViewById(R.id.backspace);
        minus = (Button) findViewById(R.id.minus);
        plus = (Button) findViewById(R.id.plus);
        percent = (Button) findViewById(R.id.percent);
        equal = (Button) findViewById(R.id.equal);
        dot = (Button) findViewById(R.id.dot);

        num0 = (Button) findViewById(R.id.num0);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);

        clear.setOnClickListener(this);
        divide.setOnClickListener(this);
        multi.setOnClickListener(this);
        backspace.setOnClickListener(this);
        minus.setOnClickListener(this);
        plus.setOnClickListener(this);
        percent.setOnClickListener(this);
        equal.setOnClickListener(this);
        dot.setOnClickListener(this);

        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        vibe.vibrate(10);

        switch (v.getId()) {

            case R.id.clear:

                calc.clear();
                textView.setText(calc.getBuffer());
                textView2.setText("");
                break;

            case R.id.divide:

                calc.input("operator", "/");

                textView.setText(calc.getBuffer());
                break;

            case R.id.multi:

                calc.input("operator", "*");

                textView.setText(calc.getBuffer());
                break;

            case R.id.backspace:

                calc.backspace();

                textView.setText(calc.getBuffer());
                break;

            case R.id.minus:

                calc.input("operator", "-");

                textView.setText(calc.getBuffer());
                break;

            case R.id.plus:

                calc.input("operator", "+");

                textView.setText(calc.getBuffer());
                break;

            case R.id.percent:

                calc.input("operator", "%");

                textView.setText(calc.getBuffer());
                break;

            case R.id.equal:

                try {

                    calc.calculate();

                    if (calc.getSosu() == 0) { // 결과가 .0일때

                        textView2.setText("= " + calc.getJungsu());

                    } else { // 결과가 .0이 아닐때

                        textView2.setText("= " + calc.getResult());
                    }

                } catch (Exception e) {
                    textView2.setText("= 잘못된 수식입니다.");
                }

                break;

            case R.id.num0:

                calc.input("num", "0");

                textView.setText(calc.getBuffer());
                break;

            case R.id.dot:

                calc.input("dot", ".");

                textView.setText(calc.getBuffer());
                break;

            case R.id.num1:

                calc.input("num", "1");

                textView.setText(calc.getBuffer());
                break;

            case R.id.num2:

                calc.input("num", "2");

                textView.setText(calc.getBuffer());
                break;

            case R.id.num3:

                calc.input("num", "3");

                textView.setText(calc.getBuffer());
                break;

            case R.id.num4:

                calc.input("num", "4");

                textView.setText(calc.getBuffer());
                break;

            case R.id.num5:

                calc.input("num", "5");

                textView.setText(calc.getBuffer());
                break;

            case R.id.num6:

                calc.input("num", "6");

                textView.setText(calc.getBuffer());
                break;

            case R.id.num7:

                calc.input("num", "7");

                textView.setText(calc.getBuffer());
                break;

            case R.id.num8:

                calc.input("num", "8");

                textView.setText(calc.getBuffer());
                break;

            case R.id.num9:

                calc.input("num", "9");

                textView.setText(calc.getBuffer());
                break;

            default:

        }

    }
}
