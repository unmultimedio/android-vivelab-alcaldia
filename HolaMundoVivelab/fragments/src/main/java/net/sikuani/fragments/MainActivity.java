package net.sikuani.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener, Communicator {

    SenderFragment f1;
    ReceiverFragment f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);

        f1 = (SenderFragment)
                getFragmentManager().findFragmentById(R.id.fragment1);
        f2 = (ReceiverFragment)
                getFragmentManager().findFragmentById(R.id.fragment2);
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

    @Override
    public void onClick(View v) {
        //Hay un click en el botón
        EditText field = (EditText) findViewById(R.id.editText);
        //Obtener la información del usuario
        String info = field.getText().toString();
        //Si no viene vacío
        if(!info.isEmpty()){
            //Enviar al fragmento
            f1.sendData();
        }else{
            //Solicitar al usuario que incluya alguna información
            String message = getResources().getString(R.string.empty);
            Toast aviso =
                    Toast.makeText(this,
                            message,
                            Toast.LENGTH_LONG);
            aviso.show();

            //Toast.makeText(this,"Un mensaje",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void sendData(String info) {
        f2.receiveData(info);
    }

    @Override
    public void receiveData(String info) {

    }
}
