/*package com.example.lifecycleapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int onRestartCounter = 0;  // To count onRestart() calls
    private TextView counterTextView;  // To display the counter value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the TextView and Buttons
        counterTextView = findViewById(R.id.threadCounter);
        Button btnStartB = findViewById(R.id.btnStartActivityB);
        Button btnStartC = findViewById(R.id.btnStartActivityC);
        Button btnShowDialog = findViewById(R.id.btnShowDialog);
        Button btnCloseApp = findViewById(R.id.btnCloseApp);

        // Button to start Activity B
        btnStartB.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActivityB.class);
            startActivity(intent);
        });

        // Button to start Activity C
        btnStartC.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActivityC.class);
            startActivity(intent);
        });

        // Button to show the custom dialog
        btnShowDialog.setOnClickListener(v -> showDialog());

        // Button to close the app
        btnCloseApp.setOnClickListener(v -> finish());
    }

    // Method to show a custom dialog
    private void showDialog() {
        // Create an AlertDialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        // Inflate the custom dialog layout
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_dialog, null);
        builder.setView(dialogView);

        // Create and show the dialog
        AlertDialog alertDialog = builder.create();

        // Set the close button functionality inside the dialog
        Button btnCloseDialog = dialogView.findViewById(R.id.btnCloseDialog);
        btnCloseDialog.setOnClickListener(v -> alertDialog.dismiss());

        alertDialog.show();
    }

    // This method is called when Activity A is restarted (e.g., when returning from B or C)
    @Override
    protected void onRestart() {
        super.onRestart();
        onRestartCounter++;  // Increment the counter
        counterTextView.setText(String.format("Thread Counter: %04d", onRestartCounter));  // Update the UI
    }
}*/
package com.example.lifecycleapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int threadCounter = 0;  // To count thread-based increments
    private TextView counterTextView;  // To display the counter value

    // Request codes to differentiate between Activity B and C
    private static final int REQUEST_CODE_B = 1;
    private static final int REQUEST_CODE_C = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the TextView and Buttons
        counterTextView = findViewById(R.id.threadCounter);
        Button btnStartB = findViewById(R.id.btnStartActivityB);
        Button btnStartC = findViewById(R.id.btnStartActivityC);
        Button btnShowDialog = findViewById(R.id.btnShowDialog);
        Button btnCloseApp = findViewById(R.id.btnCloseApp);

        // Button to start Activity B with requestCode REQUEST_CODE_B
        btnStartB.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActivityB.class);
            startActivityForResult(intent, REQUEST_CODE_B);  // Starting Activity B for result
        });

        // Button to start Activity C with requestCode REQUEST_CODE_C
        btnStartC.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActivityC.class);
            startActivityForResult(intent, REQUEST_CODE_C);  // Starting Activity C for result
        });

        // Button to show the custom dialog
        btnShowDialog.setOnClickListener(v -> showDialog());

        // Button to close the app
        btnCloseApp.setOnClickListener(v -> finish());
    }

    // This method is called when an activity you launched exits and returns a result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check which request code we are responding to
        if (requestCode == REQUEST_CODE_B && resultCode == RESULT_OK) {
            // Update the thread counter when returning from Activity B
            threadCounter += 5;
        } else if (requestCode == REQUEST_CODE_C && resultCode == RESULT_OK) {
            // Update the thread counter when returning from Activity C
            threadCounter += 10;
        }
        // Update the counter on the screen
        counterTextView.setText(String.format("Thread Counter: %04d", threadCounter));
    }

    // Method to show a custom dialog
    private void showDialog() {
        // Create an AlertDialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        // Inflate the custom dialog layout
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_dialog, null);
        builder.setView(dialogView);

        // Create and show the dialog
        AlertDialog alertDialog = builder.create();

        // Set the close button functionality inside the dialog
        Button btnCloseDialog = dialogView.findViewById(R.id.btnCloseDialog);
        btnCloseDialog.setOnClickListener(v -> alertDialog.dismiss());

        alertDialog.show();
    }
}

