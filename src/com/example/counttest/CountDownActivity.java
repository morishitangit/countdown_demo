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

			//millisUntilFinished�~���b���ɃC�x���g�����s����
			public void onTick(long millisUntilFinished) {
				
				//�c�莞�Ԃ̕\����hh:mm:ss�ɕϊ�
				Date date = new Date(millisUntilFinished);
				SimpleDateFormat format = new SimpleDateFormat("KK:mm:ss");
				
				//textview�Ɏc�莞�Ԃ�\��
				Log.e("date",""+date);
				Log.e("firmat",""+format.format(date));
		         mTextField .setText("�N�[�|���`�������W�I����" + format.format(date));
		     }

			//�J�E���g�_�E���I�����̃C�x���g����
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