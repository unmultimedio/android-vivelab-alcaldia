package net.sikuani.actionbarvivelab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


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

        Intent goToAnotherActivity;

        switch (item.getItemId()){
            case R.id.action_delete:
                goToAnotherActivity =
                        new Intent(this, DeleteActivity.class);
                break;
            case R.id.action_new:
                goToAnotherActivity =
                        new Intent(this, NewActivity.class);
                break;
            case R.id.action_settings:
                goToAnotherActivity =
                        new Intent(this, SettingsActivity.class);
                break;
            default:
                return true;
        }

        startActivity(goToAnotherActivity);

        return super.onOptionsItemSelected(item);
    }
}
