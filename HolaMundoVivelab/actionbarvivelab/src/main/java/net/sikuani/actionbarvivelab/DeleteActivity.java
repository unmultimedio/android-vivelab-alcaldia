package net.sikuani.actionbarvivelab;

import android.os.Bundle;


public class DeleteActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
