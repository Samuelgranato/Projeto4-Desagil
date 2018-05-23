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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Materiais extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materiais);

        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(linearParams);

        TextView Info = new TextView(this);
        Info.setText("TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura" +
                        "TesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesouraTesoura");
    }
        //LinearLayout Status = new LinearLayout(this);





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