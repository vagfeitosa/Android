package com.example.calculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txt1 = findViewById(R.id.txt1);
        TextView view1 = findViewById(R.id.view1);
        Button btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(view -> {
            String input = txt1.getText().toString();
            if (!input.isEmpty()) {
                try {
                    int n = Integer.parseInt(input);
                    if (n > 0 && n < 20) {
                        double result = calculaSerie(n);
                        view1.setText(String.format("Resultado:\n" +"%s", result));
                    } else {
                        view1.setText("");
                        Toast.makeText(this, "Digite um número entre 1 e 19", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    view1.setText("");
                    Toast.makeText(this, "Digite um número válido", Toast.LENGTH_SHORT).show();
                }
            } else {
                view1.setText("");
                Toast.makeText(this, "Campo não pode estar vazio", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private double calculaSerie(int n) {
        double num = 0.0;
        for (int i = 1; i <= n; i++) {
            num += 1.0 / i;
        }
        return num;
    }
}