package com.zp.quickaccess.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.zp.quickaccess.service.FloatViewService;
import com.zp.quickaccess.service.WatchdogService;
import com.zp.quickaccess.ui.AppContext;
import com.zp.quickaccess.utils.LogUtil;

/**
 * 
 * @file UnlockScreenReceiver.java
 * @package com.zp.quickaccess.receiver 
 * @comment 监听屏幕点亮事件，并在监听到屏幕亮起之后，判断服务和浮窗是否被优化
 * 			如果被优化则开启
 * 
 * @author zp
 * @date 2015-12-24 下午4:08:01
 */
public class UnlockScreenReceiver extends BroadcastReceiver {

	private static final String TAG = "UnlockScreenReceiver";
	private Context context;

	/**
	 * 接收到广播，然后直接开启应用统计服务
	 * 而浮窗服务是根据用户设置来选择开启的
	 * 
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		this.context = context;
		// 如果解锁的时候发现数据库还没有数据isFirst为true,那么先暂时不开启服务
		if(AppContext.getSharedPreferences().getBoolean("isFirst", true)){
			LogUtil.i(TAG, "解锁屏幕，数据库为空，未开启WatchdogService");
		}else{
			// 如果解锁事件发生的时候数据库已经有数据，那么开启服务
			startWatchdogService();
			LogUtil.i(TAG, "解锁屏幕，开启WatchdogService");
		}
	}
	
	/**
	 * 
	 * @comment 开启应用进程使用情况统计服务
	 * @param    
	 * @return void  
	 * @throws
	 * @date 2015-12-24 下午5:26:16
	 */
	public void startWatchdogService(){
		Intent mWatchdogService = new Intent(this.context, WatchdogService.class);
		this.context.startService(mWatchdogService);
		LogUtil.i(TAG, "startWatchdogService in UnlockScreenReceiver");
	}
	/**
	 * 
	 * @comment 开启悬浮窗检查服务;由于后来将WatchdogService作为FloatViewService的守护进程
	 * 			(仅仅当用户设置窗体显示，但是实际窗体没有显式--服务被关闭 的情形下WatchdogService才回去开启FloatViewService)
	 * 			所以基本不需要再解锁的时候开启
	 * @param    
	 * @return void  
	 * @throws
	 * @date 2015-12-24 下午5:26:03
	 */
	public void startFloatViewService(){
		Intent intent = new Intent(this.context, FloatViewService.class);
		// 此处由于重写了onStartCommand方法，而该方法使用到了Extra中的数据
		// 所以在开启时需要指定开启的动作是什么
		// 如果不指定将会导致空指针异常
		// intent.putExtra(FloatViewService.OPERATION,	FloatViewService.SHOW_FLOATWINDOW);
		this.context.startService(intent);
		LogUtil.i(TAG, "startFloatViewService in UnlockScreenReceiver");
	}
}
