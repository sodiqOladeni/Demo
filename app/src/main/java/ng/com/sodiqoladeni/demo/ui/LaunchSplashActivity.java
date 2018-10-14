package ng.com.sodiqoladeni.demo.ui;

import androidx.appcompat.app.AppCompatActivity;
import ng.com.sodiqoladeni.demo.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

public class LaunchSplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_splash_actitivity);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(LaunchSplashActivity.this);
                String userId = sharedPreferences.getString(getString(R.string.user_login_id), "");

                if (userId.isEmpty()) {
                    Intent activityIntent = new Intent(LaunchSplashActivity.this, LoginActivity.class);
                    startActivity(activityIntent);
                }else{
                    Intent intent = new Intent(LaunchSplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                // close this activity
                finish();
            }

        }, 3000);
    }
}
