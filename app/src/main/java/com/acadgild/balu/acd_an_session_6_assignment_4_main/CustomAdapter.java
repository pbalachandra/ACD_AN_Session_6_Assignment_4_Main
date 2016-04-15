package com.acadgild.balu.acd_an_session_6_assignment_4_main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by BALU on 4/7/2016.
 */
public class CustomAdapter extends BaseAdapter
{
    ArrayList<Contact> array_contacts;
    LayoutInflater layoutInflater_contacts;

    public CustomAdapter(Context context, ArrayList<Contact> array_contacts)
    {
        this.array_contacts = array_contacts;
        layoutInflater_contacts = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return array_contacts.size();
    }

    @Override
    public Object getItem(int position)
    {
        return array_contacts.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = layoutInflater_contacts.inflate(R.layout.contact_list, parent, false);
        }

        TextView tv_contact_name = (TextView) convertView.findViewById(R.id.textView_contact_name);
        TextView tv_contact_number = (TextView) convertView.findViewById(R.id.textView_contact_number);

        Contact contact = array_contacts.get(position);

        tv_contact_name.setText(contact.getContact_name());
        tv_contact_number.setText(contact.getContact_number());

        return convertView;
    }
}
