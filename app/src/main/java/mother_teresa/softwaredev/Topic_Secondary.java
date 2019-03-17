package mother_teresa.softwaredev;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Topic_Secondary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        //ImageView is defined and linked to view in layout
        ImageView topicsimage = (ImageView) findViewById(R.id.topicsimage);

        //topics imageview is linked to image resource in drawable folder
        int imageResource = getResources().getIdentifier("@drawable/secondary", null, this.getPackageName());
        topicsimage.setImageResource(imageResource);

        //Textviews are defined and linked to specified view in layout
        //Textviews are populated with specified text
        TextView interheading = (TextView) findViewById(R.id.Heading);
        interheading.setText("Preparing Your Child for Secondary School");

        TextView one = (TextView) findViewById(R.id.one_info);
        one.setText("1. Be positive and enthusiastic. Your child is more likely to look forward to starting high school if you’re positive about it.");

        TextView two = (TextView) findViewById(R.id.two_info);
        two.setText("2. Attend orientation events. Most high schools offer an open day in the second semester where grade six students and their parents can attend, meet teachers and tour the facilities.");

        TextView three = (TextView) findViewById(R.id.three_info);
        three.setText("3. Find a school buddy for your child. This may be a neighbour’s child or an older playmate. Some high schools have their own ‘buddy system’, where older children at the school look out for new students.");

        TextView four = (TextView) findViewById(R.id.four_info);
        four.setText("4. Understand the school routine. Being familiar with timetables, scheduled breaks and start or finish times can help your child to know what to expect from their school day. ");

        TextView five = (TextView) findViewById(R.id.five_info);
        five.setText("5. Be prepared ahead of time. Involve your child in getting their books, uniform and travel pass organised well in advance of their start date, so they feel reassured and don’t have to worry.");

        TextView six = (TextView) findViewById(R.id.six_info);
        six.setText("6. Visit the school over the Christmas holidays, if possible. Stroll around the grounds to familiarise your child with the location of the toilets, office, lockers and sports facilities. ");

        TextView seven = (TextView) findViewById(R.id.seven_info);
        seven.setText("7. Figure out the travel route. Talk with your child about how they will get to and from school, and explore the route with them a few times before they start.");

        TextView eight = (TextView) findViewById(R.id.eight_info);
        eight.setText("8. Practise travelling to and from school. If they’re walking or catching public transport, go with your child or arrange someone else to accompany them until they are confident travelling on their own.");

        TextView nine = (TextView) findViewById(R.id.nine_info);
        nine.setText("9. Have an emergency safety plan. Be clear about who your child should contact and what you expect them to do in an emergency. Be calm and matter-of-fact about issues such as crossing major roads on their own or catching public transport if you are unable to arrange a lift for them.");

        TextView ten = (TextView) findViewById(R.id.ten_info);
        ten.setText("10. Encourage your child to talk about their feelings. They may be anxious about making the transition to high school or they may experience difficulties settling in once they start. Reassure them that it’s normal to have mixed feelings about starting a new school.");
    }

    //Creates option menu and populates with items from main_menu.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;

    }

    //Starts displays activity or dialog box based on item menu selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_Topic) {

            Intent startTopic1 = new Intent(this, Topics_Home.class);
            startActivity(startTopic1);

        }
        if (id == R.id.menu_Quiz) {

            Intent startquiz = new Intent(this, QuizStart.class);
            startActivity(startquiz);

        }
        if (id == R.id.menu_About) {

            AlertDialog alertDialog = new AlertDialog.Builder(Topic_Secondary.this).create();
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
