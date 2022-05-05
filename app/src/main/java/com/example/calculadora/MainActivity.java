package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView trabajo, respuesta;

    private String arriba, abajo, nuevoabajo;

    private Button uno, dos, tres, cuatro, cinco, seis, siete, ocho,
            nueve, cero, btnPunto, btnIgual, btnSuma, btnResta, btnMultiplicacion, btnDivision,
            btnPorcentaje, btnBorrar, btnLimpiar, btnRaiz, btnPotencia, btnParentesis, btnMasomenos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trabajo = findViewById(R.id.tvTrabajo);
        respuesta = findViewById(R.id.tvResultado);

        uno = findViewById(R.id.uno);
        dos = findViewById(R.id.dos);
        tres = findViewById(R.id.tres);
        cuatro = findViewById(R.id.cuatro);
        cinco = findViewById(R.id.cinco);
        seis = findViewById(R.id.seis);
        siete = findViewById(R.id.siete);
        ocho = findViewById(R.id.ocho);
        nueve = findViewById(R.id.nueve);
        cero = findViewById(R.id.cero);
        btnSuma = findViewById(R.id.btnSuma);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        btnDivision = findViewById(R.id.btnDivision);
        btnResta = findViewById(R.id.btnResta);
        btnPunto = findViewById(R.id.btnPunto);
        btnPotencia = findViewById(R.id.btnPotencia);
        btnIgual = findViewById(R.id.btnIgual);
        btnPorcentaje = findViewById(R.id.btnPorcentaje);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRaiz = findViewById(R.id.btnRaiz);
        btnParentesis = findViewById(R.id.btnParentesis);
        btnMasomenos = findViewById(R.id.btnMasmenos);
        btnBorrar = findViewById(R.id.btnBorrar);

    }

    public void hacerClick(View view) {

        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {

            case "AC":
                arriba = null;
                abajo=null;
                nuevoabajo=null;
                respuesta.setText("");
                break;

            case "^":
                solve();
                arriba += "^";
                break;
            case "*":
                solve();
                arriba += "*";
                break;

            case "=":
                solve();
                break;

            case "%":
                arriba += "%";
                double d = Double.parseDouble(trabajo.getText().toString()) / 100;
                respuesta.setText(String.valueOf(d));
                break;

            default:
                if (arriba == null) {
                    arriba = "";
                }
                if (data.equals("+") || data.equals("/") || data.equals("-") || data.equals("√")) {
                    solve();
                }
                arriba += data;
        }
        trabajo.setText(arriba);
    }

    private void solve() {
        if (arriba.split("\\+").length == 2) {
            String numbers[] = arriba.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                abajo = Double.toString(d);
                nuevoabajo = cutDecimal(abajo);
                respuesta.setText(nuevoabajo);
                arriba = d +"";
            }catch (Exception e) {
                respuesta.setText(e.getMessage().toString());
            }
        }
        if (arriba.split("\\*").length == 2) {
            String numbers[] = arriba.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                abajo = Double.toString(d);
                nuevoabajo = cutDecimal(abajo);
                respuesta.setText(nuevoabajo);
                arriba = d +"";
            }catch (Exception e){
                respuesta.setText(e.getMessage().toString());
            }
        }
        if (arriba.split("\\/").length == 2) {
            String numbers[] = arriba.split("\\/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                abajo = Double.toString(d);
                nuevoabajo = cutDecimal(abajo);
                respuesta.setText(nuevoabajo);
                arriba = d +"";
            }catch (Exception e){
                respuesta.setText(e.getMessage().toString());
            }
        }
        if (arriba.split("\\^").length == 2) {
            String numbers[] = arriba.split("\\^");
            try {
                double d = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                abajo = Double.toString(d);
                nuevoabajo = cutDecimal(abajo);
                respuesta.setText(nuevoabajo);
                arriba = d +"";
            }catch (Exception e){
                respuesta.setText(e.getMessage().toString());
            }
        }
        if (arriba.split("\\-").length == 2) {
            String numbers[] = arriba.split("\\-");
            try {
                if (Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])){
                    double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                    abajo = Double.toString(d);
                    nuevoabajo = cutDecimal(abajo);
                    respuesta.setText("-" + nuevoabajo);
                    arriba = d +"";
                }
                else {
                    double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    abajo = Double.toString(d);
                    nuevoabajo = cutDecimal(abajo);
                    respuesta.setText(nuevoabajo);
                    arriba = d + "";
                }
            }catch (Exception e){
                respuesta.setText(e.getMessage().toString());
            }
        }

        if (arriba.split("\\√").length == 2) {
            String numbers[] = arriba.split("\\√");
            try {
                double d = Math.sqrt(Double.parseDouble(numbers[1]));
                abajo = Double.toString(d);
                nuevoabajo = cutDecimal(abajo);
                respuesta.setText(nuevoabajo);
                arriba = d +"";
            }catch (Exception e) {
                respuesta.setText(e.getMessage().toString());
            }
        }
    }
    private String cutDecimal(String number){
        String n [] = number.split("\\.");
        if (n.length >1){
            if (n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }


}