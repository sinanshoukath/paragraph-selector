package com.android.paragraphselector;

import java.io.File;
import java.lang.reflect.Method;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

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
    final EditText searchBox = (EditText)findViewById(R.id.edittext);
    ImageButton searchButton = (ImageButton)findViewById(R.id.search);
    searchButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        searchText(searchBox.getText().toString(), webView, true, true);
      }
    });
    ImageButton upButton = (ImageButton)findViewById(R.id.search_up);
    upButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        searchText(searchBox.getText().toString(), webView, false, false);
      }
    });
    ImageButton downButton = (ImageButton)findViewById(R.id.search_down);
    downButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        searchText(searchBox.getText().toString(), webView, true, false);
      }
    });
    Button loadFile = (Button)findViewById(R.id.browse);
    loadFile.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        final int ACTIVITY_SELECT_TEXT = 1234;
        startActivityForResult(i, ACTIVITY_SELECT_TEXT);
      }
    });
  }

  @SuppressWarnings("deprecation")
  private void searchText(String text, WebView webView, boolean direction, boolean show) {
    int count = webView.findAll(text);
    webView.setSelected(true);
    webView.findNext(direction);
    try {
      for(Method m : WebView.class.getDeclaredMethods()) {
        if(m.getName().equals("setFindIsUp")) {
          m.setAccessible(true);
          m.invoke(webView, true);
        }
      }
    }catch (Exception ignored) {
    }
    if(show) {
      if(count==0) {
        showToast("Not found");
      } else {
        showToast(text + " found at " + String.valueOf(count) + " locations");
      }
    }
  }
  private void showToast(String message) {
	Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
      toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
      toast.show();
  }

  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch(requestCode) {
      case 1234:
      if(resultCode == RESULT_OK) {
        File file = new File(data.getData().getPath());
        String filenameArray[] = file.getName().split("\\.");
        String extension = filenameArray[filenameArray.length-1];
        if(extension.equals("txt")) {
          webView.loadUrl("file:///" + file.getAbsolutePath());
          final ProgressDialog dialog = ProgressDialog.show(this,
              "Paragraph Selector", "Loading data");
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {
                  dialog.dismiss();
                }
              });
            webView.invalidate();
        } else {
          showToast("Invalid input");
        }
      }
    }
  }
}
