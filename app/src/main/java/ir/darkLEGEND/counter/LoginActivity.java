package ir.darkLEGEND.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences preferences;
    EditText ed_username;
    EditText ed_password;
    Button login;
    Button GoToRegister;
    String Username;
    String Password;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = getSharedPreferences("Settings",MODE_PRIVATE);
        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        login = findViewById(R.id.btn_login);
        GoToRegister = findViewById(R.id.btn_gotoregiser);
        toolbar = findViewById(R.id.toolbar);

        login.setOnClickListener(this);
        GoToRegister.setOnClickListener(this);

        setActionBar(toolbar);
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == login.getId()){
            GetData();
            if (CheckValid(Username , Password)){
                if (CheckLogin(Username , Password)){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    preferences.edit()
                            .putString("Username",Username)
                            .putBoolean("LogedIn",true)
                            .apply();

                    startActivity(intent);
                    finish();
                }
            }



        }
        if (v.getId() == GoToRegister.getId()){
            Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
            finish();

        }
    }


    boolean CheckValid(String Username, String Password) {
        if (Username.isEmpty() || Username.length() < 6 || Username.contains(" ") || Username.contains(".")) {
            ed_username.setError("Invalid Username");
            return false;
        }

        if (Password.isEmpty() || Password.length() < 10 || Password.contains(" ") || Password.contains(".") ) {
            ed_password.setError("Invalid Password");
            return false;
        }
        if ( Username.equals(Password)){
            ed_username.setError("Username and password should be different");
            ed_password.setError("Username and password should be different");
            return false;
        }


        else return true;

    }
     boolean CheckLogin(String Username , String Password){
        return true;
    }
    void GetData(){
        Username = ed_username.getText().toString().trim();
        Password = ed_password.getText().toString().trim();
    }
}
