package com.zp.quickaccess.test;

import java.util.ArrayList;
import java.util.List;

import android.test.AndroidTestCase;

import com.zp.quickaccess.db.DayStatisticDBManager;
import com.zp.quickaccess.domain.DWAppInfo;

public class TestDBDayAppInfo extends AndroidTestCase {

	private static final String TAG = "TestDBDayAppInfo";

	public void TestAdd() {
		DWAppInfo appInfo = new DWAppInfo();

		appInfo.setAppName("testName2");
		appInfo.setPkgName("testPkgName2");
		appInfo.setUseFreq(101);
		appInfo.setUseTime(1201);

		DayStatisticDBManager manager = new DayStatisticDBManager(getContext());
		manager.add(appInfo);
	}

	public void TestUpdateAppInfo() {
		DWAppInfo appInfo = new DWAppInfo();

		appInfo.setAppName("testName");
		appInfo.setPkgName("testPkgName2");
		appInfo.setUseFreq(1111);
		appInfo.setUseTime(2222);

		DayStatisticDBManager manager = new DayStatisticDBManager(getContext());
		manager.updateAppInfo(appInfo);
	}

	public void TestFindAll() {
		List<DWAppInfo> appInfos = new ArrayList<DWAppInfo>();

		DayStatisticDBManager manager = new DayStatisticDBManager(getContext());
		appInfos = manager.findAll();
		assertEquals(2, appInfos.size());
	}
	
	public void TestDeleteAll() {

		DayStatisticDBManager manager = new DayStatisticDBManager(getContext());
		manager.deleteAll();
	}
	
	public void TestAddByPkgName(){
		DayStatisticDBManager manager = new DayStatisticDBManager(getContext());
		manager.addByName("com.zp.quickaccess");
	}
	
	public void TestFindAllPkgNames(){
		DayStatisticDBManager manager = new DayStatisticDBManager(getContext());
		List<String> names = manager.findAllPkgNames();
		assertEquals(1, names.size());
	}
}
