package com.kevin.resistorcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String[] opciones = {"Negro", "Cafe", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Violeta", "Gris", "Blanco"};
    String[] multiplier = {
            "", "0", "00",
            "K", "0K", "00K",
            "M", "0M", "00M",
            "G"};
    ArrayList<String> list = new ArrayList<>(Arrays.asList(opciones));
    ImageView band1, band2, band3;
    Spinner spin1, spin2, spin3;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin1 = findViewById(R.id.spin1);
        spin2 = findViewById(R.id.spin2);
        spin3 = findViewById(R.id.spin3);

        band1 = findViewById(R.id.Band1);
        band2 = findViewById(R.id.Band2);
        band3 = findViewById(R.id.Band3);
        result = findViewById(R.id.textResult);
        // TODO: 16/06/2020 Color on dropdown list
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin1.setAdapter(adapter);
        spin2.setAdapter(adapter);
        spin3.setAdapter(adapter);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void calculate() {
        // TODO: 16/06/2020 refactor
        int indexOfColor1 = list.indexOf((String) spin1.getSelectedItem());
        int indexOfColor2 = list.indexOf((String) spin2.getSelectedItem());
        int indexOfColor3 = list.indexOf((String) spin3.getSelectedItem());
        setBandColor(0, indexOfColor1);
        setBandColor(1, indexOfColor2);
        setBandColor(2, indexOfColor3);
        // TODO: 16/06/2020 if 0 dont append multiplier
        int main = indexOfColor1 * 10 + indexOfColor2;
        String text;
        if (main>0){
            text = main + multiplier[indexOfColor3];
        }else {
            text = String.valueOf(main);
        }
        text+=" Ohms";
        result.setText(text);

    }

    private void setBandColor(int i, int indexOfColor) {
        switch (i) {
            case 0:
                band1.setColorFilter(ContextCompat.getColor(getApplicationContext(),getBandColor(indexOfColor)));
                break;
            case 1:
                band2.setColorFilter(ContextCompat.getColor(getApplicationContext(),getBandColor(indexOfColor)));
                break;
            case 2:
                band3.setColorFilter(ContextCompat.getColor(getApplicationContext(),getBandColor(indexOfColor)));
                break;


        }
    }

    public int getBandColor(int index) {
        switch (index) {
            case 0:
                return R.color.black;
            case 1:
                return R.color.brown;
            case 2:
                return R.color.red;
            case 3:
                return R.color.orange;
            case 4:
                return R.color.yellow;
            case 5:
                return R.color.green;
            case 6:
                return R.color.blue;
            case 7:
                return R.color.violet;
            case 8:
                return R.color.grey;
            case 9:
            default:
                return R.color.white;
        }
    }

}