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
    public void odwrocAktywnosc(){
        czyAktywny = !czyAktywny;
        if(czyAktywny){
            uruchomZegar();
        }
        else{
            zatrzymajZegar();
        }
    }

    private void uruchomZegar(){
        countDownTimer = new CountDownTimer(liczbaSekund*1000,1000) {
            @Override
            public void onTick(long l) {
                liczbaSekund = (int)l/1000;
                int minuty = (liczbaSekund/60)%60;
                button.setText((minuty)+":"+String.format("%02d",liczbaSekund%60));
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }
    private void zatrzymajZegar(){
        countDownTimer.cancel();
    }
}
