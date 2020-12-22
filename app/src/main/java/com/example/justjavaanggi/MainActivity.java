package com.example.justjavaanggi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    EditText namaEditText;
    String nama;
    EditText alamatEditText;
    String alamat;
    EditText noHpEditText;
    String nohp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment (View view) {
        quantity = quantity + 1;
        display(quantity);

    }

    public void decrement (View view) {
        if (quantity > 0){
            quantity = quantity - 1;
            display(quantity);
        }
    }

    public void submitOrder (View view) {
        CheckBox OreoCheckbox = (CheckBox) findViewById(R.id.oreo_checkbox);
        CheckBox MashCheckbox = (CheckBox) findViewById(R.id.marsh_checkbox);
        CheckBox KitkatCheckbox = (CheckBox) findViewById(R.id.kitkat_checkbox);
        namaEditText = (EditText) findViewById(R.id.name_field);
        alamatEditText = (EditText) findViewById(R.id.alamat_field);
        noHpEditText = (EditText) findViewById(R.id.hp_field);
        boolean hashOreo = OreoCheckbox.isChecked();
        boolean hashMarsh = MashCheckbox.isChecked();
        boolean hashKitkat = KitkatCheckbox.isChecked();
        nama = namaEditText.getText().toString();
        alamat = alamatEditText.getText().toString();
        nohp = noHpEditText.getText().toString();
        int price = calculatePrice(hashOreo, hashMarsh, hashKitkat);
        String priceMessage = "Jumlah yang dijamasi " + quantity + " bilah" +
                "\nOreo : " + hashOreo +
                "\nMarsh : " + hashMarsh +
                "\nKkitkat : " + hashKitkat +
                "\nTotal pembelian Rp " + price +
                "\nTerimakasih, Kurir Kami Akan Mengantar Pesanan Anda Sesuai Aplikasi  : \n"
                + nama
                + alamat
                + nohp;
        displayMessage (priceMessage);
    }

    private int calculatePrice(boolean addhashOreo, boolean addhashMarsh, boolean addhashKitkat) {
        int basePrice = 100000;
        int price = 0;
        if (addhashOreo) {
            basePrice = basePrice + 80000;
        }
        if(addhashMarsh){
            basePrice = basePrice + 40000;
        }
        if (addhashKitkat){
            basePrice = basePrice + 70000;
        }
        return price = quantity * basePrice;
    }

    public void submitReset (View view) {
        if (quantity == quantity){
            quantity = 0;
        };
        display(quantity);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private void display (int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText ("" + number);
    }
    private void displayPrice (int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format (number));
    }
}