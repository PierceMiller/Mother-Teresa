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

public class Topic_Primary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary);

        //ImageView is defined and linked to view in layout
        ImageView topicsimage = (ImageView) findViewById(R.id.topicsimage);

        //topics imageview is linked to image resource in drawable folder
        int imageResource = getResources().getIdentifier("@drawable/primary", null, this.getPackageName());
        topicsimage.setImageResource(imageResource);

        //Textviews are defined and linked to specified view in layout
        //Textviews are populated with specified text
        TextView primaryheading = (TextView) findViewById(R.id.Heading);
        primaryheading.setText("Eight Ways to Prepare Your Child for Primary");

        TextView one = (TextView) findViewById(R.id.one_info);
        one.setText("1.Talk about What to Expect\n" + "Buy some books about what to expect at activity_kindergarten school. Spend some time together talking about what a day in activity_kindergarten school will be like. Encourage your child to share any concerns that they might have and address them together.");

        TextView two = (TextView) findViewById(R.id.two_info);
        two.setText("2.Attend the School Orientation Together\n" + "Most schools will hold an orientation session before the classes begin. Bring your child. The school tour is a great time to figure out what the class room will look like, the canteen, washrooms and bus pickup and drop off points. Prompt your child for any new questions which they might have after visiting the school. If your child will be attending your alma mater, then sharing some stories about your time at the school will help to make the experience more interesting and relatable. ");

        TextView three = (TextView) findViewById(R.id.three_info);
        three.setText("3.Buy School Supplies\n" + "Go shopping with your child and make sure that you get everything they need before the first day of school. Buy a good school bag, shoes, uniforms, books and stationery too. ");

        TextView four = (TextView) findViewById(R.id.four_info);
        four.setText("4.Recess Tips and Tricks\n" + "Recess is probably going to be the most confusing time for your child. The rush of students to the canteen, the choices they will need to make and the need to manage money all within the 30 to 45 minute time allowed for recess are usually quite stressful initially. Talk to your child about how to manage payments, deal with queues and make decisions about what to have for recess. To make it easier, you might want to pack a small sandwich or snack for your child for the first 2 weeks of school so that they will still have something to eat if they find it too difficult to manage at recess time. ");

        TextView five = (TextView) findViewById(R.id.five_info);
        five.setText("5.Talk about Making New Friends\n" + "Going to a new school often means saying goodbye to old friends and making new ones. Talk to your child about what they can do to make new friends. Re-assure them that they will still be able to see their pre-school friends. Set up some playdates with their pre-school classmates within the first 2 months of primary school so that your child can continue to maintain these friendships. ");

        TextView six = (TextView) findViewById(R.id.six_info);
        six.setText("6.Do a Transport Dry Run\n" + "Whether you will be walking to school together, taking public transport, or using the school bus, it is always a good idea to do a dry run together. Practice waking up in the morning and going to school. Then do it all in reverse for the ride back home. ");

        TextView seven = (TextView) findViewById(R.id.seven_info);
        seven.setText("7.Establish a Routine\n" + "Set up the routine which you will be keeping to during the school week. Get your child used to going to bed early and waking up earlier. Talk about when they should be doing their homework and if there will be any restrictions on TV time in the evenings. Try to start following this routine about 1 month before school begins. ");

        TextView eight = (TextView) findViewById(R.id.eight_info);
        eight.setText("8.Teach Your Child about Safety\n" + "Go through all the different situations which your child might encounter at school which are a threat to safety. Discuss what to do in the event that an adult or another child makes them feel uncomfortable, talk about fire safety procedures, the dangers of leaving the school grounds unattended and road safety issues as well.");
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

            AlertDialog alertDialog = new AlertDialog.Builder(Topic_Primary.this).create();
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
