package com.example.counttest;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class CountDownActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    final TextView mTextField = (TextView)findViewById(R.id.count);
		
		 new CountDownTimer(Config.MILLIS_IN_FUTURE, Config.COUNT_DOWN_INTERVAL) {

			//millisUntilFinishedミリ秒毎にイベントを実行する
			public void onTick(long millisUntilFinished) {
				
				//残り時間の表示をhh:mm:ssに変換
				Date date = new Date(millisUntilFinished);
				SimpleDateFormat format = new SimpleDateFormat("KK:mm:ss");
				
				//textviewに残り時間を表示
				Log.e("date",""+date);
				Log.e("firmat",""+format.format(date));
		         mTextField .setText("クーポンチャレンジ！あと" + format.format(date));
		     }

			//カウントダウン終了時のイベント処理
		     public void onFinish() {
		         mTextField.setText("done!");
		     }
		  }.start();
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}