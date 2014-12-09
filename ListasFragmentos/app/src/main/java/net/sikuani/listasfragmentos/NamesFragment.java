package net.sikuani.listasfragmentos;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>
 * Activities containing this fragment MUST implement the {@link NamesFragment.OnNamesFragmentInteractionListener}
 * interface.
 */
public class NamesFragment extends ListFragment {

    private OnNamesFragmentInteractionListener mListener;

    private List<String> names;
    private MyAdapter myAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NamesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        names = new ArrayList<>();
        for(String n : getResources().getStringArray(R.array.people_names)){
            names.add(n);
        }
        myAdapter = new MyAdapter(getActivity(),android.R.layout.simple_list_item_1, names);

        setListAdapter(myAdapter);

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnNamesFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnNamesFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (null != mListener) {
            Toast.makeText(getActivity(),"Click "+position, Toast.LENGTH_SHORT).show();
            mListener.nameClicked(names.get(position));
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnNamesFragmentInteractionListener {
        public void nameClicked(String name);
    }

}
