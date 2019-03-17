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

public class Topic_Kindergarten extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kindergarten);

        //ImageView is defined and linked to view in layout
        ImageView topicsimage = (ImageView) findViewById(R.id.topicsimage);

        //topics imageview is linked to image resource in drawable folder
        int imageResource = getResources().getIdentifier("@drawable/kindy", null, this.getPackageName());
        topicsimage.setImageResource(imageResource);

        //Textviews are defined and linked to specified view in layout
        //Textviews are populated with specified text
        TextView Kindyheading = (TextView) findViewById(R.id.Heading);
        Kindyheading.setText("Eight Ways to Prepare Your Child for Kindergarten");

        TextView one = (TextView) findViewById(R.id.one_info);
        one.setText("1. Read Books Every Day. Without a doubt, this is the most important activity you can do to help your child develop language and reading skills. The 3 Rs of Reading are Repetition, Rhythm and Rhyme. Children enjoy books about their world and having books read over and over. Run your finger under words showing that reading is top to bottom and left to right. There are many interesting letter books to teach recognition and sounds. Visit your local library and perhaps your child can have his own card. Snuggle, bond, and cuddle while you share a love of reading.");

        TextView two = (TextView) findViewById(R.id.two_info);
        two.setText("2. Develop Fine Motor Skills and help your child Learn Letters the Sensory Way. It takes time, patience and practice to have a proper pencil grip. Model and praise often, offer large crayons and pencils, buy child safety scissors, and use playdough to develop muscles.");

        TextView three = (TextView) findViewById(R.id.three_info);
        three.setText("3. Print First Name with Only the First Letter Capitalized and Cure a Kinder Teacher’s Pet Peeve.");

        TextView four = (TextView) findViewById(R.id.four_info);
        four.setText("4. Follow 2 and 3-Step Instructions. “Please get your shoes and put them on.” Velcro is one of the greatest inventions ever. “Go to the bathroom, flush the toilet, and wash your hands, please.”");

        TextView five = (TextView) findViewById(R.id.five_info);
        five.setText("5. Manners: Model saying please and thank you and listening without interrupting. Talk to your child about raising their hand when they want to ask the teacher a question.");

        TextView six = (TextView) findViewById(R.id.six_info);
        six.setText("6. Social Skills: Playing with other children teaches children how to share, take turns, communicate, and problem-solve.");

        TextView seven = (TextView) findViewById(R.id.seven_info);
        seven.setText("7. Help Your Child Take Responsibility: Encourage them to clean up toys and messes, dress and use bathroom by themself, get own drink and healthy snacks, and take responsibility for their actions.");

        TextView eight = (TextView) findViewById(R.id.eight_info);
        eight.setText("8. Number Recognition and Concept: Help your child learn to count with concrete objects such as marbles, rocks, dolls, cars, beans, pasta. Play hopscotch then have your child place the correct number of items on each number.");

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

            AlertDialog alertDialog = new AlertDialog.Builder(Topic_Kindergarten.this).create();
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
