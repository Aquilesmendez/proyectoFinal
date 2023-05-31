package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.proyectofinal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.registrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = binding.nombreEditText.getText().toString().trim();
                String apellido = binding.apellidoEditText.getText().toString().trim();
                String email = binding.emailEditText.getText().toString().trim();
                String password = binding.passwordEditText.getText().toString().trim();

                if (!nombre.isEmpty() && !apellido.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    // Validar que el nombre solo contenga letras
                    if (nombre.matches("[a-zA-Z]+")) {
                        // Validar que el apellido solo contenga letras
                        if (apellido.matches("[a-zA-Z]+")) {
                            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                                if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[!@#$%^&*()].*")) {
                                    // Por ejemplo, mostrar un mensaje de éxito
                                    Toast.makeText(MainActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                                    // Abrir la actividad CompletadoActivity y pasar los datos
                                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                    intent.putExtra("nombre", nombre);
                                    intent.putExtra("apellido", apellido);
                                    intent.putExtra("email", email);
                                    intent.putExtra("password", password);
                                    startActivity(intent);
                                } else {
                                    // Si la contraseña no cumple con los requisitos, muestra un mensaje de error
                                    Toast.makeText(MainActivity.this, "La contraseña debe tener al menos 8 caracteres, una mayúscula y un símbolo", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                // Si el formato del email es incorrecto, muestra un mensaje de error
                                Toast.makeText(MainActivity.this, "El formato del correo electrónico es incorrecto", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // Si el apellido no contiene solo letras, muestra un mensaje de error
                            Toast.makeText(MainActivity.this, "El apellido solo debe contener letras", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Si el nombre no contiene solo letras, muestra un mensaje de error
                        Toast.makeText(MainActivity.this, "El nombre solo debe contener letras", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Si alguno de los campos está vacío, muestra un mensaje de error
                    Toast.makeText(MainActivity.this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
