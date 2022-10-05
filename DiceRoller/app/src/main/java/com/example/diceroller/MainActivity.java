package com.example.diceroller;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        Button rollButton = this.findViewById(R.id.button);
        rollButton.setOnClickListener(it -> MainActivity.this.rollDice());
        this.rollDice();
    }

    private void rollDice() {
        Dice dice = new Dice(6);
        int diceRoll = dice.roll();
        ImageView diceImage = this.findViewById(R.id.imageView);
        int drawableResource;
        switch(diceRoll) {
            case 1:
                drawableResource = R.drawable.dice_1;
                break;
            case 2:
                drawableResource = R.drawable.dice_2;
                break;
            case 3:
                drawableResource = R.drawable.dice_3;
                break;
            case 4:
                drawableResource = R.drawable.dice_4;
                break;
            case 5:
                drawableResource = R.drawable.dice_5;
                break;
            default:
                drawableResource = R.drawable.dice_6;
        }

        diceImage.setImageResource(drawableResource);
        diceImage.setContentDescription(String.valueOf(diceRoll));
    }
}
class Dice {
    private final int numSides;

    public int roll() {
        Random random = new Random();
        return random.nextInt(numSides);
    }

    public Dice(int numSides) {
        this.numSides = numSides;
    }
}