package com.fablab.insper.fablabinsper;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class Historico extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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


        ScrollView scrollView = new ScrollView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        scrollView.setLayoutParams(layoutParams);



//
//        LinearLayout linearLayout = new LinearLayout(this);
//        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        linearLayout.setLayoutParams(linearParams);
//
//        scrollView.addView(linearLayout);
//
//        ImageView imageView1 = new ImageView(this);
//        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        params1.setMargins(0, 30, 0, 30);
//        params1.gravity = Gravity.CENTER;
//        imageView1.setLayoutParams(params1);
//        imageView1.setImageResource(R.drawable.cortadora_laser);
//        linearLayout.addView(imageView1);
//
//        ImageView imageView2 = new ImageView(this);
//        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        params2.setMargins(0, 0, 0, 30);
//        params2.gravity = Gravity.CENTER;
//        imageView2.setLayoutParams(params2);
//        imageView2.setImageResource(R.drawable.cortadora_laser);
//        linearLayout.addView(imageView2);
//
//        ImageView imageView3 = new ImageView(this);
//        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        params3.setMargins(0, 0, 0, 30);
//        params3.gravity = Gravity.CENTER;
//        imageView3.setLayoutParams(params3);
//        imageView3.setImageResource(R.drawable.cortadora_laser);
//        linearLayout.addView(imageView3);
//
//        ImageView imageView4 = new ImageView(this);
//        LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        params4.setMargins(0, 0, 0, 30);
//        params4.gravity = Gravity.CENTER;
//        imageView4.setLayoutParams(params4);
//        imageView4.setImageResource(R.drawable.cortadora_laser);
//        linearLayout.addView(imageView4);
//
//        ImageView imageView5 = new ImageView(this);
//        LinearLayout.LayoutParams params5 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        params5.setMargins(0, 0, 0, 30);
//        params5.gravity = Gravity.CENTER;
//        imageView5.setLayoutParams(params5);
//        imageView5.setImageResource(R.drawable.cortadora_laser);
//        linearLayout.addView(imageView5);
//
//        ImageView imageView6 = new ImageView(this);
//        LinearLayout.LayoutParams params6 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        params6.setMargins(0, 0, 0, 30);
//        params6.gravity = Gravity.CENTER;
//        imageView6.setLayoutParams(params6);
//        imageView6.setImageResource(R.drawable.cortadora_laser);
//        linearLayout.addView(imageView6);
//
//        LinearLayout linearLayout1 = findViewById(R.id.rootContainer_historico);
//        if (linearLayout1 != null) {
//            linearLayout1.addView(scrollView);
//        }

        android.support.v7.widget.GridLayout gridLayout = new android.support.v7.widget.GridLayout(this);
        gridLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        gridLayout.setColumnCount(3);

        for (int i = 0; i < 9; i++) {
            ImageView imageView = new ImageView(this);
//            Button button = new Button(Historico.this);
            GridLayout.LayoutParams lp = (GridLayout.LayoutParams) imageView.getLayoutParams();

            if (lp == null) {
                lp = new GridLayout.LayoutParams();
            }
            lp.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1, 1f);
            imageView.setLayoutParams(lp);
            imageView.setImageResource(R.drawable.cortadora_laser);
            gridLayout.addView(imageView);
        }

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.addView(gridLayout);
        setContentView(linearLayout);




//        List<String> facilities = new LinkedList<>();
//        facilities.add("textgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggo 0");
//        facilities.add("textgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggo 0");
//        facilities.add("textgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggo 0");
//        facilities.add("textgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggo 0");
//        facilities.add("textgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggo 0");
//        facilities.add("textgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggo 0");
//        facilities.add("texto 1");
//        GridLayout gridLayout = new GridLayout(this);
//        int total = facilities.size();
//        int column =  2;
//        int row = total / column;
//        gridLayout.setAlignmentMode(GridLayout.ALIGN_BOUNDS);
//        gridLayout.setColumnCount(column);
//        gridLayout.setRowCount(row + 1);
//        TextView titleText;
//        for(int i =0, c = 0, r = 0; i < total; i++, c++)
//        {
//            if(c == column)
//            {
//                c = 0;
//                r++;
//            }
//            titleText = new TextView(this);
//            titleText.setText(facilities.get(i));
//            gridLayout.addView(titleText, i);
//            titleText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
//            GridLayout.LayoutParams param =new GridLayout.LayoutParams();
//            param.height = GridLayout.LayoutParams.WRAP_CONTENT;
//            param.width = GridLayout.LayoutParams.WRAP_CONTENT;
//            param.rightMargin = 5;
//            param.topMargin = 5;
//            param.setGravity(Gravity.CENTER);
//            param.columnSpec = GridLayout.spec(c);
//            param.rowSpec = GridLayout.spec(r);
//            titleText.setLayoutParams (param);
//        }

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
