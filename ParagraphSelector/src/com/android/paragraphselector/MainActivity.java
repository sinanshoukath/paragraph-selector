package com.android.paragraphselector;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/*
 * Main class for Paragraph Selector
 * @author Sinan Shoukath
 */
public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final WebView webView = (WebView)findViewById(R.id.webview);
    final ProgressDialog dialog = ProgressDialog.show(this, "Paragraph Selector", "Loading data");
    webView.loadUrl("file:///android_asset/input_text.txt");
    webView.setWebViewClient(new WebViewClient() {
      @Override
      public void onPageFinished(WebView view, String url) {
        dialog.dismiss();
      }
    });
    Spinner spinner = (Spinner)findViewById(R.id.word_spinner);
    String[] array_spinner = {"fixed", "drive", "car", "surrounding", "little", "property", "para",
        "bus", "trust", "person"};
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, array_spinner);
    spinner.setAdapter(adapter);
  }
}
