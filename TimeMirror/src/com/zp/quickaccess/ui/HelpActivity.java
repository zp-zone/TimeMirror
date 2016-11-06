package com.zp.quickaccess.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.zp.quickaccess.R;

/**
 *	使用帮助界面：指导用户如何使用本app 
 *
 */
public class HelpActivity extends Activity {
	
	private TextView tv_common_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_help);
		
		tv_common_title = (TextView) findViewById(R.id.tv_common_title);
		tv_common_title.setText(R.string.app_help_tv_title);
	}
}
