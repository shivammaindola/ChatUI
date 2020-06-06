package com.example.styledotmetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Cursor phones;
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 10;
    ArrayList<String> alContacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alContacts=loadContacts();
        int i=0;

        //Dummy data
        MyListData[] myListData = new MyListData[] {
                new MyListData(R.drawable.pic1, alContacts.get(i++),"Hello","11:11","0"),
                new MyListData(R.drawable.pic2,alContacts.get(i++),"how are you?","10:11","1"),
                new MyListData(R.drawable.pic3,alContacts.get(i++),"kuch bhi","01:23","1"),
                new MyListData(R.drawable.pic4, alContacts.get(i++),"Nothing","12:44","0"),
                new MyListData(R.drawable.pic5,alContacts.get(i++),"Good night","01:13","0"),
                new MyListData(R.drawable.pic6,alContacts.get(i++),"Let's have some fun","03:11","1"),
                new MyListData(R.drawable.pic7, alContacts.get(i++),"Like what? ","06:11","0"),
                new MyListData(R.drawable.pic8,alContacts.get(i++),"Ummm..","08:01","1"),
                new MyListData(R.drawable.pic9,alContacts.get(i++),"Let's goto ladak","07:17","0"),
                new MyListData(R.drawable.pic1, alContacts.get(i++),"good plan","09:51","1"),
                new MyListData(R.drawable.pic7,alContacts.get(i++),"nahh","07:11","1"),
                new MyListData(R.drawable.pic4,alContacts.get(i++),"I'm ready","01:17","1"),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.chat_list);
        RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.first_recyclerview);
        MyListAdapter adapter = new MyListAdapter(myListData);
        ImgListAdapter adapter1= new ImgListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView1.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false));
        recyclerView.setAdapter(adapter);
        recyclerView1.setAdapter(adapter1);
    }


    ArrayList<String> loadContacts() {

        ArrayList<String> Contacts = new ArrayList<String>();

        // Check the SDK version and whether the permission is already granted or not.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        } else {
            ContentResolver cr = getApplicationContext().getContentResolver(); //Activity/Application android.content.Context
            Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            if (cursor.moveToFirst()) {

                do {
                    String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));


                        Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{id}, null);
                        while (pCur.moveToNext()) {
                            String contactNumber = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                            Contacts.add(contactNumber);
                            break;
                        }
                        pCur.close();


                } while (cursor.moveToNext());
            }
        }
        return Contacts;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                loadContacts();
            } else {
                Toast.makeText(this, "Until you grant the permission, we cannot display the names", Toast.LENGTH_SHORT).show();
            }
        }
    }
}