package mother_teresa.softwaredev;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Topics_Home extends AppCompatActivity {

    ViewPager viewPager;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics_home);

        ListView list = findViewById(R.id.thelist);

        final ArrayList<String> topics = new ArrayList<>();
        topics.add("Babies");
        topics.add("Kindergarten");
        topics.add("Primary School");
        topics.add("Intermediate");
        topics.add("Secondary");

        //defines ArrayAdapter adapter and sets adapater
        adapter = new ArrayAdapter(Topics_Home.this, R.layout.list_layout, topics);
        list.setAdapter(adapter);

        /*Depending on what item is clicked the user is redirected to the specified activity*/
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent start_baby = new Intent(Topics_Home.this, Topic_Babies.class);
                    startActivity(start_baby);
                } else if (position == 1) {
                    Intent start_kindy = new Intent(Topics_Home.this, Topic_Kindergarten.class);
                    startActivity(start_kindy);
                } else if (position == 2) {
                    Intent start_primary = new Intent(Topics_Home.this, Topic_Primary.class);
                    startActivity(start_primary);
                } else if (position == 3) {
                    Intent start_inter = new Intent(Topics_Home.this, Topic_Intermediate.class);
                    startActivity(start_inter);
                } else if (position == 4) {
                    Intent start_second = new Intent(Topics_Home.this, Topic_Secondary.class);
                    startActivity(start_second);
                }
            }
        });

        //Defines the BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);

        /*Once an item on the bottomNavigationView is clicked depending
         * on the item clicked directs the user to the corresponding activity*/
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.menu_Topic:
                        Toast.makeText(Topics_Home.this, "You're on the Home Screen!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menu_Quiz:
                        Intent quiz = new Intent(Topics_Home.this, QuizStart.class);
                        startActivity(quiz);
                        break;


                }
                return false;
            }
        });
    }

    //Creates option menu and inflates with items from about.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about, menu);
        return true;
    }

    //When option menu item is selected this method is called
    //conditional statements are checked and run
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_About) {

            AlertDialog alertDialog = new AlertDialog.Builder(Topics_Home.this).create();
            alertDialog.setTitle("Developers");
            alertDialog.setMessage("Pierce Miller\nBenjamin Gu\nKaihan Wang\nNick Winter\n");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();

        }
        return super.onOptionsItemSelected(item);
    }

}
