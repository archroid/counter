package ir.darkLEGEND.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    Button gotologin;
    Button register;
    EditText ed_Email;
    EditText ed_Username;
    EditText ed_Password;
    String Username;
    String Password;
    String Email;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        gotologin = findViewById(R.id.btn_gotologin);
        register = findViewById(R.id.btn_register);
        ed_Email = findViewById(R.id.ed_email);
        ed_Username = findViewById(R.id.ed_username);
        ed_Password = findViewById(R.id.ed_password);
        toolbar = findViewById(R.id.toolbar);
        setActionBar(toolbar);

        gotologin.setOnClickListener(this);
        register.setOnClickListener(this);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public boolean onNavigateUp() {
        onBackPressed();
        Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == register.getId()){
            GetData();
            if (CheckValid(Username , Password , Email)){
                if (SaveProfile(Username,Password,Email)){
                    Toast.makeText(this, "Account created! Now you can log in ...", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if (v.getId() == gotologin.getId()){
            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
    boolean CheckValid(String Username, String Password , String Email){
        if (Username.isEmpty() || Username.length() < 6 || Username.contains(" ") || Username.contains(".") ){
            ed_Username.setError("Invalid Username");
            return false;
        }
        if (Password.isEmpty() || Password.length() < 10 || Password.contains(" ") || Password.contains(".") ){
            ed_Password.setError("Invalid Password");
            return false;
        }
        if (Username.equals(Password)){
            ed_Username.setError("Username and password should be different");
            ed_Password.setError("Username and password should be different");
            return false;
        }
        if (
                        Email.isEmpty() ||
                        Email.lastIndexOf('@') <= 0 ||
                        !Email.contains(".") ||
                        Email.lastIndexOf('.') < Email.lastIndexOf('@')||
                        Email.split("@").length > 2
        ){
            ed_Email.setError("Invalid Email Address");
            return false;
        }
        else {
            return true;
        }


    }
    Boolean SaveProfile(String Username , String Password , String Email){
        return true;
    }
    void GetData(){
        Username = ed_Username.getText().toString().trim();
        Password = ed_Password.getText().toString().trim();
        Email = ed_Email.getText().toString().trim();
    }
}
