 package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.Objects.User;
import com.example.myapplication.Objects.UserDatabase;
import com.google.android.material.snackbar.Snackbar;
 public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void btnClickAuth(View view) {
        EditText loginEditText =                                                                         findViewById(R.id.loginEditText);
        EditText passEditText = findViewById(R.id.passEditText);
        TextView titleTextView = findViewById(R.id.titleTextView);
        UserDatabase userDatabase = new UserDatabase();

        User user = userDatabase.findUser(loginEditText.getText().toString());
        if(user != null){
            if(loginEditText.getText().toString().equals(user.getLogin()) &&
                    passEditText.getText().toString().equals(user.getPassword())){
                Toast toast = Toast.makeText(this,"Okay",Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(this, ProfileActivity.class);
                intent.putExtra(User.class.getSimpleName(),user);
                startActivity(intent);
            }
            else{
                Snackbar snackbar = Snackbar.make(view,"ERROR",Snackbar.LENGTH_SHORT);
                snackbar.setAction("Забыли пароль?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("test");
                    }
                });
                snackbar.show();
            }
        }
        else{
            Snackbar.make(view,"Пользователь не найден!",Toast.LENGTH_SHORT).show();
        }
    }
     public void btnClickReg(View view) {
        Intent intent = new Intent(this, RegActivity.class);
        startActivity(intent);
     }
 }