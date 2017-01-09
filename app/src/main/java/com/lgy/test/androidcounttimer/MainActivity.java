package com.lgy.test.androidcounttimer;

import com.example.testact.R;
import com.lgy.test.LCountDownTimer;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener
{
	public static final int END = 0;
	public static final int START = 1;
	public static final int PASUSE = 2;
	public static final int RESUME = 3;
	private Button btnStart, btnCancel, btnPause, btnResume;
	private CountDownTimer countDownTimer = null;
	private int totalTime = 30;// 总时间
	private int countNum = 4;//间隔时间。每隔n秒会回调一次方法onTick
	private int min = 1000;// 1秒
	private int currentNum = -1;
	private static int timerStatus = END;// 当前状态

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("lgy", "==================onCreate");
		btnStart = (Button) findViewById(R.id.cbtn_start);
		btnStart.setOnClickListener(this);
		btnCancel = (Button) findViewById(R.id.cbtn_cancel);
		btnCancel.setOnClickListener(this);
		btnPause = (Button) findViewById(R.id.cbtn_pause);
		btnPause.setOnClickListener(this);
		btnResume = (Button) findViewById(R.id.cbtn_resume);
		btnResume.setOnClickListener(this);
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.i("lgy", "==================onDestroy");
	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.cbtn_start:
			initCount();

			if (countDownTimer != null)
			{
				countDownTimer.cancel();
				countDownTimer = null;
			}
			initCountDownTimer();
			countDownTimer.start();
			timerStatus = START;
			break;
		case R.id.cbtn_cancel:
			if (countDownTimer != null)
			{
				countDownTimer.cancel();
				countDownTimer = null;
			}
			timerStatus = END;
			break;
		case R.id.cbtn_pause:
			if (timerStatus == START || timerStatus == PASUSE)
			{
				countDownTimer.cancel();
				countDownTimer = null;
				timerStatus = PASUSE;
			}
			break;
		case R.id.cbtn_resume:

			if (timerStatus == PASUSE)
			{
				if (currentNum > 0)
				{
					initCountDownTimer();
				}
				countDownTimer.start();
				timerStatus = RESUME;
			}
			break;
		}
	}

	/**
	 * Administrator
	 * 2017-1-9
	 *TODO 初始化数据
	 */
	private void initCount()
	{
		totalTime = 30;// 总时间
		currentNum = totalTime;
		timerStatus = END;// 当前状态
	}
	/**
	 * Administrator
	 * 2017-1-9
	 *TODO 实例化CountDownTimer对象
	 */
	private void initCountDownTimer()
	{
		countDownTimer = new CountDownTimer(currentNum * min,
				countNum * min)
		{

			@Override
			public void onTick(long millisUntilFinished)
			{
				currentNum = (int) (millisUntilFinished / 1000);
				Log.i("lgy", "==================onTick:"
						+ millisUntilFinished / 1000);
			}

			@Override
			public void onFinish()
			{
				Log.i("lgy", "==================onFinish");
			}
		};
	}
}
