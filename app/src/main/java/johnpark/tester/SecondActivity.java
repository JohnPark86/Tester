package johnpark.tester;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;


public class SecondActivity extends ActionBarActivity {

    TextView t;
    Button b;
    ToggleButton tb;
    Spinner s;
    RatingBar rBar;
    CheckBox cb, cb2;
    RadioButton rb, rb2;
    EditText et,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instantiateElements();
    }

    private void instantiateElements() {
        b = (Button) findViewById(R.id.button4);
        t = (TextView) findViewById(R.id.textView2);
        et = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        cb = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        tb = (ToggleButton) findViewById(R.id.toggleButton);
        s = (Spinner) findViewById(R.id.spinner);
        rBar = (RatingBar) findViewById(R.id.ratingBar);
        rb = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInput();
            }

        });
    }

    private void getInput() {
        String input = et.getText().toString();
        Intent in = new Intent(this,MainActivity.class);
        in.putExtra("input", input);
        setResult(RESULT_OK, in);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
