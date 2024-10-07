/*package com.example.lifecycleapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {

    private int threadCounter = 0;
    private TextView counterTextView;
    private boolean isRunning = true;
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        counterTextView = findViewById(R.id.threadCounterText);
        Button btnFinishB = findViewById(R.id.btnFinishB);

        // Start background thread to increment counter by 5
        //startBackgroundThread();

        // Finish Activity B when button is clicked
        btnFinishB.setOnClickListener(v -> {
            isRunning = false; // Stop the background thread
            finish(); // Close Activity B
        });
    }

    private void startBackgroundThread() {
        // Background thread to increment the counter every 2 seconds
        new Thread(() -> {
            while (isRunning) {
                threadCounter += 5;
                handler.post(() -> counterTextView.setText(String.format("Thread Counter: %04d", threadCounter)));

                try {
                    Thread.sleep(2000); // Sleep for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRunning = false; // Stop the thread when the activity is destroyed
    }
}*/
package com.example.lifecycleapp;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        // Set the result to RESULT_OK when this activity finishes
        Button btnFinishB = findViewById(R.id.btnFinishB);
        btnFinishB.setOnClickListener(v -> {
            setResult(RESULT_OK);  // Set the result before finishing the activity
            finish();  // Close Activity B
        });
    }
}

