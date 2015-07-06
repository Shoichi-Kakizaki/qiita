package fsail.jp.qiita;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;


public class WebViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView webView = (WebView)findViewById(R.id.webView1);
        Intent intent = getIntent();
        webView.loadUrl(intent.getStringExtra("uri"));
    }
}
