package br.edu.ifsp.edu.app01conversormonetario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Declarar os elementos
    private final double DOLLAR_VALUE = 4.92;
    private EditText inputEditText;
    private Button toDollarButton;
    private TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findById();
        setClick();
    }

    private void findById() {
        inputEditText = findViewById(R.id.editext_value);
        toDollarButton = findViewById(R.id.botao_converter_dolar);
        outputTextView = findViewById(R.id.textview_output);
    }

    private void setClick() {
        toDollarButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == toDollarButton) {
            ConverterParaDolar();
        }
    }

    private void ConverterParaDolar() {
        double value = 0;
        String stringvalue;
        stringvalue = inputEditText.getText().toString();
        try {
            value = Double.valueOf(stringvalue);
        } catch (NumberFormatException exception) {
            value = 0;
        }
        value = value / DOLLAR_VALUE;
        outputTextView.setText(String.valueOf(value));
    }
}