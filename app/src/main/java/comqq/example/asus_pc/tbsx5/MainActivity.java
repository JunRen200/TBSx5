package comqq.example.asus_pc.tbsx5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    private EditText edt;
    private Button btn;
    private WebViewClient client = new WebViewClient() {
        // 防止加载网页时调起系统浏览器
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView= (WebView) findViewById(R.id.webview);
        edt= (EditText) findViewById(R.id.edt_text);
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=edt.getText().toString();
                if(!"".equals(str)){
                    mWebView.loadUrl(str);
                }
            }
        });
        mWebView.setWebViewClient(client);

    }
}
