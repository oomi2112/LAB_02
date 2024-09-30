package com.example.lab_02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Assuming you are using the "RelativeLayout" version

        // Reference UI elements from the layout
        Button button = findViewById(R.id.button);
        CheckBox checkBox = findViewById(R.id.checkbox);
        ImageButton imageButton = findViewById(R.id.image_button);
        Switch switchBtn = findViewById(R.id.switch_btn);



        // Button: Show a Toast message when clicked
        button.setOnClickListener(v -> {
            String message = getString(R.string.toast_message); // A string defined in strings.xml
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        });

        // Switch: Show a Snackbar when toggled
        switchBtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Set the switch state message directly without string resources
            String switchState = isChecked ? "on" : "off"; // Using hardcoded "on" and "off" strings

            // Create and show the Snackbar
            Snackbar.make(buttonView, "Switch is now " + switchState, Snackbar.LENGTH_LONG)
                    .setAction("Undo", v -> {
                        // Undo action: reverse the checked state of the Switch
                        switchBtn.setChecked(!isChecked);
                    })
                    .show();
        });


        // ImageButton: Respond to clicks (for demonstration purposes)
        imageButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, getString(R.string.flag_description), Toast.LENGTH_SHORT).show();
        });

        // Checkbox: Show a simple Toast message when clicked
        checkBox.setOnClickListener(v -> {
            boolean checked = checkBox.isChecked();
            String checkMessage = checked ? "Checkbox is checked!" : "Checkbox is unchecked!";
            Toast.makeText(MainActivity.this, checkMessage, Toast.LENGTH_SHORT).show();
        });
    }
}