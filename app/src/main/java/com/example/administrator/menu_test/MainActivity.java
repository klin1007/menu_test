package com.example.administrator.menu_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerForContextMenu(findViewById(R.id.my_layout));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

//        menu.add(Menu.NONE,Menu.FIRST,Menu.NONE,"Item");

        for(int i = 0; i < 5; i++){
            menu.add(Menu.NONE, Menu.FIRST + i, Menu.NONE, "Item " + Integer.toString(i + 1));
        }

        SubMenu subMenu = menu.addSubMenu(3,Menu.FIRST,Menu.NONE,"sub item");
        for(int i = 0; i < 3; i++){
            subMenu.add(Menu.NONE, Menu.FIRST + i, Menu.NONE, "sub item " + Integer.toString(i + 1));
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getGroupId() == Menu.NONE) {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if(item.getGroupId() == Menu.FIRST){
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        for(int i = 0; i < 5; i++){
            menu.add(5, Menu.FIRST + i, Menu.NONE, "Content menu item " + Integer.toString(i + 1));
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getGroupId() == 5) {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
