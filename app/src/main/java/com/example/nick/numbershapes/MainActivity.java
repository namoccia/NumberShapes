package com.example.nick.numbershapes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number;

        public boolean isTriangular() {
            return number % 3 == 0;
        }

        public boolean isSquare() {
            double root = Math.sqrt((double) number);

            if (root == Math.floor(root)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void testNumber(View view) {
        Number myNumber = new Number();
        String message = "";

        EditText usersNumber = (EditText) findViewById(R.id.usersNumber);
        if (usersNumber.getText().toString().isEmpty()) {
            message = "Please enter a number!";
        } else {
            myNumber.number =Integer.parseInt(usersNumber.getText().toString());
            if (myNumber.isSquare()) {
                if (myNumber.isTriangular()) {
                    message = myNumber.number + " is both triangular and square";
                } else {
                    message = myNumber.number + " is square, but not triangular";
                }
            } else if (myNumber.isTriangular()) {
                if (myNumber.isSquare()) {
                    message = myNumber.number + " is both triangular and square";
                } else {
                    message = myNumber.number + " is triangular, but not square";
                }
            } else {
                message = myNumber.number + " is neither triangular nor square.";
            }
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
