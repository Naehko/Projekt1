package com.example.projekt1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projekt1.R;

public class MainActivity extends AppCompatActivity {

    private final String USERNAME = "Nikolas";
    private final String PASSWORD = "123";

    private EditText usernameInput;
    private EditText passwordInput;
    private Button enterButton;
    private int tries = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(view -> {
            finish();
        });


        // Find the EditText and Button elements by their IDs
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        enterButton = findViewById(R.id.enter_button);

        // Set onClickListener for the button
        enterButton.setOnClickListener(view -> {
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();
            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                usernameInput.setText("");
                passwordInput.setText("");
                tries = 0;
            } else {
                tries++;
                if (tries < 3) {
                    Toast.makeText(MainActivity.this, "Wrong username or password. " + (3 - tries) + " tries left.", Toast.LENGTH_SHORT).show();
                    usernameInput.setText("");
                    passwordInput.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Wrong username or password. You have no more tries.", Toast.LENGTH_SHORT).show();
                    usernameInput.setEnabled(false);
                    passwordInput.setEnabled(false);
                    enterButton.setEnabled(false);
                }
            }
        });
    }
}
