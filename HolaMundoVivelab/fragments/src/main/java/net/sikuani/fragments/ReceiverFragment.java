package net.sikuani.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceiverFragment extends Fragment {


    public ReceiverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receiver, container, false);
    }


    public void receiveData(String info) {
        TextView label = (TextView)
                getActivity().findViewById(R.id.receiverText);

        label.setText(info);
    }
}
