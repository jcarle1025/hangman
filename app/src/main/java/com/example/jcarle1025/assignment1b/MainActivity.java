package com.example.jcarle1025.assignment1b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String word = generateWord();
    private String str= getDashes(word);
    private int numGuesses = word.length()+5;
    private ArrayList<View> pressedButtons = new ArrayList<View>();
    EditText topText, guessNum;
    GridLayout allButtons;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topText = (EditText)findViewById(R.id.topText);
        topText.setText(str);
        guessNum = (EditText)findViewById(R.id.guessNumText);
        guessNum.setText("Word="+word+"\tGuesses Left: "+numGuesses);
        allButtons = (GridLayout) findViewById((R.id.gridLayout));
    }

    public void selectButton(View v){
        int buttonId = v.getId();
        switch (buttonId) {
            case R.id.aButton:
                display(v,'a');
                break;
            case R.id.bButton:
                display(v,'b');
                break;
            case R.id.cButton:
                display(v,'c');
                break;
            case R.id.dButton:
                display(v,'d');
                break;
            case R.id.eButton:
                display(v,'e');
                break;
            case R.id.fButton:
                display(v,'f');
                break;
            case R.id.gButton:
                display(v,'g');
                break;
            case R.id.hButton:
                display(v,'h');
                break;
            case R.id.iButton:
                display(v,'i');
                break;
            case R.id.jButton:
                display(v,'j');
                break;
            case R.id.kButton:
                display(v,'k');
                break;
            case R.id.lButton:
                display(v,'l');
                break;
            case R.id.mButton:
                display(v,'m');
                break;
            case R.id.nButton:
                display(v,'n');
                break;
            case R.id.oButton:
                display(v,'o');
                break;
            case R.id.pButton:
                display(v,'p');
                break;
            case R.id.qButton:
                display(v,'q');
                break;
            case R.id.rButton:
                display(v,'r');
                break;
            case R.id.sButton:
                display(v,'s');
                break;
            case R.id.tButton:
                display(v, 't');
                break;
            case R.id.uButton:
                display(v, 'u');
                break;
            case R.id.vButton:
                display(v, 'v');
                break;
            case R.id.wButton:
                display(v,'w');
                break;
            case R.id.xButton:
                display(v,'x');
                break;
            case R.id.yButton:
                display(v,'y');
                break;
            case R.id.zButton:
                display(v,'z');
                break;
            case R.id.resetButton:
                reset();
                break;
        };
    }

    private void reset(){
        this.word = generateWord();
        this.str = getDashes(word);
        this.numGuesses = word.length()+5;
        topText.setText(str);
        guessNum.setText("Word="+word+"\tGuesses Left: " + numGuesses);

        for(View v : pressedButtons){
            v.setEnabled(true);
        }
        pressedButtons.clear();
    }

    private void display(View v, char c){
        if(numGuesses < 1)
            topText.setText("YOU LOST. The word was "+word+". Hit RESET to play again.");

        else {
            str = guessWord(c);
            topText.setText(str);
        }
        greyOut(v);
        numGuesses--;
        if(numGuesses < 1)
            topText.setText("YOU LOST. The word was "+word+". Hit RESET to play again.");
        guessNum.setText("Word="+word+"\tGuesses Left: "+numGuesses);
    }

    private void greyOut(View v){
        pressedButtons.add(v);
        v.setEnabled(false);
    }

    private String generateWord(){
        String [] words = {"handler","against","horizon","chops","junkyard","amoeba","academy","roast",
                "countryside","children","strange","best","drumbeat","amnesiac","chant","amphibian","smuggler","fetish"};
        Random r = new Random();
        int index = r.nextInt(words.length);
        return words[index];
    }

    private String getDashes(String s){
        String d = "";
        for(int i=0;i<s.length(); i++){
            d+="-";
        }
        return d;
    }

    private String guessWord(char c){
        char [] guessChars = str.toCharArray();
        int a=0;
        while(true) {
            int i = word.indexOf(c,a);
            if(i==-1)
                break;
            guessChars[i]=c;
            a=i+1;
        }

        str = String.valueOf(guessChars);
        if(str.indexOf('-')<0)
            str = "YOU WON! You guessed '"+word+"'! Hit RESET to play again";
        return str;
    }
}