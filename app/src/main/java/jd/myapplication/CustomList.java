package jd.myapplication;

/**
 * Created by Dishesh on 28-02-2018.
 */
        import android.app.Activity;
        import android.nfc.Tag;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import java.util.List;

public class CustomList extends ArrayAdapter<String>
{
    private final Activity context;
    private final List<String> web;

    public CustomList(Activity context, List<String> web) {
        super(context, R.layout.list_row);

        this.context=context;
        this.web=web;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {   Log.d("GETVIEW","INSIDE");
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_row, null, true);
        TextView txtTitle =  (TextView) rowView.findViewById(R.id.txt);
        txtTitle.setText((CharSequence) web.get(position));
        Log.d("CustomList", "ListSet" + web.get(position));
//        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}

