package com.example.myapplication.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.Objects.User;
import com.example.myapplication.Objects.UserDatabase;
import com.google.android.material.snackbar.Snackbar;

public class RegActivity extends AppCompatActivity {
    EditText nameEditTextReg, surnameEditTextReg, ageEditTextReg, loginEditTextReg, passEditTextReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reg);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void buttonClickReg(View view) {
        nameEditTextReg = findViewById(R.id.nameEditText);
        surnameEditTextReg = findViewById(R.id.surnameEditText);
        ageEditTextReg = findViewById(R.id.ageEditText);
        loginEditTextReg = findViewById(R.id.loginEditText);
        passEditTextReg = findViewById(R.id.passEditText);
        UserDatabase userDatabase = new UserDatabase();

        if(editTextValidation(nameEditTextReg) || editTextValidation(surnameEditTextReg)
                || editTextValidation(ageEditTextReg) || editTextValidation(loginEditTextReg)
                || editTextValidation(passEditTextReg)){
            Snackbar.make(view,"Заполните все поля!",Snackbar.LENGTH_SHORT).show();
        }
        else{
            User user = new User(nameEditTextReg.getText().toString(),surnameEditTextReg.getText().toString(),loginEditTextReg.getText().toString(),Integer.valueOf(ageEditTextReg.getText().toString()),passEditTextReg.getText().toString());
            userDatabase.addUser(user);
            finish();

        }
    }

    public boolean editTextValidation(EditText editText){
        String text = editText.getText().toString().trim();
        return text.isEmpty();
    }
}