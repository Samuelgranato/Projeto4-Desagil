package com.fablab.insper.fablabinsper;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Emprestimos extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DatabaseReference mDatabase;
    private StorageReference mStorageRef;
    public List<LendoDados> listaObjetos = new ArrayList<LendoDados>();
    private LinearLayout linearLayout;
    private LinearLayout linearLayout_1;
    private LinearLayout verticalLayout;
    private Dialog myDialog;
    private Dialog myDialog2;


    private Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprestimos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        mDatabase = FirebaseDatabase.getInstance().getReference().child("Paginas");
        mStorageRef = FirebaseStorage.getInstance().getReference();

        myDialog = new Dialog(this);

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


                    final CheckBox checkbox = layout.findViewById(R.id.checkbox);
                    checkbox.setId(R.id.checkbox+i);
                    List<String> myList = new ArrayList<>();
                    myList.add(listaObjetos.get(i).getDescricao_emprestimo());
                    myList.add(listaObjetos.get(i).getIntervalo_emprestimo());
                    myList.add(listaObjetos.get(i).getAtraso_emprestimo());
                    myList.add(listaObjetos.get(i).getPerda_emprestimo());
                    myList.add(listaObjetos.get(i).getNome_emprestimo());



                    map.put(R.id.checkbox+i,myList);



                    checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            ShowPopup(buttonView,checkbox.getId());
                            checkbox.setChecked(false);
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

    public void ShowPopup(final View v, final int id) {
        final TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.popup_descricao);
        final LinearLayout linearLayout_root = myDialog.findViewById(R.id.rootContainer_descricao);

        TextView descricao = (TextView) myDialog.findViewById(R.id.descricao_content);
        descricao.setText(map.get(id).get(0));

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = Calendar.getInstance().getTime();
        final String reportDate = df.format(hoje);
        String day = reportDate.substring(0,2);

        int day_int = Integer.parseInt(day);
        day_int+=Integer.parseInt(map.get(id).get(1));
        day = (String.valueOf(day_int) + reportDate.substring(2));
        TextView devolucao = (TextView) myDialog.findViewById(R.id.devolucao_value);
        devolucao.setText(day);

        TextView retirada = (TextView) myDialog.findViewById(R.id.retirada_value);
        retirada.setText(reportDate);

        TextView atraso = (TextView) myDialog.findViewById(R.id.atraso_value);
        atraso.setText(map.get(id).get(2));

        TextView perda = (TextView) myDialog.findViewById(R.id.perda_value);
        perda.setText(map.get(id).get(3));


        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog2 = new Dialog(this);

        ImageButton confirma_button = (ImageButton) myDialog.findViewById(R.id.confirma);
        confirma_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup2(v,day,reportDate,map.get(id).get(2));
            }
        });


        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void ShowPopup2(final View v,String day, String reportDate, String nome) {
        final TextView txtclose;
        myDialog2.setContentView(R.layout.popup_confirmacao);
        final LinearLayout linearLayout_root = myDialog2.findViewById(R.id.rootPopUp);
        Button okclose =(Button) myDialog2.findViewById(R.id.okbutton);



        okclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Esperadaaao1", "efefefeff");

                mDatabase = FirebaseDatabase.getInstance().getReference().child("Paginas").child("Usuarios");
                mStorageRef = FirebaseStorage.getInstance().getReference();

                myDialog = new Dialog(Emprestimos.this);

                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Log.i("Esperadaaao2", "efefefeff");
                        for (DataSnapshot usuario : dataSnapshot.getChildren()) {
                            if (usuario.getKey().equals(Login.KeyUsuarioApp)) {
                                Log.i("Esperadaaao3", "efefefeff");

                                for (DataSnapshot item : usuario.getChildren()) {

                                    if (item.getKey().equals("items")) {
                                        Log.i("Esperadaaao2", "efefefeff");

                                        int i = 1;
                                        while(item.child("item_"+Integer.toString(i)).exists()){
                                            i+=1;
                                        }
                                        Log.i("Esperadaaao3223", "item_"+Integer.toString(i));
                                            item.child("item_"+Integer.toString(i)).child("data_dev");
                                        mDatabase.child("Paginas").child("Usuarios").child(Login.KeyUsuarioApp).child("items").child("item_"+Integer.toString(i)).child("data_dev").setValue()
                                        mDatabase.child("Paginas").child("Usuarios").child(Login.KeyUsuarioApp).child("items").child("item_"+Integer.toString(i)).child("data_emp").setValue()
                                        mDatabase.child("Paginas").child("Usuarios").child(Login.KeyUsuarioApp).child("items").child("item_"+Integer.toString(i)).child("nome").setValue()

//                                        for (DataSnapshot items : item.getChildren()) {
//
//                                        }
                                    }
                                }
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                mDatabase.child("Paginas").child("usuario_1").push().setValue(1);
                myDialog2.dismiss();
                myDialog.dismiss();
            }
        });
        myDialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog2.show();
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
                    uDados.setDescricao_emprestimo(ds_1.getValue(LendoDados.class).getDescricao_emprestimo());
                    uDados.setIntervalo_emprestimo(ds_1.getValue(LendoDados.class).getIntervalo_emprestimo());
                    uDados.setAtraso_emprestimo(ds_1.getValue(LendoDados.class).getAtraso_emprestimo());
                    uDados.setPerda_emprestimo(ds_1.getValue(LendoDados.class).getPerda_emprestimo());

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
