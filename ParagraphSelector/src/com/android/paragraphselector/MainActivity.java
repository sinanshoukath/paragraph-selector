package com.android.paragraphselector;

import java.lang.reflect.Method;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/*
 * Main class for Paragraph Selector
 * @author Sinan Shoukath
 */
public class MainActivity extends Activity {
  private WebView webView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    webView = (WebView)findViewById(R.id.webview);
    final ProgressDialog dialog = ProgressDialog.show(this, "Paragraph Selector", "Loading data");
    webView.loadUrl("file:///android_asset/input_text.txt");
    webView.setWebViewClient(new WebViewClient() {
      @Override
      public void onPageFinished(WebView view, String url) {
        dialog.dismiss();
      }
    });
    final Spinner spinner = (Spinner) findViewById(R.id.word_spinner);
    String[] array_spinner = {"fixed", "drive", "car", "surrounding", "little", "property", "para",
        "bus", "trust", "person"};
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.
         simple_spinner_item, array_spinner);
    spinner.setAdapter(adapter);
    Button searchButton = (Button)findViewById(R.id.search);
    searchButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        searchText(spinner.getSelectedItem().toString());
      }
    });
  }

  @SuppressWarnings("deprecation")
  private void searchText(String text) {
    webView.findAll(text);
    webView.setSelected(true);
    webView.findNext(true);
      try {
        for(Method m : WebView.class.getDeclaredMethods()) {
            if(m.getName().equals("setFindIsUp")) {
                m.setAccessible(true);
                m.invoke(webView, true);
            }
        }
      }catch(Exception ignored){}
  }
}
