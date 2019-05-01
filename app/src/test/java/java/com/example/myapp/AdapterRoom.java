package java.com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterRoom extends ArrayAdapter<Room> {

    private Context context;
    private int layoutID ;
    private List<Room> data;
    public AdapterRoom(@NonNull Context context, int resource, @NonNull List<Room> objects) {
        super(context, resource, objects);
        this.context =context;
        this.data = objects;
        this.layoutID = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutID,parent,false);
        ImageView image = view.findViewById(R.id.iconroom);
        TextView name = view.findViewById(R.id.tvname);
        Room r = data.get(position);
        int imageid = r.selected ? R.drawable.room2 : R.drawable.room;
        image.setImageResource(imageid);
        name.setText(r.name);
        return view;

    }
}
