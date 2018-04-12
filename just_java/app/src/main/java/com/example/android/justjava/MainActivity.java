package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100){

            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1){
            Toast.makeText(this, "You cannot have less than 1 coffees", Toast.LENGTH_SHORT).show();

            return;
        }
        quantity = quantity-1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();


        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();


        int price = calculatePrice( hasWhippedCream, hasChocolate );
        String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        displayMessage (priceMessage);

    }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        // price of 1 cup of coffee
        int basePrice = 5;

        //Add $1 if whipped cream is added
        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }

        //Add $2 if chocolate is added
        if (addChocolate) {
            basePrice = basePrice +2;
        }

        //Calculate total price

        return quantity * basePrice;
    }

    private String createOrderSummary (String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name : "+ name;
        priceMessage = priceMessage + "\nAdd whipped cream?" + addWhippedCream;
        priceMessage = priceMessage + "\nAdd chocolate? " + addChocolate;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal: $" + price;
        priceMessage = priceMessage + "\nThank you !";
        return priceMessage;

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
