package com.acadgild.balu.acd_an_session_6_assignment_4_main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contact> array_contacts;
    ListView listView_contacts;
    CustomAdapter customAdapter_contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        array_contacts = new ArrayList<>();

        array_contacts.add(new Contact("Pushpa", "998878877"));
        array_contacts.add(new Contact("Latha", "998878874"));
        array_contacts.add(new Contact("Arjun", "998878844"));
        array_contacts.add(new Contact("Kiran", "798878877"));
        array_contacts.add(new Contact("Arnav", "996878877"));

        listView_contacts = (ListView) findViewById(R.id.listView_contacts);
        customAdapter_contacts = new CustomAdapter(getApplicationContext(), array_contacts);
        listView_contacts.setAdapter(customAdapter_contacts);
        registerForContextMenu(listView_contacts);
    }

    @Override

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle(getResources().getString(R.string.context_menu_title));
        menu.add(100, 1, 1, getResources().getString(R.string.context_menu_item_call));
        menu.add(100, 2, 2, getResources().getString(R.string.context_menu_item_sms));
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterView.AdapterContextMenuInfo contextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String phone_number = array_contacts.get(contextMenuInfo.position).getContact_number();

        if (item.getItemId() == 1)
        {
            Intent intent_call = new Intent(Intent.ACTION_DIAL);
            intent_call.setData(Uri.parse("tel:" + phone_number));
            startActivity(intent_call);
        }
        else if (item.getItemId() == 2)
        {
            Intent intent_sms = new Intent(Intent.ACTION_VIEW);
            intent_sms.setData(Uri.parse("smsto:" + phone_number));
            startActivity(intent_sms);
        }
        return super.onContextItemSelected(item);
    }
}
