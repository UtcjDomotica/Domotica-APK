package com.UTCJ.domotica;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class MainLogin extends AppCompatActivity {
    Button log, reg;
    EditText correo, contra;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        mAuth = FirebaseAuth.getInstance();


        log = (Button) findViewById(R.id.login);
        reg = (Button) findViewById(R.id.reg);
        correo = (EditText)findViewById(R.id.mail);
        contra = (EditText)findViewById(R.id.pass);




        onStart();

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = correo.getText().toString().trim();
                String pass = contra.getText().toString().trim();
                if (TextUtils.isEmpty(mail)) {
                    Toast.makeText(MainLogin.this, "Campos vacios", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(MainLogin.this, "Campos vacios", Toast.LENGTH_SHORT).show();
                }
                signIn(mail, pass);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sig = new Intent(MainLogin.this, MainRegistro.class);
                startActivity(sig);
            }
        });
    }

    private void signIn(String email, String password) {
        // [START sign_in_with_email]


        System.out.println("Login exitoso");
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainLogin.this, "Correo o contraseña incorrectos",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END sign_in_with_email]
    }

    public void onStart() {

        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);

    }

    private void updateUI(FirebaseUser user) {





        if (user == null) {

        } else {



            Intent sig = new Intent(MainLogin.this, MainActivity.class);
            startActivity(sig);
            finish();




        }
    }


}
