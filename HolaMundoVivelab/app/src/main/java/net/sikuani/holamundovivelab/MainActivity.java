package net.sikuani.holamundovivelab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendInfo(View view){
        //Hay un click en el botón
        EditText field = (EditText) findViewById(R.id.infoToSend);
        //Obtener la información del usuario
        String info = field.getText().toString();
        //Si no viene vacío
        if(!info.isEmpty()){
            //Enviamos la info a otra actividad nueva
            //Crear el intent para arrancar la otra actividad
            Intent goToReceiver = new Intent(this,ReceiverActivity.class);
            //Adjuntar la info
            goToReceiver.putExtra("info",info);
            //Arrancar!
            startActivity(goToReceiver);
        }else{
            //Solicitar al usuario que incluya alguna información
            String message = getResources().getString(R.string.no_info);
            Toast aviso =
                    Toast.makeText(this,
                            message,
                            Toast.LENGTH_LONG);
            aviso.show();

            //Toast.makeText(this,"Un mensaje",Toast.LENGTH_SHORT).show();
        }
    }
}
