package net.sikuani.listasfragmentos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by julian on 12/8/14.
 */
public class MyAdapter extends ArrayAdapter<String> {

    Context context;
    List<String> objects;

    public MyAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View theNameView = inflater.inflate(R.layout.name_layout,parent, false);
        ((TextView)theNameView.findViewById(R.id.nameText)).setText(objects.get(position));
        ((TextView)theNameView.findViewById(R.id.idText)).setText("names["+position+"]");
        return theNameView;
    }
}
