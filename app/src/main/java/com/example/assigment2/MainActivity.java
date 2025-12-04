package com.example.assigment2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etFullName, etUsername, etEmail, etPassword, etRePassword;
    RadioGroup rgGender;
    Button btnRegister, btnFacebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etFullName = findViewById(R.id.etFullName);
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etRePassword = findViewById(R.id.etRePassword);
        rgGender = findViewById(R.id.rgGender);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> validateForm());
    }

    private void validateForm() {

        String name = etFullName.getText().toString();
        String username = etUsername.getText().toString();
        String email = etEmail.getText().toString();
        String pass = etPassword.getText().toString();
        String rePass = etRePassword.getText().toString();

        if (name.isEmpty()) {
            etFullName.setError("Required");
            return;
        }
        if (username.isEmpty()) {
            etUsername.setError("Required");
            return;
        }
        if (!email.contains("@")) {
            etEmail.setError("Invalid Email");
            return;
        }
        if (!pass.equals(rePass)) {
            etRePassword.setError("Passwords do not match");
            return;
        }

        Toast.makeText(this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
    }
}