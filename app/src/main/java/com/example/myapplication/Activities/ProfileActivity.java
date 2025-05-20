package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.Objects.User;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        loadInfo();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void loadInfo(){
        TextView textViewLogin, textViewPassword, textViewName, textViewSurname, textViewAge;
        textViewLogin = findViewById(R.id.loginETprofile);
        textViewPassword = findViewById(R.id.passETprofile);
        textViewName = findViewById((R.id.nameETProfile));
        textViewSurname = findViewById((R.id.surnameETprofile));
        textViewAge = findViewById((R.id.ageETprofile));
        Bundle arguments = getIntent().getExtras();
        User user = (User) arguments.getSerializable(User.class.getSimpleName());
        textViewLogin.setText(user.getLogin());
        textViewPassword.setText(user.getPassword() + "\nName: " + user.getName());
        textViewName.setText(user.getName());
        textViewSurname.setText(user.getSurname());
        textViewAge.setText(String.valueOf(user.getAge()));

    }

    public void btnMain_click(View view) {
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }
}