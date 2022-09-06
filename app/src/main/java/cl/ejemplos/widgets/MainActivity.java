package cl.ejemplos.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox aceptoLicencia=(CheckBox) findViewById(R.id.aceptoLicencia);
        aceptoLicencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAceptoLicencia(view);
            }
        });
        ImageButton enviar=(ImageButton) findViewById(R.id.enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarDatos(view);
            }
        });
    }
    public void onAceptoLicencia(View view)
    {
        boolean acepta=((CheckBox)view).isChecked();
        if(!acepta) //si acepta es false, está desmarcada la casilla
        {
            Toast.makeText(this,"Debe aceptar la licencia",
                    Toast.LENGTH_SHORT).show();

        }
    }
    public void enviarDatos(View view)
    {
        String mensaje="";
        boolean enviarOk=false;
        CheckBox licencia=(CheckBox) findViewById(R.id.aceptoLicencia);
        if(licencia.isChecked())
        {
            enviarOk=true;
        }
        Switch correo=(Switch) findViewById(R.id.correo);
        boolean enviarCorreo=correo.isChecked();
        if(enviarCorreo)
        {
            mensaje += "Enviar por correo\n";
        }
        RadioGroup rgColores=(RadioGroup) findViewById(R.id.rgColor);
        int id=rgColores.getCheckedRadioButtonId();
        switch (id)
        {
            case R.id.radRojo: mensaje += "Color ROJO\n";
                break;
            case R.id.radVerde: mensaje += "Color VERDE\n";
                break;
        }
        if(enviarOk)
        {
            //Enviamos a otro activity
            Intent intent=new Intent(this,ResultadoActivity.class);
            intent.putExtra("mensaje",mensaje);
            startActivity(intent);
        }
        else
        {
            //Mensaje de error
            Toast.makeText(this,"Debe aceptar la licencia",
                    Toast.LENGTH_SHORT).show();
        }
    }

}















