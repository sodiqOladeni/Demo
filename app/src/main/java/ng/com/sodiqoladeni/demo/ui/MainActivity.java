package ng.com.sodiqoladeni.demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import androidx.appcompat.app.AppCompatActivity;
import ng.com.sodiqoladeni.demo.R;

public class MainActivity extends AppCompatActivity {

    private MaterialButton btnBackup, btnRestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBackup = findViewById(R.id.btn_backup);
        btnRestore = findViewById(R.id.btn_restore);

        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RestoreActivity.class));
            }
        });

        btnBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BackupActivity.class));
            }
        });
    }
}
