package wovilon.toast;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import static wovilon.toast.R.color.labelColor;
class Task extends TimerTask {

    @Override
    public void run() {MainActivity.toast.show();

        }
}

public class MainActivity extends AppCompatActivity {
    static Toast toast;
    private SoundPool mSoundPool;
    private AssetManager mAssetManager;
    private int mZvon, mStreamID;
    static boolean BtPressed=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getActionBar();
       // bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(labelColor)));
        this.toast=Toast.makeText(getApplicationContext(),"Нужен тост!",Toast.LENGTH_SHORT);
        this.toast.setGravity(Gravity.CENTER,0,0);
        Timer timer=new Timer();
        long delay=(long)Math.random()*2000+6000;
        timer.schedule(new Task(), delay);



    }


    public void onBtToastClick(View view) {
        MediaPlayer media = new MediaPlayer();
        media = MediaPlayer.create(this, R.raw.zvon);
        media.start();
        //Intent iToastActivity=new Intent(MainActivity.this, ToastActivity.class);
       // startActivity(iToastActivity);
        this.BtPressed=true;
        new Task();
        String[] text=new String[10];
        text[0]="За сбычу мечт!";
        text[1]="Выпьем за тех, кто на борту. Кто за бортом, сам напьется!";
        text[2]="Девушка шла по улице и услышала за собой шаги. Оглянувшись, она увидела красивого парня. Оглянулась еще раз — он продолжал идти за ней. Решила с ним познакомиться, оглянулась в третий раз - его уже не было... Так выпьем за то, чтобы в городе вовремя закрывали канализационные люки! anekdotov.net";
        text[3]="Говорят, что у женщин не бывает правил, а лишь только настроение. Я хочу поднять этот бокал за нашу именинницу, чтобы ее правилом было всегда иметь хорошее настроение!";
        text[4]="Раньше на Руси был такой обычай: если девушка дожидалась парня из армии, то отливали пушку, если нет - сажали дерево. Так выпьем же за наши дремучие леса и за единственную пока Царь-пушку!";
        text[5]="Так выпьем за то, чтобы все нам было параллельно и только земля - перпендикулярно!";
        text[6]="Грузинский тост: \n" +
                "Желаю тебе, дорогой, чтоб ты жил до 147 лет. и чтобы в 147 лет ты умер. \n" +
                "И не просто умер, а тебя зарезали. И не просто зарезали, а из ревности. \n" +
                "И не просто из ревности, а за дело!";
        text[7]="Так выпьем же за то, чтобы желания женщины всегда совпадали с возможностями ее мужчины...";
        text[8]="Давайте выпьем за то, что несмотря ни на что, мы пьем во что бы то ни стало!";
        text[9]="Давайте выпьем за ЛОСЯ! Чтоб хотеЛОСЯ, могЛОСЯ, богатеЛОСЯ, еЛОСЯ, - за лося!";

        int n=(int)(Math.random()*10);
        TextView ToastText=(TextView)findViewById(R.id.textView3);
        ToastText.setText(text[n]);



    }
}
