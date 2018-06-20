package lifecycle.com.activitylifecycle;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    protected EditText txtUserName;
    private EditText txtPassword;
    Button  loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Ravi","Main OnCreate");
        txtUserName=(EditText) findViewById(R.id.editText1);
        txtPassword=(EditText) findViewById(R.id.editText2);
        loginButton =  (Button)  findViewById(R.id.button);
        loginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Log.d("Ravi", "Login processing initiated");
        Intent intent = new Intent(this,LoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("userName",txtUserName.getText().toString());
        bundle.putString("password",txtPassword.getText().toString());
        intent.putExtras(bundle);
        startActivityForResult(intent,1);
        // IntentFilter
    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ravi","Main Start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Ravi","Main ReStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Ravi","Main Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Ravi","Main Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ravi","Main Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ravi","Main OnDestroy");
    }



    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("Ravi","Main PostResume");
    }



}