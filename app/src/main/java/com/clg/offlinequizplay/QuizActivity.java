package com.clg.offlinequizplay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView questions;
    private TextView question;
    private AppCompatButton option1, option2, option3, option4;
    private AppCompatButton nextBtn;
    private Timer quizTimer;
    private  int totalTimeInMins = 1;
    private  int seconds = 0;
    private final List<QuestionsList> questionsLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

    final ImageView back_btn = findViewById(R.id.back_btn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedTopicName = findViewById(R.id.topicName);

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        nextBtn =findViewById(R.id.nextBtn);


        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");

        selectedTopicName.setText(getSelectedTopicName);

        startTimer(timer);
        option1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {

                                       }
                                   });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();

            }
        });
    }

    private void startTimer(TextView timerTextView){

        quizTimer = new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
  if( seconds == 0){
      totalTimeInMins--;
      seconds = 59;

  } else if (seconds == 0 && totalTimeInMins == 0) {
      quizTimer.purge();
      quizTimer.cancel();

      Toast.makeText(QuizActivity.this, "Time over", Toast.LENGTH_SHORT).show();
      Intent intent = new Intent( QuizActivity.this, QuizResults.class);
      intent.putExtra("correct", getCorrectAnswers());
      intent.putExtra("incorrect", getInCorrectAnswers());
      startActivity(intent);

      finish();

  }
  else {
      seconds--;
  }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                         String finalMinutes = String.valueOf(totalTimeInMins);
                         String finalSeconds = String.valueOf(seconds);
                    if (finalMinutes.length() ==1){
                        finalSeconds = "0"+finalMinutes;

                    }
                    if (finalSeconds.length() ==1){
                        finalSeconds = "0"+finalSeconds;

                    }
                    timerTextView.setText(finalMinutes +":"+finalSeconds);

                    }
                });
            }

        }, 1000, 1000);
    }

    private int getCorrectAnswers(){

     int correctAnswer = 0;
             for(int i=0;i<questionsLists.size();i++){

                 final String getUserSelectedanswer = questionsLists.get(i).getUserSelectedAnswer();
                 final String getAnswer = questionsLists.get(i).getAnswer();

                 if (getUserSelectedanswer.equals(getAnswer)){
                     correctAnswer++;
                 }

             }
             return correctAnswer;
    }
    private int getInCorrectAnswers(){

        int correctAnswer = 0;
        for(int i=0;i<questionsLists.size();i++){

            final String getUserSelectedanswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if (getUserSelectedanswer.equals(getAnswer)){
                correctAnswer++;
            }

        }
        return correctAnswer;

   }

    @Override
    public void onBackPressed() {
        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this, MainActivity.class));
        finish();

    }
}