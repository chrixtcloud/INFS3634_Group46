package com.example.group46;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.group46.QuizContainer.*;
import com.example.group46.ResultContainer.*;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Assessment.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = "DBHelper";

    //Reference to the database itself
    private SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Called when DB is first created
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "onCreate: Creating Database");
        this.db = db;

        //SQL query to create the Question table
        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NO + " INTEGER" +
                ")";

        //SQL query to create the Result table
        final String SQL_CREATE_RESULT_TABLE = "CREATE TABLE " +
                ResultTable.TABLE_NAME + " ( " +
                ResultTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ResultTable.COLUMN_RESULT + " INTEGER " + ")";

        //To execute the SQL queries above
        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        makeQuestions();

        db.execSQL(SQL_CREATE_RESULT_TABLE);
    }

    //Updates the table, if there are changes made to the existing table
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ResultTable.TABLE_NAME);
        onCreate(db);
    }


    private void makeQuestions(){
        Question q1 = new Question("If you only have one out of the four financial statements, which would you use to value a company"
                , "Balance Sheet"
                , "Income Statement"
                , "Changes in Equity"
                , "Cash Flow"
                , 4);
        insertQuestion(q1);

        Question q2 = new Question("For the following valuation methods, which one is a valid statement?"
                , "DCF - it is the best measure of market value"
                , "Comparables - it is easy to come up with a good set of comparables"
                , "Precedent Transctions"
                , "None of the above"
                , 3);
        insertQuestion(q2);

        Question q3 = new Question("Which of the primary valuation methods is likely to produce the highest value?"
                , "Comparables"
                , "Precedent Transaction"
                , "Liquidation Value"
                , "None of the above"
                , 2);
        insertQuestion(q3);

        Question q4= new Question("What is the appropriate rate of debt to use in DCF valuation?"
                , "Risk free rate plus risk adjustment with beta"
                , "Highest rate of debt in capital stock"
                , "Blended rate of debt/indicative cost of debt"
                , "None of the above"
                , 3);
        insertQuestion(q4);

        Question q5= new Question("What would you rather have, revenue synergies or cost synergies given the same amount and why?"
                , "Revenue synergies - revenue synergies are easier to achieve"
                , "Revenue synergies - sales is more important than profit"
                , "Cost synergies - cost synergies flow right into operating profit"
                , "None of the above"
                , 3);
        insertQuestion(q5);

        Question q6= new Question("Assuming an all stock transaction, if a company trades at 10x P/E and purchases a company at 5x P/E, how large of a premium could it pay before the transaction is at its breakeven?"
                , "200%"
                , "50%"
                , "100%"
                , "75%"
                , 3);
        insertQuestion(q6);

        Question q7 = new Question("How does share based compensation (SBC) affect financial statements?"
                , "Cash Flow - does not affect cash flow"
                , "Income Statement - SBC + SBC*tax"
                , "Balance Sheet - Accounts Payables goes up Shareholders Equity goes up"
                , "None of the above"
                , 2);
        insertQuestion(q7);

        Question q8 = new Question("How do you treat minority interest in the EV calculation?"
                , "You add it to EV"
                , "It does not go into EV"
                , "You minus it from EV"
                , "None of the above"
                , 1);
        insertQuestion(q8);

        Question q9 = new Question("What happens to EV if we raise $100 million in debt? (and hold $100 cash on the balance sheet)"
                , "Decrease by $100 million"
                , "Increase by $100 million"
                , "No change"
                , "Increase by $100 million * (1-t)"
                , 3);
        insertQuestion(q9);

        Question q10 = new Question("Who would pay more for a company, all things equal – a financial buyer or a strategic buyer?"
                , "Financial buyer - need to pay more to convince shareholders to sell"
                , "Strategic buyer - pays a higher premium due to a lack of experience"
                , "Financial buyer - target value companies that requires a higher premium"
                , "Strategic buyer - synergies will add value"
                , 4);
        insertQuestion(q10);


    }

    //Adds the questions into database
    private void insertQuestion(Question question){
        Log.d(TAG, "Inserting the questions");
        ContentValues content = new ContentValues();

        //To set which values belongs to which column
        content.put(QuestionTable.COLUMN_QUESTION, question.getQuestion());
        content.put(QuestionTable.COLUMN_OPTION1, question.getOption1());
        content.put(QuestionTable.COLUMN_OPTION2, question.getOption2());
        content.put(QuestionTable.COLUMN_OPTION3, question.getOption3());
        content.put(QuestionTable.COLUMN_OPTION4, question.getOption4());
        content.put(QuestionTable.COLUMN_ANSWER_NO, question.getAnswerNo());

        //Insert the corresponding values into the table
        db.insert(QuestionTable.TABLE_NAME, null, content);
    }

    //To retrieve the all the questions
    public List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<>();
        Log.d(TAG, "Retrieving the questions");

        //Open the database for reading
        db = getReadableDatabase();

        //Querying the database to return all the values inside our Question table
        Cursor cursor = db.rawQuery("SELECT * FROM " + QuestionTable.TABLE_NAME, null);

        //Perform action if there is an entry on the first line
        if (cursor.moveToFirst()){
            do {
                //Setting the values
                Question question = new Question();
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNo(cursor.getInt(cursor.getColumnIndex(QuestionTable.COLUMN_ANSWER_NO)));

                //Adding these values to the Question list
                questionList.add(question);
            } while(cursor.moveToNext()); //move to the next entry if there is an entry that exists on the first line
        }
       //cursor.close();
        return questionList;
    }

}
