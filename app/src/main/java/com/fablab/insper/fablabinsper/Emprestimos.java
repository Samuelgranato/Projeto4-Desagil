package com.fablab.insper.fablabinsper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Emprestimos extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprestimos);

        ScrollView scrollView = new ScrollView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        scrollView.setLayoutParams(layoutParams);

        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(linearParams);

        scrollView.addView(linearLayout);


        ImageButton imageView1 = new ImageButton(this);
        TextView nome1 = new TextView(this);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params1t = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params1.setMargins(0, 0, 0, 5);
        params1t.setMargins(0, 0, 0, 5);
        params1.gravity = Gravity.CENTER;
        //params1t.height = params1.getMarginEnd();
        params1t.gravity = Gravity.LEFT;
        nome1.setLayoutParams(params1t);
        nome1.setText("Tesoura");
        imageView1.setLayoutParams(params1);
        imageView1.setImageResource(R.drawable.cortadora_laser);
        imageView1.setOnClickListener(b1);
        linearLayout.addView(imageView1);
        linearLayout.addView(nome1);


        ImageButton imageView2 = new ImageButton(this);
        TextView nome2 = new TextView(this);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params2t = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params2.setMargins(0, 0, 0, 5);
        params2t.setMargins(0, 0, 0, 5);
        params2.gravity = Gravity.CENTER;
        //params2t.height = params2.getMarginEnd();
        params2t.gravity = Gravity.LEFT;
        nome2.setLayoutParams(params2t);
        nome2.setText("Tesoura");
        imageView2.setLayoutParams(params2);
        imageView2.setImageResource(R.drawable.cortadora_laser);
        imageView2.setOnClickListener(b2);
        linearLayout.addView(imageView2);
        linearLayout.addView(nome2);

        ImageButton imageView3 = new ImageButton(this);
        TextView nome3 = new TextView(this);
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params3t = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params3.setMargins(0, 0, 0, 5);
        params3t.setMargins(0, 0, 0, 5);
        params3.gravity = Gravity.CENTER;
        params3t.gravity = Gravity.TOP;
        nome3.setLayoutParams(params3t);
        nome3.setText("Tesoura");
        imageView3.setLayoutParams(params3);
        imageView3.setImageResource(R.drawable.cortadora_laser);
        imageView3.setOnClickListener(b3);
        linearLayout.addView(imageView3);
        linearLayout.addView(nome3);

        ImageButton imageView4 = new ImageButton(this);
        TextView nome4 = new TextView(this);
        LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params4t = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params4.setMargins(0, 0, 0, 25);
        params4t.setMargins(0, 0, 0, 5);
        params4.gravity = Gravity.CENTER;
        params4t.gravity = Gravity.TOP;
        nome4.setLayoutParams(params4t);
        nome4.setText("Tesoura");
        imageView4.setLayoutParams(params4);
        imageView4.setImageResource(R.drawable.cortadora_laser);
        imageView4.setOnClickListener(b4);
        linearLayout.addView(imageView4);
        linearLayout.addView(nome4);

        ImageButton imageView5 = new ImageButton(this);
        TextView nome5 = new TextView(this);
        LinearLayout.LayoutParams params5 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params5t = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params5.setMargins(0, 0, 0, 25);
        params5.setMargins(0, 0, 0, 5);
        nome5.setLayoutParams(params5t);
        nome5.setText("Tesoura");
        params5.gravity = Gravity.CENTER;
        params5t.gravity = Gravity.TOP;
        imageView5.setLayoutParams(params5);
        imageView5.setImageResource(R.drawable.cortadora_laser);
        imageView5.setOnClickListener(b5);
        linearLayout.addView(imageView5);
        linearLayout.addView(nome5);

        ImageButton imageView6 = new ImageButton(this);
        TextView nome6 = new TextView(this);
        LinearLayout.LayoutParams params6 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params6t = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params6.setMargins(0, 0, 0, 5);
        params6t.setMargins(0, 0, 0, 25);
        nome6.setLayoutParams(params6t);
        nome6.setText("Tesoura");
        params6.gravity = Gravity.CENTER;
        params6t.gravity = Gravity.TOP;
        imageView6.setLayoutParams(params6);
        imageView6.setImageResource(R.drawable.cortadora_laser);
        imageView6.setOnClickListener(b6);
        linearLayout.addView(imageView6);
        linearLayout.addView(nome6);

        LinearLayout linearLayout1 = findViewById(R.id.rootContainer_emprestimos);
        if (linearLayout1 != null) {
            linearLayout1.addView(scrollView);
        }
    }

    View.OnClickListener b1 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), Materiais.class));
            finish();
        }
    };

    View.OnClickListener b2 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), Materiais.class));
            finish();
        }
    };
    View.OnClickListener b3 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), Materiais.class));
            finish();
        }
    };
    View.OnClickListener b4 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), Materiais.class));
            finish();
        }
    };
    View.OnClickListener b5 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), Materiais.class));
            finish();
        }
    };
    View.OnClickListener b6 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), Materiais.class));
            finish();
        }
    };


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
