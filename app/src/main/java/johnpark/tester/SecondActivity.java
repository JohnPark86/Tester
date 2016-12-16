package johnpark.tester;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;


public class SecondActivity extends ActionBarActivity {

    TextView t;
    Button b;
    ToggleButton tb;
    RatingBar rBar;
    CheckBox cb, cb2;
    RadioButton rb, rb2;
    EditText et,et2,et3;
    RadioGroup rg;
    SharedPreferences sPref;
    public static final String MyPREFERENCES = "config" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instantiateElements();

    }

    private void instantiateElements() {

        sPref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        t = (TextView) findViewById(R.id.textView2);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        et = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        cb = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        tb = (ToggleButton) findViewById(R.id.toggleButton);
        rBar = (RatingBar) findViewById(R.id.ratingBar);
        rb = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);

        tb.setChecked(sPref.getBoolean("toggle", false));
        cb.setChecked(sPref.getBoolean("checkbox1", false));
        cb2.setChecked(sPref.getBoolean("checkbox2", false));
        rBar.setRating(sPref.getFloat("rating", 0));

        int i = sPref.getInt("radio button",-1);
        if( i >= 0){
            rg.check(i);
        }

        b = (Button) findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInput();
            }
        });

    }

    private void getInput() {
        String input = et.getText().toString();
        String input2 = et2.getText().toString();
        String input3 = et3.getText().toString();

        int selectedRadioButtonId = rg.getCheckedRadioButtonId();
        boolean cbStatus = cb.isChecked();
        boolean cb2Status = cb2.isChecked();
        float rating = rBar.getRating();
        boolean tbStatus = tb.isChecked();

        SharedPreferences.Editor editor = sPref.edit();

        editor.putBoolean("toggle", tbStatus);
        editor.putBoolean("checkbox1", cbStatus);
        editor.putBoolean("checkbox2", cb2Status);
        editor.putFloat("rating", rating);
        editor.putInt("radio button", selectedRadioButtonId);
        editor.commit();

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
