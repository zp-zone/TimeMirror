package com.zp.quickaccess.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.zp.quickaccess.adapter.MainUIAdapter;
import com.zp.quickaccess.service.FloatViewService;
import com.zp.quickaccess.utils.LogUtil;
import com.zp.quickaccess.R;

public class MainActivity extends Activity implements OnItemClickListener {

	private static final String TAG = "MainActivity";
	private GridView gv;
	private MainUIAdapter adapter;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 设置没有标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 设置全屏，全屏比较丑，一般很少用
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);
		ActivityManager.getInstance().addActivity(this);

		intent = new Intent();
		
		gv = (GridView) findViewById(R.id.gv_main);
		adapter = new MainUIAdapter(this);
		gv.setAdapter(adapter);

		gv.setOnItemClickListener(this);
	}

	/**
	 * gridview条目被点击的响应事件
	 * 
	 * parent：gv view：被点击的条目对应的view position：被点击条目的位置 id：被点击条目的id
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch (position) {
		case 0: // 使用帮助界面
			intent.setClass(this, HelpActivity.class);
			startActivity(intent);
			LogUtil.i(TAG, "进入使用帮助界面");
			break;
		case 1: // 应用设置界面
			intent.setClass(this, SettingActivity.class);
			startActivity(intent);
			LogUtil.i(TAG, "进入应用设置界面");
			break;
		case 2: // 应用管理界面
			intent.setClass(this, AppManageActivity.class);
			startActivity(intent);
			LogUtil.i(TAG, "进入应用管理界面");
			break;
		case 3: // 应用信息查看界面
			intent.setClass(this, ViewAppStaticsActivity.class);
			startActivity(intent);
			LogUtil.i(TAG, "进入应用信息查看界面");
			break;
		}
	}
}
