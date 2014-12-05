package net.sikuani.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SenderFragment extends Fragment {

    Communicator interf;

    public SenderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        interf = (Communicator) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sender, container, false);
    }


    public void sendData(){
        String info;
        EditText edit;

        edit = (EditText) getActivity().findViewById(R.id.editText);
        info = edit.getText().toString();

        interf.sendData(info);

    }
}
