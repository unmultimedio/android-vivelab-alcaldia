package net.sikuani.nombreslistas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by julian on 12/9/14.
 */
public class MyNamesAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final List<String> objects;

    public MyNamesAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.customized_row, parent, false);

        ((TextView)view.findViewById(R.id.textViewName)).setText(objects.get(position));
        ((TextView)view.findViewById(R.id.textViewId)).setText("("+position+")");
        ((TextView)view.findViewById(R.id.textViewOther)).setText("objects("+position+")");

        return view;

        //return super.getView(position, convertView, parent);
    }
}
