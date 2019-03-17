package mother_teresa.softwaredev;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuizDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MotherTeresa.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public QuizDBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
                QuizContract.QuestionsTable.QUIZ_TABLE + " ( " +
                QuizContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_CHOICE1 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_CHOICE2 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_CHOICE3 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_CORRECT_ANSWER + " INTEGER)";

        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTable.QUIZ_TABLE);
        onCreate(db);
    }

    public void fillQuestionsTable() {

        QuizQuestion q1 = new QuizQuestion("You need to help your children maintain a healthy balanced diet. Which of these foods is high calcium?", "Fish", "Peanuts", "Yogurt", 3);
        addQuestion(q1);

        QuizQuestion q2 = new QuizQuestion("When do children start learning speech patterns?", "Between 1-2 years old", "At three months", "In the womb", 3);
        addQuestion(q2);

        QuizQuestion q3 = new QuizQuestion("Which of these foods, high in potassium?", "Peas", "Whole Grain Bread", "Bananas", 3);
        addQuestion(q3);

        QuizQuestion q4 = new QuizQuestion("Babies move around and wiggle so much because...", "They're exploring", "They're uncomfortable", "Their muscles twitch and flex", 1);
        addQuestion(q4);

        QuizQuestion q5 = new QuizQuestion("What street do Grover, Elmo, Kermit and Big Bird live on?", "23rd", "Sesame", "Mr. Roger's", 2);
        addQuestion(q5);

        QuizQuestion q6 = new QuizQuestion("True or False: You should make a child vomit if you suspect he or she is suffering from poison.", "It depends what type of poison", "False", "True", 2);
        addQuestion(q6);

        QuizQuestion q7 = new QuizQuestion("Fill in the blank: 'Hush little baby don’t say a word, Papa’s gonna buy you a _________", "Mockingbird", "Firebird", "Horse", 1);
        addQuestion(q7);

        QuizQuestion q8 = new QuizQuestion("Which is generally considered better - breastfeeding or bottle feeding?", "Breastfeeding", "Bottle feeding", "Neither is considered", 1);
        addQuestion(q8);

        QuizQuestion q9 = new QuizQuestion("Most babies get their first tooth when they are how old?", "3 months", "6 months", "1 year", 2);
        addQuestion(q9);

        QuizQuestion q10 = new QuizQuestion("What should your baby's first solid food be?", "Seafood", "Soft cooked veges and fruit", "Whatever the parents eat", 2);
        addQuestion(q10);
    }

    public void addQuestion(QuizQuestion quizQuestion) {

        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION, quizQuestion.getQuestion());
        cv.put(QuizContract.QuestionsTable.COLUMN_CHOICE1, quizQuestion.getOption1());
        cv.put(QuizContract.QuestionsTable.COLUMN_CHOICE2, quizQuestion.getOption2());
        cv.put(QuizContract.QuestionsTable.COLUMN_CHOICE3, quizQuestion.getOption3());
        cv.put(QuizContract.QuestionsTable.COLUMN_CORRECT_ANSWER, quizQuestion.getAnswerNr());
        db.insert(QuizContract.QuestionsTable.QUIZ_TABLE, null, cv);
    }

    public List<QuizQuestion> getAllQuestions() {

        List<QuizQuestion> quizQuestionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.QUIZ_TABLE, null);

        if (c.moveToFirst()) {

            do {

                QuizQuestion quizQuestion = new QuizQuestion();
                quizQuestion.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                quizQuestion.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_CHOICE1)));
                quizQuestion.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_CHOICE2)));
                quizQuestion.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_CHOICE3)));
                quizQuestion.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_CORRECT_ANSWER)));
                quizQuestionList.add(quizQuestion);

            } while (c.moveToNext());
        }

        c.close();
        return quizQuestionList;
    }
}

