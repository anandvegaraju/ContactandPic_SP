package com.vegaraju.anand.contactandpic_sp;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.vegaraju.anand.contactandpic_sp.R.id.list1;

/**
 * Created by Anand on 26-06-2017.
 */

public class Tab1 extends ListFragment {
    private ListView mListView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.frag1, container, false);

        mListView = (ListView) rootview.findViewById(R.id.list1);



        return rootview;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        List<String> a = new ArrayList<String>();

        Cursor phones = getActivity().getApplicationContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            a.add(name);
            a.add(phoneNumber);
            a.add("---------------------------------------------------------------------");

        }
        phones.close();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>( getActivity(),  android.R.layout.simple_list_item_1, a );

        mListView.setAdapter(arrayAdapter);


    }





}






