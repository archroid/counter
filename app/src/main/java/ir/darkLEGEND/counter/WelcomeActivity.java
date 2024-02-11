package ir.darkLEGEND.counter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton goToLogin;
    AppCompatButton goToRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        goToRegister = findViewById(R.id.btn_goToRegiser);
        goToLogin = findViewById(R.id.btn_goToLogin);
        goToLogin.setOnClickListener(this);
        goToRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == goToRegister.getId()){
            Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
        if (v.getId() == goToLogin.getId()){
            Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
