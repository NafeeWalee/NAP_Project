package nap_international.group_project.WebView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import nap_international.group_project.R;

public class WebScreen extends AppCompatActivity {

    public String string;
    public WebView WV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_screen);
        //getting webAddress from VideoAdapter class in RecyclerScreen folder
        string = getIntent().getStringExtra("WEB_URL");
        WV = findViewById(R.id.webview);
        WV.loadUrl(string);
        WV.getSettings().setJavaScriptEnabled(true);
        WV.setWebViewClient(new myBrowser());
    }

    public class myBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }
}
