package com.fablab.insper.fablabinsper;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Calendario extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DatabaseReference mDatabase;
    private StorageReference mStorageRef;
    public List<LendoDadosHome> listaObjetos = new ArrayList<LendoDadosHome>();
    private LinearLayout linearLayout;
    private LinearLayout linearLayout_1;
    private LinearLayout verticalLayout;
    private CalendarView mCalendarView;
    private Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        myDialog = new Dialog(this);


        mCalendarView =  (CalendarView) findViewById(R.id.CalendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                ShowPopup(view, year,  month+1, dayOfMonth);
            }
        });

        ScrollView scrollView = new ScrollView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(0,160,0,0);
        scrollView.setLayoutParams(layoutParams);



        linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(linearParams);

        scrollView.addView(linearLayout);

        LinearLayout linearLayout1 = findViewById(R.id.rootContainer_calendario);
        if (linearLayout1 != null) {
            linearLayout1.addView(scrollView);
        }
    }


    public void ShowPopup(final View v, int year, int month, int dayOfMonth) {
        final TextView txtclose;
        Button btnFollow;
        final String data_string = (Integer.toString(dayOfMonth)+":"+Integer.toString(month)+":"+Integer.toString(year));
        myDialog.setContentView(R.layout.popup_calendario);
        final LinearLayout linearLayout_root = myDialog.findViewById(R.id.rootPopUp);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);

        //txtclose.setText("M");

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Paginas");
        mStorageRef = FirebaseStorage.getInstance().getReference();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mostrarDados(dataSnapshot,data_string);
                Log.i("Esperadaaao", data_string);
                for(int i = 0; i < listaObjetos.size(); i++){
//                    Log.i("nomeeeeeeeee", String.valueOf(listaObjetos.get(i).getNome_pessoa()));

                    if(listaObjetos.get(i).getData_dev().equals(data_string)) {
                        Log.i("Esperado", "aqui temmmmmmmm");
                        LayoutInflater inflater = getLayoutInflater();
                        LinearLayout layout =  (LinearLayout) inflater.inflate(R.layout.padrao_calendario, null);
                        TextView nomePessoa = layout.findViewById(R.id.nome_pessoa);
                        TextView nomeObjeto = layout.findViewById(R.id.nome_objeto);

                        nomePessoa.setText((CharSequence) listaObjetos.get(i).getNome_pessoa());
                        nomeObjeto.setText((CharSequence) listaObjetos.get(i).getNome_sensor());
                        linearLayout_root.addView(layout);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    private void mostrarDados(DataSnapshot dataSnapshot,String data_string) {
        for (DataSnapshot ds: dataSnapshot.getChildren()){
            listaObjetos = new ArrayList<LendoDadosHome>();
            String key = ds.getKey().toString();
            String value = ds.getValue().toString();


            if(key.equals("Objetos_emprestados")) {
                for (DataSnapshot data : ds.getChildren()) {
                    String key_data = data.getKey().toString();
                    Log.i("data", String.valueOf(key_data));
                    if(key_data.equals(data_string)) {

                        for (DataSnapshot objeto : data.getChildren()) {
                            LendoDadosHome uDados = new LendoDadosHome();
                            String key_index = ds.getKey().toString();

                            uDados.setNome_pessoa(objeto.getValue(LendoDadosHome.class).getNome_pessoa());
                            uDados.setData_dev(objeto.getValue(LendoDadosHome.class).getData_dev());
                            uDados.setNome_sensor(objeto.getValue(LendoDadosHome.class).getNome_sensor());
                            listaObjetos.add(uDados);
                        }
//                        Log.i("nomeeeeeeeee", String.valueOf(uDados.getNome_pessoa()));

                    }
                }
            }


        }



    }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.calendario, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home_button) {
            startActivity(new Intent(getApplicationContext(), Home.class));
            finish();

        } else if (id == R.id.emprestimos_button) {
            startActivity(new Intent(getApplicationContext(), Emprestimos.class));
            finish();

        } else if (id == R.id.calendario_button) {

        } else if (id == R.id.instrucoes_button) {
            startActivity(new Intent(getApplicationContext(), Instrucoes.class));
            finish();

        } else if (id == R.id.historico_button) {
            startActivity(new Intent(getApplicationContext(), Historico.class));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
