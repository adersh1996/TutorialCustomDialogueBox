package com.adarsh.customdialogueboxtutorial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button customdialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customdialogue = findViewById(R.id.dialogue);
        customdialogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an alert builder
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Note");

                // set the custom layout
                View customlayout = getLayoutInflater().inflate(R.layout.customdialogue_layout, null);
                builder.setView(customlayout);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // send data from the
                        // AlertDialog to the Activity
                        EditText editText = customlayout.findViewById(R.id.editText);
                        sendDialogDataToActivity(editText.getText().toString());
                    }
                });
                // create and show
                // the alert dialog
                AlertDialog dialog
                        = builder.create();
                dialog.show();
            }
        });
    }

    // Do something with the data
    // coming from the AlertDialog
    private void sendDialogDataToActivity(String data) {
        Toast.makeText(this,
                data,
                Toast.LENGTH_SHORT)
                .show();
    }
}