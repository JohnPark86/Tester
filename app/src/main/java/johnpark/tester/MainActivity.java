package johnpark.tester;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    Button b,b2,b3,b4;
    TextView tv;
    SharedPreferences sPref;
    public static final String MyPREFERENCES = "config" ;
    static final int REQUEST_RESULT_CODE = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sPref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        int i = sPref.getInt("radio button",-1);
        setBackground(i);
        instantiateElements();
    }

    private void setBackground(int i) {
        if(i==2131492942){
            //blue: 2131492942
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#B3A3DC"));
        }
        if(i==2131492943){
            // red: 2131492943
            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#B38B8B"));
        }
    }


    private void instantiateElements() {
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Goodbye World");
            }
        });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Hello World");
            }
        });

        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNextActivity(v);
            }
        });

        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadListActivity(v);
            }
        });
        tv = (TextView) findViewById(R.id.textView);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void loadNextActivity(View v){
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }

    public void loadListActivity(View v){
        Intent i = new Intent(this, ListActivity.class);
        startActivity(i);
    }

}
