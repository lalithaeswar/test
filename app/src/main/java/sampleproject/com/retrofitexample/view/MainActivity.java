package sampleproject.com.retrofitexample.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import sampleproject.com.retrofitexample.R;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
 private   Button btn_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();
    }
    private void initViews()
    {
        btn_click=findViewById(R.id.btn_click);
    }
    private void initEvents()
    {
        btn_click.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_click)
        {
            callActivityIntent(CountryActivtiy.class);
        }
    }
    private void callActivityIntent( Class openActivity)
    {
        Intent intent= new Intent(this,openActivity);
        startActivity(intent);

    }
}
