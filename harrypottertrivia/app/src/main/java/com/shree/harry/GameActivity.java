package com.shree.harry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private int questionCount = 1;
    private int correctAnswerCount;
    private String[] answers;

    private ViewGroup questionContainer;
    private ViewGroup resultContainer;
    private ImageView ivHeader;
    private TextView tvQuestion;
    private RadioGroup cgOptions;
    private TextView tvResult;
    private Button buttonPlayAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_page);
        questionContainer = findViewById(R.id.questions_container);
        resultContainer = findViewById(R.id.result_container);
        ivHeader = findViewById(R.id.iv_header);
        tvQuestion = findViewById(R.id.tv_question);
        cgOptions = findViewById(R.id.rg_options);
        tvResult = findViewById(R.id.tv_result);
        buttonPlayAgain = findViewById(R.id.button_play_again);
        answers = getResources().getStringArray(R.array.answers);
        showQuestions();
    }

    private void showQuestions() {
        cgOptions.clearCheck();
        switch (questionCount) {
            case 1:
                ivHeader.setImageResource(R.drawable.question1);
                tvQuestion.setText(R.string.question1);
                String[] optionsList1 = getResources().getStringArray(R.array.choices1);
                setOptionsText(optionsList1);
                break;

            case 2:
                ivHeader.setImageResource(R.drawable.question2);
                tvQuestion.setText(R.string.question2);
                String[] optionsList2 = getResources().getStringArray(R.array.choices2);
                setOptionsText(optionsList2);
                break;

            case 3:
                ivHeader.setImageResource(R.drawable.question3);
                tvQuestion.setText(R.string.question3);
                String[] optionsList3 = getResources().getStringArray(R.array.choices3);
                setOptionsText(optionsList3);
                break;

            case 4:
                ivHeader.setImageResource(R.drawable.question4);
                tvQuestion.setText(R.string.question4);
                String[] optionsList = getResources().getStringArray(R.array.choices4);
                setOptionsText(optionsList);
                break;

            case 5:
                ivHeader.setImageResource(R.drawable.question5);
                tvQuestion.setText(R.string.question5);
                String[] optionsList5 = getResources().getStringArray(R.array.choices5);
                setOptionsText(optionsList5);
                break;

        }
    }

    private void setOptionsText(String[] options) {
        for (int i = 0; i < cgOptions.getChildCount(); i++) {
            ((RadioButton) cgOptions.getChildAt(i)).setText(options[i]);
        }
    }


    public void next(View v) {
        isCorrectAnswser();
        questionCount++;
        if(questionCount == 6){
            questionContainer.setVisibility(View.GONE);
            resultContainer.setVisibility(View.VISIBLE);
            tvResult.setText(String.format(getResources().getString(R.string.result),correctAnswerCount));

        }else{
            showQuestions();
        }
    }

    public void playAgain(View v){
        questionCount = 1;
        correctAnswerCount = 0;
        resultContainer.setVisibility(View.GONE);
        questionContainer.setVisibility(View.VISIBLE);
        showQuestions();

    }

    private void isCorrectAnswser() {
        int checkedRadioButtonId = cgOptions.getCheckedRadioButtonId();
        RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);
        if (checkedRadioButton.getText().toString().contentEquals(answers[questionCount - 1])) {
            correctAnswerCount = correctAnswerCount + 1;
        }
    }

}
