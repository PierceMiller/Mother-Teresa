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

import static android.content.DialogInterface.*;

public class Topic_Babies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_babies);

        //ImageView is defined and linked to view in layout
        ImageView topicsimage = (ImageView) findViewById(R.id.topicsimage);

        //topics imageview is linked to image resource in drawable folder
        int imageResource = getResources().getIdentifier("@drawable/babyimage", null, this.getPackageName());
        topicsimage.setImageResource(imageResource);

        //Textviews are defined and linked to specified view in layout
        //Textviews are populated with specified text
        TextView Baby_title_ = (TextView) findViewById(R.id.Baby_Title);
        Baby_title_.setText("Parenting Babies");

        TextView Feeding = (TextView) findViewById(R.id.Feeding);
        Feeding.setText("Dietary requirements");

        TextView four = (TextView) findViewById(R.id.Four_months);
        four.setText("Age 0 to 4 months:");

        TextView fourinfo = (TextView) findViewById(R.id.Four_info);
        fourinfo.setText("Breast milk \n" + "Formula\n");

        TextView six = (TextView) findViewById(R.id.six_months);
        six.setText("Age 4 to 6 months:");

        TextView sixinfo = (TextView) findViewById(R.id.six_info);
        sixinfo.setText("Breast milk or formula, PLUS\n" + "Pureed vegetables (sweet potatoes, squash)" + "\n" + "Pureed fruit (apples, bananas, peaches)\n" + "Pureed meat (chicken, pork, beef)" + "\n" + "Semi-liquid, iron-fortified cereal\n" + "Small amounts of unsweetened yogurt (no cow's milk until age 1)\n");

        TextView eight = (TextView) findViewById(R.id.eight_months);
        eight.setText("Age 6 to 8 months:");

        TextView eightinfo = (TextView) findViewById(R.id.eight_info);
        eightinfo.setText("Breast milk or formula, PLUS\n" + "Pureed or strained fruits (banana, pears, applesauce, peaches, avocado)" + "\n" + "Pureed or strained vegetables (well-cooked carrots, squash, sweet potato)" + "\n" + "Pureed meat (chicken, pork, beef)\n" + "Pureed tofu\n" + "Small amounts of unsweetened yogurt (no cow's milk until age 1)" + "\n" + "Pureed legumes (black beans, chickpeas, edamame, fava beans, black-eyed peas, lentils, kidney beans)\n" + "Iron-fortified cereal (oats, barley)\n");

        TextView ten = (TextView) findViewById(R.id.ten_months);
        ten.setText("Age 8 to 10 months:");

        TextView teninfo = (TextView) findViewById(R.id.ten_info);
        teninfo.setText("Breast milk or formula, PLUS\n" + "Small amounts of soft pasteurized cheese, cottage cheese, and unsweetened yogurt" + "\n" + "Mashed vegetables (cooked carrots, squash, potatoes, sweet potatoes)\n" + "Mashed fruits (bananas, peaches, pears, avocados)" + "\n" + "Finger foods (O-shaped cereal, small bits of scrambled eggs, well-cooked pieces of potato, well-cooked spiral pasta, teething crackers, small pieces of bagel)" + "\n" + "Protein (small bits of meat, poultry, boneless fish, tofu, and well-cooked beans, like lentils, split peas, pintos, or black beans)\n" + "Iron-fortified cereal (barley, wheat, oats, mixed cereals)\n");

        TextView twelve = (TextView) findViewById(R.id.twelve_months);
        twelve.setText("Age 10 to 12 months:");

        TextView twelveinfo = (TextView) findViewById(R.id.twelve_info);
        twelveinfo.setText("Breast milk or formula PLUS\n" + "Soft pasteurized cheese, yogurt, cottage cheese (no cow's milk until age 1)" + "\n" + "Fruit mashed or cut into cubes or strips\n" + "Bite-size, soft-cooked vegetables (peas, carrots)\n" + "Combo foods (macaroni and cheese, casseroles)" + "\n" + "Protein (small bits of meat, poultry, boneless fish, tofu, and well-cooked beans)\n" + "Finger foods (O-shaped cereal, small bits of scrambled eggs, well-cooked pieces of potato, well-cooked spiral pasta, teething crackers, small pieces of bagel)" + "\n" + "Iron-fortified cereals (barley, wheat, oats, mixed cereals)\n");

        TextView sleep = (TextView) findViewById(R.id.sleep);
        sleep.setText("Sleeping Requirements:");

        TextView sleepinfo = (TextView) findViewById(R.id.sleep_info);
        sleepinfo.setText("As a new parent, you may be surprised to learn that your newborn, who seems to need you every minute of the day, actually sleeps about 16 hours or more!" + "\n" + "Newborns typically sleep for periods of 2–4 hours. Don't expect yours to sleep through the night — the digestive system of babies is so small that they need nourishment every few hours and should be awakened if they haven't been fed for 4 hours (or more often if your doctor is concerned about weight gain)." + "\n" + "When can you expect your baby to sleep through the night? Many babies sleep through the night (between 6–8 hours) at 3 months of age, but if yours doesn't, it's not a cause for concern. Like adults, babies must develop their own sleep patterns and cycles, so if your newborn is gaining weight and appears healthy, don't despair if he or she hasn't slept through the night at 3 months." + "\n" + "It's important to always place babies on their backs to sleep to reduce the risk of SIDS (sudden infant death syndrome). Other safe sleeping practices include: not using blankets, quilts, sheepskins, stuffed animals, and pillows in the crib or bassinet (these can suffocate a baby); and sharing a bedroom (but not a bed) with the parents for the first 6 months to 1 year. Also be sure to alternate the position of your baby's head from night to night (first right, then left, and so on) to prevent the development of a flat spot on one side of the head." + "\n" + "Many newborns have their days and nights \"mixed up.\" They tend to be more awake and alert at night, and more sleepy during the day. One way to help them is to keep stimulation at night to a minimum. Keep the lights low, such as by using a nightlight. Reserve talking and playing with your baby for the daytime. When your baby wakes up during the day, try to keep him or her awake a little longer by talking and playing." + "\n" + "Even though you may feel anxious about handling a newborn, in a few short weeks you'll develop a routine and be parenting like a pro! If you have questions or concerns, ask your doctor to recommend resources that can help you and your baby grow together.\n");

        TextView bath = (TextView) findViewById(R.id.Bathing);
        bath.setText("Bathing Requirements:");

        TextView bathinfo = (TextView) findViewById(R.id.bathing_info);
        bathinfo.setText("You should give your baby a sponge bath until:\n" + "the umbilical cord falls off and the navel heals completely (1–4 weeks)\n" + "the circumcision heals (1–2 weeks)\n" + "A bath two or three times a week in the first year is fine. More frequent bathing may be drying to the skin." + "\n" + "Have these items ready before bathing your baby:" + "\n" + "a soft, clean washcloth\n" + "mild, unscented baby soap and shampoo\n" + "a soft brush to stimulate the baby's scalp\n" + "towels or blankets\n" + "a clean diaper\n" + "clean clothes\n");

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

            AlertDialog alertDialog = new AlertDialog.Builder(Topic_Babies.this).create();
            alertDialog.setTitle("Developers");
            alertDialog.setMessage("Pierce Miller\nBenjamin Gu\nKaihan Wang\nNick Winter\n");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();

        }
        return super.onOptionsItemSelected(item);
    }
}
