package cl.ejemplos.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Intent intent=getIntent();
        String mensaje=intent.getStringExtra("mensaje");
        TextView resultado=(TextView) findViewById(R.id.resultado);
        resultado.setText(mensaje);
    }
}