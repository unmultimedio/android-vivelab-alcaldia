package net.sikuani.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    SharedPreferences prefs;
    SharedPreferences.Editor editorPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getPreferences(MODE_PRIVATE);
        editorPrefs = prefs.edit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        reloadPrefsInView();
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

    public void setPrefs(View view){
        switch (view.getId()){
            case R.id.set_var1:
                String val1 = ((EditText)findViewById(R.id.var1)).getText().toString();
                editorPrefs.putString("var1",val1);
                break;
            case R.id.set_var2:
                int val2 = Integer.valueOf(((EditText) findViewById(R.id.var2)).getText().toString());
                editorPrefs.putInt("var2",val2);
                break;
            case R.id.set_var3:
                boolean val3 = ((CheckBox)findViewById(R.id.var3)).isChecked();
                editorPrefs.putBoolean("var3",val3);
                break;
            default:
                return;
        }
        editorPrefs.commit();
        reloadPrefsInView();
    }

    public void reloadPrefsInView(){
        String var1, var2, var3;
        String noData = getResources().getString(R.string.no_data);
        var1 = prefs.getString("var1",noData);
        int var2Data = prefs.getInt("var2",Integer.MIN_VALUE);
        if(var2Data != Integer.MIN_VALUE){
            var2 = String.valueOf(var2Data);
        }else{
            var2 = noData;
        }
        if(prefs.contains("var3")){
            var3 = String.valueOf(prefs.getBoolean("var3",false));
        }else{
            var3 = noData;
        }

        ((TextView)findViewById(R.id.var1data)).setText(var1);
        ((TextView)findViewById(R.id.var2data)).setText(var2);
        ((TextView)findViewById(R.id.var3data)).setText(var3);
    }

    public void clearPrefs(View view){
        editorPrefs.remove("var1");
        editorPrefs.remove("var2");
        editorPrefs.remove("var3");
        editorPrefs.commit();

        reloadPrefsInView();
    }
}
