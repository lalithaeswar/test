package sampleproject.com.retrofitexample.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sampleproject.com.retrofitexample.R;
import sampleproject.com.retrofitexample.config.Constant;
import sampleproject.com.retrofitexample.interfaces.ApiService;
import sampleproject.com.retrofitexample.interfaces.RequestCallback;
import sampleproject.com.retrofitexample.interfaces.RequestListener;
import sampleproject.com.retrofitexample.model.JsonResp;
import sampleproject.com.retrofitexample.util.ApiClient;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements RequestListener,View.OnClickListener {



    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private   Button mEmailSignInButton;
    ApiService apiService;
    @Inject
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        initEvents();

    }
    private void initViews()
    {
        mEmailView =  findViewById(R.id.email);
        mPasswordView =  findViewById(R.id.password);
        mEmailSignInButton =  findViewById(R.id.email_sign_in_button);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }
    private void initEvents()
    {
        mEmailSignInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case    R.id.email_sign_in_button:
                attemptLogin();
                break;
        }
    }
    public void testLoginAPI(String email,String password) {
        //For test should be success for new User and for existing user the log will be shown in message
        //Query Parameters
        Map<String, String> query = new HashMap<>();
        query.put("username", "+919629745812");
        query.put("password", "mani@123");
        query.put("grant_type", "password");
        showLog("loginactivity"+query) ;
        //Creating an object of our api interface
        ApiService apiService =
                ApiClient.getClient().create(ApiService.class);
        apiService.login(query).enqueue(new RequestCallback(this));
}
    public void onSuccess(final JsonResp jsonResp) {
        switch(jsonResp.getRequestCode()) {

            case Constant.REQUEST_LOGIN: createToast("successfully login"+"\n"+"RequestCode"+jsonResp.getRequestCode());
            break;
        }
    }
    @Override
    public void onFailure(JsonResp jsonResp) {
        createToast("request failure");
    }


    private void attemptLogin() {


        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
          //  showProgress(true);
            testLoginAPI(email,password);
//            mAuthTask = new UserLoginTask(email, password);
//            mAuthTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
    private void createToast(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
    private void showLog(String pMessage) {
        Log.e("loginactivitry", pMessage);
    }
}
