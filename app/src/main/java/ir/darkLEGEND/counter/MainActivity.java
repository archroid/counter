package ir.darkLEGEND.counter;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int CountedNum;
    AppCompatButton Add;
    AppCompatButton Minse;
    TextView CountedNumTextView;
    TextView navHeaderTV;
    SharedPreferences preferences;
    String Username;
    TextView textViewName;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountedNum = 0;

        preferences = getSharedPreferences("Settings",MODE_PRIVATE);
        Username = preferences.getString("Username", "user");

        Add = findViewById(R.id.Button_Add);
        toolbar = findViewById(R.id.toolbar);
        CountedNumTextView = findViewById(R.id.CountedNumTextView);
        textViewName = findViewById(R.id.TextView_Name);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        navHeaderTV = findViewById(R.id.navHeaderTV);

        setSupportActionBar(toolbar);


        Add.setOnClickListener(this);

        textViewName.setText(Username);
        navHeaderTV.setText(Username);

//        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle aToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(aToggle);
        aToggle.syncState();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == Add.getId()) {
            CountedNum ++ ;
            CountedNumTextView.setText(Integer.toString(CountedNum));
        }

    }

//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        int mId = item.getItemId();
//
//        switch (mId) {
//
//            case R.id.mail:
//                Toast.makeText(this, "Inbox Selected", Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.setting:
//                Toast.makeText(this, "Stars Selected", Toast.LENGTH_SHORT).show();
//                break;
//
//
//            case R.id.archive:
//                Toast.makeText(this, "Archive Selected", Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.add:
//                Toast.makeText(this, "Add  Selected", Toast.LENGTH_SHORT).show();
//                break;
//
//        }
//
//        drawerLayout.closeDrawer(GravityCompat.START);
//
//        return true;
//
//    }
//

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);

        } else {

            super.onBackPressed();

        }

    }
}
