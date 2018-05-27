package com.fablab.insper.fablabinsper;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class Home extends AppCompatActivity {

    private DatabaseReference mDatabase;

    private TextView mNameView;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Paginas");
        mListView = (ListView) findViewById(R.id.listview);
        mNameView = (TextView) findViewById(R.id.textView11);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                showData(dataSnapshot);
//                String name = dataSnapshot.getValue().toString();
//
//                mNameView.setText("Name: " + name);
//                System.out.printf(name);
//                Log.i("Esperado",name.substring(0,7));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showData(DataSnapshot dataSnapshot) {
        String noticia = "Noticia_";
//        Log.i("Esperado",dataSnapshot.getValue().toString());
        for (DataSnapshot ds : dataSnapshot.getChildren()){
            for(DataSnapshot ds_1 : ds.getChildren()){
                UserInformation uInfo = new UserInformation();
                uInfo.setImg(ds_1.getValue(UserInformation.class).getImg());
                uInfo.setTitulo(ds_1.getValue(UserInformation.class).getTitulo());
                uInfo.setTexto(ds_1.getValue(UserInformation.class).getTexto());
                Log.i("Esperado",uInfo.getTexto());
                Log.i("Esperado",uInfo.getImg());
                Log.i("Esperado",uInfo.getTitulo());
            }
//            UserInformation uInfo = new UserInformation();
//            uInfo.setImg(ds.child(noticia+a).getValue(UserInformation.class).getImg());
//            uInfo.setTitulo(ds.child(noticia+a).getValue(UserInformation.class).getTitulo());
//            uInfo.setTexto(ds.child(noticia+a).getValue(UserInformation.class).getTexto());
//            Log.i("Esperado",ds.getValue().toString());
//            Log.i("Esperado",noticia + a);
//            Log.i("Esperado",ds.child(noticia+a).getValue().toString());
//
//
//
//
//
//
//              Log.i("Esperado",ds.getValue().toString());
//            for(DataSnapshot ds_1 : ds.getChildren()){
//                Log.i("Esperado",ds_1.getValue().toString());
//                b++;
//            }
        }
    }
//        for (DataSnapshot ds : dataSnapshot.getChildren()){
//
//            UserInformation uInfo = new UserInformation();
//            uInfo.setImg(ds.child("Noticia_1").getValue(UserInformation.class).getImg());
//            uInfo.setTexto(ds.child("Noticia_1").getValue(UserInformation.class).getTexto());
//            uInfo.setTitulo(ds.child("Noticia_1").getValue(UserInformation.class).getTitulo());
//
//
//            Log.i("Esperado",uInfo.getImg());

//            Log.d(TAG, "showData: " + uInfo.getImg());
//            Log.d(TAG, "showData: " + uInfo.getTexto());
//            Log.d(TAG, "showData: " + uInfo.getTitulo());

//            ArrayList<String> array = new ArrayList<>();
//            array.add(uInfo.getImg());
//            array.add(uInfo.getTexto());
//            array.add(uInfo.getTitulo());
//
//            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
//            mListView.setAdapter(adapter);




//        }
//    }
}
