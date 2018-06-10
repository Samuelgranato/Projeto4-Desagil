package com.fablab.insper.fablabinsper;

import android.content.Intent;
import android.os.Bundle;
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
import android.view.ViewGroup;
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

import java.util.ArrayList;
import java.util.List;

public class Historico extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public String KeyUsuarioApp;
    private List<LendoDadosHistorico> listaItemHistorico = new ArrayList<LendoDadosHistorico>();
    private DatabaseReference mDatabase;
    private StorageReference mStorageRef;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Comeca Programcao Hsitorico
        KeyUsuarioApp = "usuario_1";
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Paginas").child("Usuarios");
        mStorageRef = FirebaseStorage.getInstance().getReference();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mostrarDados(dataSnapshot);
                for(int i = 0; i < listaItemHistorico.size(); i++){
                    LayoutInflater inflater = Historico.this.getLayoutInflater();
                    LinearLayout layout =  (LinearLayout) inflater.inflate(R.layout.padrao_histotico, null);

                    TextView nome_item = layout.findViewById(R.id.nome_item_historico);
                    nome_item.setText((CharSequence) listaItemHistorico.get(i).getNome());

                    TextView data_emp = layout.findViewById(R.id.data_emp_historico);
                    data_emp.setText((CharSequence) listaItemHistorico.get(i).getData_emp());

                    TextView data_dev = layout.findViewById(R.id.data_dev_historico);
                    data_dev.setText((CharSequence) listaItemHistorico.get(i).getData_dev());
                    linearLayout.addView(layout);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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

        LinearLayout linearLayout1 = findViewById(R.id.rootContainer_historico);
        if (linearLayout1 != null) {
            linearLayout1.addView(scrollView);
        }
    }


    private void mostrarDados(DataSnapshot dataSnapshot) {
        for (DataSnapshot usuario :dataSnapshot.getChildren()){
            if (usuario.getKey().equals(KeyUsuarioApp)) {
                for (DataSnapshot item : usuario.getChildren()){
                    LendoDadosHistorico uDadosHistorico = new LendoDadosHistorico();
                    Log.d("Historico", String.valueOf(item.getValue()));
                    uDadosHistorico.setData_dev(item.getValue(LendoDadosHistorico.class).getData_dev());
                    uDadosHistorico.setData_emp(item.getValue(LendoDadosHistorico.class).getData_emp());
                    uDadosHistorico.setNome(item.getValue(LendoDadosHistorico.class).getNome());
                    listaItemHistorico.add(uDadosHistorico);
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
        //getMenuInflater().inflate(R.menu.tempo__emprestimos, menu);
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
            startActivity(new Intent(getApplicationContext(), Calendario.class));
            finish();

        } else if (id == R.id.instrucoes_button) {
            startActivity(new Intent(getApplicationContext(), Instrucoes.class));
            finish();

        } else if (id == R.id.historico_button) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
