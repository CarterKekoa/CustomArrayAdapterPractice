package com.example.customarrayadapterfuns1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contact> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        /*
        Create a new project called Custom ArrayAdapter Fun
        Task #1: Create a Java class called Contact to represent a user’s contact
        Include a name field and a phone number field (both strings)
        Add constructors
        Add getters/setters
        Override toString() to return the contact’s name

        Task #2: In MainActivity’s onCreate()
        Create a List of Contact objects with at least two contacts
        Create a ListView and set it as the content view
        Create an ArrayAdapter to bind your ArrayList to your ListView
        Run your app! Can see the names of your contacts in the ListView?
         */
        contactList = new ArrayList<Contact>();
        contactList.add(new Contact());
        contactList.add(new Contact("Spike", "509-509-5095"));

        ListView listView = new ListView(this);
        setContentView(listView);

        // moving beyond simple_list_item_2... to simple_list_item_2!!
        // need to subclass ArrayAdapter and override getView()
        // getView returns a view (row) for each item in data source
        // do twice
        // 1. do simple_list_item_1
        // 2. do simple_list_item_2
        ArrayAdapter<Contact> arrayAdapter = new ArrayAdapter<Contact>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, //which view is the "main" view
                contactList) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                //we can set values for subviews of the view
                //for simple_list_item_1... the view is a textView
                //first, get the Contact at position
                Contact contact = contactList.get(position);
                //next, we need a reference to the TextView
//                TextView tv1 = (TextView) view.findViewById(R.id.text); //dont forget view.f
//                tv1.setText(contact.toString());

                //2. simple_list_item_2
                //  task, do this! first text view show name, second show phone number
                TextView tv1 = (TextView) view.findViewById(android.R.id.text1);
                tv1.setText(contact.getName());
                TextView tv2 = (TextView) view.findViewById(android.R.id.text2);
                tv2.setText(contact.getPhoneNumber());

                return view;
            }
        };
        listView.setAdapter(arrayAdapter);

    }
}
