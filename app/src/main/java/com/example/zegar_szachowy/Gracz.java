package com.example.zegar_szachowy;

import android.os.BugreportManager;
import android.os.CountDownTimer;
import android.widget.Button;

public class Gracz {
    private int liczbaSekund;
    private boolean czyAktywny;
    private CountDownTimer countDownTimer;
    private Button button;

    public Gracz(boolean czyAktywny, Button button) {
        this.czyAktywny = czyAktywny;
        this.button = button;
        liczbaSekund = 180;
        if(czyAktywny){
            uruchomZegar();
        }
    }

    private void uruchomZegar(){
        countDownTimer = new CountDownTimer(liczbaSekund*1000,1000) {
            @Override
            public void onTick(long l) {
                liczbaSekund = (int)l/1000;
                button.setText(liczbaSekund+"");
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }
}
