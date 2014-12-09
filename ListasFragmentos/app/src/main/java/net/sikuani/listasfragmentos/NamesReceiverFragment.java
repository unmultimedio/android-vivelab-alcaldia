package net.sikuani.listasfragmentos;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>
 * Activities containing this fragment MUST implement the {@link net.sikuani.listasfragmentos.NamesReceiverFragment.OnNamesReceiverFragmentInteractionListener}
 * interface.
 */
public class NamesReceiverFragment extends ListFragment {

    private OnNamesReceiverFragmentInteractionListener mListener;
    private ArrayAdapter myAdapter;
    private List<String> names;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NamesReceiverFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        names = new ArrayList<>();

        myAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, names);
        setListAdapter(myAdapter);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnNamesReceiverFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnNamesReceiverFragmentInteractionListener");
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerForContextMenu(getListView());
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
        }
    }

    public void addName(String name){
        if(!name.isEmpty()){
            names.add(name);
            myAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.names_context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int position = info.position;

        switch (item.getItemId()){
            case R.id.duplicate_name_item:
                names.add(position,names.get(position));
                break;
            case R.id.delete_name_item:
                names.remove(position);
                break;
        }

        myAdapter.notifyDataSetChanged();

        return super.onContextItemSelected(item);
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
    public interface OnNamesReceiverFragmentInteractionListener {

    }

}
