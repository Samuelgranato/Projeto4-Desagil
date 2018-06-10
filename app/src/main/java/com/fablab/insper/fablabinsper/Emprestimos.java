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
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

public class Emprestimos extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DatabaseReference mDatabase;
    private StorageReference mStorageRef;
    public List<LendoDados> listaObjetos = new ArrayList<LendoDados>();
    private LinearLayout linearLayout;
    private LinearLayout linearLayout_1;
    private LinearLayout verticalLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprestimos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Paginas");
        mStorageRef = FirebaseStorage.getInstance().getReference();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mostrarDados(dataSnapshot);
                for(int i = 0; i < listaObjetos.size(); i++){

                    LayoutInflater inflater = Emprestimos.this.getLayoutInflater();
                    LinearLayout layout =  (LinearLayout) inflater.inflate(R.layout.padrao_emprestimos, null);

                    TextView nome_objeto = layout.findViewById(R.id.nome_objeto);
                    nome_objeto.setText((CharSequence) listaObjetos.get(i).getNome_emprestimo());

                    TextView funcao_objeto= layout.findViewById(R.id.funcao);
                    funcao_objeto.setText((CharSequence) listaObjetos.get(i).getFuncao_emprestimo());

                    TextView aplicacao_objeto = layout.findViewById(R.id.aplicacao);
                    aplicacao_objeto.setText((CharSequence) listaObjetos.get(i).getAplicacao_emprestimo());

                    CheckBox checkbox = layout.findViewById(R.id.checkbox);

                    checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            // update your model (or other business logic) based on isChecked

                        }
                    });


//                    TextView quantidade_objeto = layout.findViewById(R.id.quantidade);
//                    quantidade_objeto.setText((CharSequence) listaObjetos.get(i).getQuantidade_emprestimo());

                    linearLayout.addView(layout);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ScrollView scrollView = new ScrollView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(0,160,0,0);
        scrollView.setLayoutParams(layoutParams);



        linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(linearParams);

        scrollView.addView(linearLayout);

        LinearLayout linearLayout1 = findViewById(R.id.rootContainer_emprestimos);
        if (linearLayout1 != null) {
            linearLayout1.addView(scrollView);
        }
    }

    private void mostrarDados(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds: dataSnapshot.getChildren()){
            String key = ds.getKey().toString();
            Log.i("data", String.valueOf(key));

            if(key.equals("Emprestimos")) {
                for (DataSnapshot ds_1 : ds.getChildren()) {
                    LendoDados uDados = new LendoDados();
                    uDados.setNome_emprestimo(ds_1.getValue(LendoDados.class).getNome_emprestimo());
                    uDados.setFuncao_emprestimo(ds_1.getValue(LendoDados.class).getFuncao_emprestimo());
                    uDados.setAplicacao_emprestimo(ds_1.getValue(LendoDados.class).getAplicacao_emprestimo());
                    uDados.setQuantidade_emprestimo(ds_1.getValue(LendoDados.class).getQuantidade_emprestimo());
                    listaObjetos.add(uDados);
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
        //getMenuInflater().inflate(R.menu.pedidos, menu);
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

        } else if (id == R.id.calendario_button) {
            startActivity(new Intent(getApplicationContext(), Calendario.class));
            finish();

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
