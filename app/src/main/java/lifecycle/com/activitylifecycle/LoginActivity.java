package lifecycle.com.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {


    private TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtView = (TextView) findViewById(R.id.testview);
        Log.d("Ravi","Login OnCreate");
        Bundle bundle = getIntent().getExtras();
        txtView.setText(bundle.getString("userName")+":"+bundle.getString("password"));
        //Intent  intent = new Intent(this,MainActivity.class);
        Intent intent = new Intent();
        intent.putExtra("result","Success");
        setResult(1,intent);
        // finish();
    }
    protected void onStart() {
        super.onStart();
        Log.d("Ravi","login activity Start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Ravi","login activity  ReStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Ravi","login activity Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Ravi","login activity  Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Ravi","login activity Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Ravi","login activity  OnDestroy");
    }



    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("Ravi","login activity  PostResume");
    }


}
