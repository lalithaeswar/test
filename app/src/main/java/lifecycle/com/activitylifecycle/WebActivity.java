package lifecycle.com.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView mywebview = (WebView) findViewById(R.id.webview);
        mywebview.loadUrl("https://www.javatpoint.com/android-webview-example/");
    }

}
