package com.lgy.test;

import com.example.testact.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends Activity implements CountDownCallback,View.OnClickListener {

    //ui countdown
    private Button btnStart,btnCancel,btnPause,btnResume;
    private LCountDownTimer mLCountDownTimer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(this);
        btnPause = (Button) findViewById(R.id.btn_pause);
        btnPause.setOnClickListener(this);
        btnResume = (Button) findViewById(R.id.btn_resume);
        btnResume.setOnClickListener(this);
        mLCountDownTimer = new LCountDownTimer(this);

		mLCountDownTimer.setTimer_couting(30);
		mLCountDownTimer.setCountDownInterval(1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
			try
			{
				mLCountDownTimer.startTimer();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
                break;
            case R.id.btn_cancel:
                mLCountDownTimer.cancelTimer();
                break;
            case R.id.btn_pause:
                mLCountDownTimer.pauseTimer();
                break;
            case R.id.btn_resume:
                mLCountDownTimer.resumeTimer();
                break;
        }
    }

    @Override
    public void start() {
        Log.i("lgy","start================");
    }

    @Override
    public void pause() {
        Log.i("lgy","pause================");
    }

    @Override
    public void resume() {
        Log.i("lgy","resume================");
    }

    @Override
    public void cancel() {
        Log.i("lgy","cancel================");
    }

    @Override
    public void countDowning(long count) {
//    	if (count!=0&&(((count/1000+2)%4)==0))
//		{
//            Log.i("lgy","count:"+count);
//		}
    	Log.i("lgy","count:"+count);
    }

	@Override
	public void end()
	{
        Log.i("lgy","end================");
	}
}