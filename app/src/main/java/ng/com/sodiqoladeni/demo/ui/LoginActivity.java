package ng.com.sodiqoladeni.demo.ui;

import androidx.appcompat.app.AppCompatActivity;
import ng.com.sodiqoladeni.demo.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText etNumber, etPassword;
    private MaterialButton signInButton;
    private static final String NUMBER = "08155507746";
    private static final String PASSWORD = "1234567";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etNumber = findViewById(R.id.number);
        etPassword = findViewById(R.id.password);
        signInButton = findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {

        // Reset errors.
        etNumber.setError(null);
        etPassword.setError(null);

        // Store values at the time of the login attempt.
        String email = etNumber.getText().toString();
        String password = etPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password can't be empty");
            focusView = etPassword;
            cancel = true;
        }

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !password.equals(PASSWORD)) {
            etPassword.setError("Invalid Password");
            focusView = etPassword;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            etNumber.setError("Phone Number can't be empty");
            focusView = etNumber;
            cancel = true;
        }

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(email) && !email.equals(NUMBER)) {
            etNumber.setError("Invalid Phone Number");
            focusView = etNumber;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.

            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(getString(R.string.user_login_id), "logged-in");
            editor.apply();

            Intent i = new Intent(this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
    }
}
