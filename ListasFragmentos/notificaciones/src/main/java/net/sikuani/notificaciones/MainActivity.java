package net.sikuani.notificaciones;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

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

    public void makeNotification(View view){

        String title = ((EditText)findViewById(R.id.editTextTitle)).getText().toString();
        String content = ((EditText)findViewById(R.id.editTextContent)).getText().toString();
        String ticker = ((EditText)findViewById(R.id.editTextTicker)).getText().toString();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
                //(NotificationCompat.Builder) getSystemService(NOTIFICATION_SERVICE);

        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setTicker(ticker);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentInfo("-X-");

        builder.setAutoCancel(true);

        Intent goToActivity = new Intent(this, ResultsActivity.class);

        goToActivity.putExtra("title",title);
        goToActivity.putExtra("content",content);

        PendingIntent pendingGoToActivity =
                PendingIntent.getActivity(this,0,goToActivity,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingGoToActivity);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        manager.notify(0,builder.build());

        //builder.notify();

    }
}
