package com.android.paragraphselector;

import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/*
 * Main class for Paragraph Selector
 * @author Sinan Shoukath
 */
public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    TextView input_Text = (TextView) findViewById(R.id.input_text);
    InputStream input;
    try {
      input = getAssets().open("input_text.txt");
      int size = input.available();
      byte[] buffer = new byte[size];
      input.read(buffer);
      input.close();
      input_Text.setText(new String(buffer));
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    Spinner spinner = (Spinner) findViewById(R.id.word_spinner);
    String[] array_spinner = {"fixed", "drive", "car", "surrounding", "little", "property", "para",
        "bus", "trust", "person"};
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.
         simple_spinner_item, array_spinner);
    spinner.setAdapter(adapter);
  }
}
