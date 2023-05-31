package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.proyectofinal.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView nameTextView = binding.nameTextView;
        TextView lastNameTextView = binding.lastNameTextView;
        TextView emailTextView = binding.emailEditText;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nombre = extras.getString("nombre");
            String apellido = extras.getString("apellido");
            String email = extras.getString("email");

            // Mostrar los datos en los TextView correspondientes
            nameTextView.setText("Nombre: " + nombre);
            lastNameTextView.setText("Apellido: " + apellido);
            emailTextView.setText("Correo: " + email);
        }
    }
}
