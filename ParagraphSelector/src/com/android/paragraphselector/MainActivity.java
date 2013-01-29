package com.android.paragraphselector;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
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
    Spinner spinner = (Spinner) findViewById(R.id.word_spinner);
    String[] array_spinner = {"fixed", "drive", "car", "surrounding", "little", "property", "para",
        "bus", "trust", "person"};
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.
         simple_spinner_item, array_spinner);
    spinner.setAdapter(adapter);
  }
}
