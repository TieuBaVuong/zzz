package java.com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.PopupMenu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView gridView;
    private ArrayList<Room> data;
    private AdapterRoom adapter;
    private String[] strArr = {"them" , "xoa","sua"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quanly);

        gridView = (GridView) findViewById(R.id.gridview) ;

        data = new ArrayList<>();
        for(int i =1;i<=50;i++){
            String name = "Phòng" + i;
            boolean select = false;
            Room x = new Room(name,select);
            data.add(x);
        }

        adapter = new AdapterRoom(this,R.layout.room,data);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Room r = data.get(position);

        ShowMenu();
        r.selected = !r.selected;
        adapter.notifyDataSetChanged();
    }

    private void ShowMenu(){
        final PopupMenu popupMenu = new PopupMenu(this,gridView);

        popupMenu.getMenuInflater().inflate(R.menu.menu_quanly,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
               /* switch (item.getItemId()){
                            break;
                    case R.id.xoa:
                        break;
                    case R.id.sua:
                        break;
                }*/


                return false;
            }
        });
        popupMenu.show();
    }
}
