package net.sikuani.nombreslistas;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity
        implements NamesFragment.OnFragmentInteractionListener,
    NamesReceiverFragment.OnFragmentInteractionListener {

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

    @Override
    public void clickedElement(String name) {
        //Estamos recibiendo la info de la lista clickeada
        //Hay que enviarla al 2
        NamesReceiverFragment fragmento2 = (NamesReceiverFragment) getFragmentManager().
                findFragmentById(R.id.fragment_names_receiver);

        Toast.makeText(this, "Enviando al f2: "+name,Toast.LENGTH_SHORT).show();

        fragmento2.updateAdapter(name);
    }
}
