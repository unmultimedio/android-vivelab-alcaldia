package net.sikuani.actionbarvivelab;

import android.os.Bundle;


public class NewActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
