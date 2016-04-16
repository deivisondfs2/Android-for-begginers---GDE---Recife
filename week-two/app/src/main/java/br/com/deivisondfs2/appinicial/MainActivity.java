
package br.com.deivisondfs2.appinicial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final int VALOR_CAFE = 5;

    public int quantity = 3;

    //TextView @ids
    private TextView countElementsAdd;
    private TextView valueResultPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set values default
        display(quantity);
        displayUnitaryValue(VALOR_CAFE);
    }

    // onclick button @id/button_result
    public void submitOrder(View v){
        display(quantity);
        displayPrice(quantity * VALOR_CAFE);
    }

    public void display(int number){
        countElementsAdd = (TextView) findViewById(R.id.count);
        countElementsAdd.setText("" + number);
    }


    public void displayPrice(int number){
        valueResultPrice = (TextView) findViewById(R.id.result);
        valueResultPrice.setText(getString(R.string.result_final_price, NumberFormat.getCurrencyInstance().format(number)) );

    }

    public void displayUnitaryValue(int valor){
        TextView valorUnitario = (TextView) findViewById(R.id.unitaryValue);
        valorUnitario.setText(NumberFormat.getCurrencyInstance().format(valor));
    }

    public void buttonIncrement(View view) {
        quantity++;
        display(quantity);
    }

    public void buttonDecrement(View view) {
        quantity--;
        quantity = Math.max(0, quantity);
        display(quantity);
    }
}
