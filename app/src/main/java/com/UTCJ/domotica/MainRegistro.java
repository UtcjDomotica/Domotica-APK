package com.UTCJ.domotica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainRegistro extends AppCompatActivity {
    Button reg;
    private FirebaseAuth mAuth;
    EditText correo, contraseña, nombre, apellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);
        reg = (Button) findViewById(R.id.registro);
        correo = (EditText)findViewById(R.id.mail);
        contraseña = (EditText) findViewById(R.id.pass);
        nombre = (EditText) findViewById(R.id.nom);
        apellido = (EditText) findViewById(R.id.ape);



        mAuth = FirebaseAuth.getInstance();


        onStart();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = correo.getText().toString().trim();
                String pass = contraseña.getText().toString().trim();
                String name = nombre.getText().toString();
                String lastname = apellido.getText().toString();


                if (TextUtils.isEmpty(mail)){
                    Toast.makeText(MainRegistro.this, "Campos vacios", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(pass)){
                    Toast.makeText(MainRegistro.this, "Campos vacios", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(name)){
                    Toast.makeText(MainRegistro.this, "Campos vacios", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(lastname)){
                    Toast.makeText(MainRegistro.this, "Campos vacios", Toast.LENGTH_SHORT).show();
                }else{
                    createAccount(mail,pass,name,lastname);
                }
            }
        });
    }

    @Override

    public void onStart() {

        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);

    }

    private void updateUI(FirebaseUser user) {

        if (user == null) {
            Toast.makeText(this, "Completa el registro", Toast.LENGTH_SHORT).show();
        } else {
            Intent sig = new Intent(MainRegistro.this, MainLogin.class);
            startActivity(sig);
            finish();
        }
    }

    private void createAccount(String email, String password, final String nombre, final String apellido) {
        final FirebaseDatabase bd = FirebaseDatabase.getInstance();
        System.out.println("Registro exitoso");

        mAuth.createUserWithEmailAndPassword(email, password)

                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            user = FirebaseAuth.getInstance().getCurrentUser();
                            DatabaseReference reference = bd.getReference("users").child(user.getUid());
                            reference.child("name").setValue(nombre).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){

                                    }else{
                                        Toast.makeText(MainRegistro.this, "No se pudo completar el registro", Toast.LENGTH_SHORT).show();
                                        updateUI(null);
                                    }

                                }
                            });



                            reference.child("lastname").setValue(apellido).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){

                                    }else{
                                        Toast.makeText(MainRegistro.this, "No se pudo completar el registro", Toast.LENGTH_SHORT).show();
                                        updateUI(null);
                                    }

                                }
                            });



                            Toast.makeText(MainRegistro.this, "Registro exitoso",Toast.LENGTH_SHORT).show();
                            updateUI(user);
                        } else {
                            Toast.makeText(MainRegistro.this, "No se pudo completar el registro", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }



}
