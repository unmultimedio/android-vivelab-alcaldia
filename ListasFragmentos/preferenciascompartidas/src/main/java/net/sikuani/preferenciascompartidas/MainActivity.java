package net.sikuani.preferenciascompartidas;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    private final String packageName = "net.sikuani.preferenciascompartidas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getPreferences(MODE_PRIVATE);
        editor = prefs.edit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        reloadPrefs();
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

    public void clearData(View view){
        editor.remove(packageName+".var1");
        editor.remove(packageName+".var2");
        editor.remove(packageName+".var3");
        editor.commit();

        reloadPrefs();
    }

    public void saveData(View view){
        EditText var;
        String key;
        switch (view.getId()){
            case R.id.var1set:
                var = (EditText)findViewById(R.id.var1edit);
                String text = var.getText().toString();
                if(!text.isEmpty()){
                    key = packageName+".var1";
                    editor.putString(key,text);
                }else{
                    Toast.makeText(this,
                            "Dato vacío",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.var2set:
                var = (EditText)findViewById(R.id.var2edit);
                try {
                    int value = Integer.valueOf(var.getText().toString());
                    key = packageName+".var2";
                    editor.putInt(key,value);
                }catch (Exception e){
                    //El texto está vacío o no es entero
                    Toast.makeText(this,
                            "Entero no válido",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.var3set:
                CheckBox cb = (CheckBox)findViewById(R.id.var3edit);
                boolean val = cb.isChecked();
                key = packageName+".var3";
                editor.putBoolean(key,val);
                break;
            default:
                return;
        }
        //Guardar
        editor.commit();
        reloadPrefs();
    }

    public void reloadPrefs(){
        String v1,v2,v3;

        //Consulto
        v1 = prefs.getString(packageName + ".var1", null);
        if(v1 == null)
            v1 = getResources().getString(R.string.no_data);

        v2 = prefs.contains(packageName + ".var2") ?
                String.valueOf(prefs.getInt(packageName + ".var2",0)) :
                getResources().getString(R.string.no_data);

        v3 = prefs.contains(packageName + ".var3") ?
                String.valueOf(prefs.getBoolean(packageName + ".var3", false)) :
                getResources().getString(R.string.no_data);

        //Seteo
        ((TextView)findViewById(R.id.var1data)).setText(v1);
        ((TextView)findViewById(R.id.var2data)).setText(v2);
        ((TextView)findViewById(R.id.var3data)).setText(v3);
    }
}
