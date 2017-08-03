package com.example.frank.realmapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.frank.realmapp.Model.Usuario;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

public class IngresoUsuario extends AppCompatActivity {

    @BindView(R.id.edtNombre)EditText edtNombre;
    @BindView(R.id.edtApellido)EditText edtApellido;
    @BindView(R.id.edtEmail)EditText edtEmail;
    @BindView(R.id.edtPassword)EditText edtPassword;
    @BindView(R.id.btnGuardar)Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_usuario);
        ButterKnife.bind(this);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                Number newId = realm.where(Usuario.class).findAll().max("id");
                newId = newId==null ? 0 : newId;
                Integer pk = newId.intValue()+1;
                Usuario user = new Usuario();
                user.setId(pk);
                user.setNombre(edtNombre.getText().toString());
                user.setApellido(edtApellido.getText().toString());
                user.setEmail(edtEmail.getText().toString());
                user.setPassword(edtPassword.getText().toString());
                realm.copyToRealmOrUpdate(user);
                realm.commitTransaction();


            }
        });
    }
}
