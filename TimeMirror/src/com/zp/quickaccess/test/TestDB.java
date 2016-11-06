package com.zp.quickaccess.test;

import android.test.AndroidTestCase;

import com.zp.quickaccess.db.DBManager;
import com.zp.quickaccess.domain.AppUseStatics;
import com.zp.quickaccess.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class TestDB extends AndroidTestCase {
	private static final String TAG = "TEST";

	public void TestAdd() {
		AppUseStatics appUseStatics = new AppUseStatics();

		appUseStatics.setPkgName("testPkgName");
		appUseStatics.setName("testName");
		appUseStatics.setUseFreq(10);
		appUseStatics.setUseTime(120);
		appUseStatics.setWeight(200);
		appUseStatics.setSysApp(0);

		DBManager manager = new DBManager(getContext());
		manager.add(appUseStatics);
	}

	public void TestAddAll() {
		List<AppUseStatics> infos = new ArrayList<AppUseStatics>();
		for (int i = 1; i < 20; i++) {
			AppUseStatics appUseStatics = new AppUseStatics();

			appUseStatics.setName("testName" + i);
			appUseStatics.setPkgName("testPkgName" + i);
			appUseStatics.setUseFreq(10 + i);
			appUseStatics.setUseTime(120 + i);
			appUseStatics.setWeight(200 + i);
			appUseStatics.setSysApp(0);

			infos.add(appUseStatics);
		}

		DBManager manager = new DBManager(getContext());
		manager.addAll(infos);
	}

	public void TestDeleteByAppName() {
		String name = "testName";

		DBManager manager = new DBManager(getContext());
		manager.deleteByAppName(name);
	}

	public void TestDeleteAll() {
		DBManager manager = new DBManager(getContext());
		manager.deleteAll();
	}

	public void TestQueryByAppName() {
		String name = "testName1";

		DBManager manager = new DBManager(getContext());
		AppUseStatics appUseStatics = manager.queryByAppName(name);
		LogUtil.i(TAG, appUseStatics.getPkgName() + " === "
				+ appUseStatics.getName());
	}
	
	/**
	 * 测试根据包名查询应用信息
	 */
	public void TestQueryByPkgName(){
		String pkgName = "testPkgName1";

		DBManager manager = new DBManager(getContext());
		AppUseStatics appUseStatics = manager.queryByPkgName(pkgName);
		LogUtil.i(TAG, appUseStatics.getPkgName() + " === "
				+ appUseStatics.getName()
				+ appUseStatics.getUseFreq()+"次"
				+ appUseStatics.getUseTime()+"秒");
	}

	public void TestFindAll() {
		DBManager manager = new DBManager(getContext());
		List<AppUseStatics> infos = manager.findAll();
		LogUtil.i(TAG,"记录条数： " + infos.size());
	}
	
	public void TestFindTopApp(){
		DBManager manager = new DBManager(getContext());
		List<AppUseStatics> infos = manager.findTopApp(6);
		LogUtil.i(TAG,"排名前6的记录信息： ");
		for(int i=0;i<infos.size();i++){
			LogUtil.i(TAG,infos.get(i).getName() +" -- "+infos.get(i).getWeight());
		}
	}
	
	public void TestUpdateAppInfo(){
		DBManager manager = new DBManager(getContext());
		AppUseStatics appUseStatics = new AppUseStatics();

		appUseStatics.setPkgName("testPkgName1");
		appUseStatics.setName("testName1");
		appUseStatics.setUseFreq(1000);
		appUseStatics.setUseTime(12000);
		appUseStatics.setWeight(20000);
		appUseStatics.setSysApp(0);
		
		manager.updateAppInfo(appUseStatics);
	}

}
