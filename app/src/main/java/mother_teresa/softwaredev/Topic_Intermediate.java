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

public class Topic_Intermediate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate);

        //ImageView is defined and linked to view in layout
        ImageView topicsimage = (ImageView) findViewById(R.id.topicsimage);

        //topics imageview is linked to image resource in drawable folder
        int imageResource = getResources().getIdentifier("@drawable/intermediate", null, this.getPackageName());
        topicsimage.setImageResource(imageResource);

        //Textviews are defined and linked to specified view in layout
        //Textviews are populated with specified text
        TextView interheading = (TextView) findViewById(R.id.Heading);
        interheading.setText("Preparing Your Child for Intermediate");

        TextView one = (TextView) findViewById(R.id.one_info);
        one.setText("1. Visit the new school. Help your child figure out the layout. Some schools are organized with each grade being in a different section of the school. Others are organized by department with the English department in corridor A and the math department in corridor B. Still others are organized by “teams” of teachers working together with a set group of students in a block of classrooms.Find out how the school is organized. Then see if you can get a tour with an older student or school personnel. Walk around until your child has a sense of where to find classes, the library, the gym, and the cafeteria. Remind him that it will look different when there are hundreds of kids crowding the halls.");

        TextView two = (TextView) findViewById(R.id.two_info);
        two.setText("2. See if your student can meet some of her teachers or the guidance counselor. Often staff are setting up classrooms in the weeks before school starts. Most are happy to take a couple of minutes to shake hands and say hello. Don’t overstay your welcome. These people have a lot to do. But just knowing what a few teachers look like can make your student feel more comfortable.");

        TextView three = (TextView) findViewById(R.id.three_info);
        three.setText("3. Clothes. Yes, clothes. For a middle schooler, the idea of going to school looking decidedly uncool is terrifying. Help your child think about how he wants to present himself that first day. That doesn’t mean that you need to spend a lot of money on new clothes. It does mean looking together at what your child has and what he needs to feel self-confident. Check out back to school sales. But also remember that “Sal’s Boutique” (the local Salvation Army store), thrift shops, and yard sales can be treasure troves of fashion.");

        TextView four = (TextView) findViewById(R.id.four_info);
        four.setText("4. Mornings. Ugh. Most middle schools start far earlier than elementary school. Two weeks before school starts, get everyone used to going to bed and getting up earlier. It’s a huge adjustment for some families. But a tired kid isn’t going to do well in school. Set up a healthy sleep routine from the start.");


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

            AlertDialog alertDialog = new AlertDialog.Builder(Topic_Intermediate.this).create();
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
