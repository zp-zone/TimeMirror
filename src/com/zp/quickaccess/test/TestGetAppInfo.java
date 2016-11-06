package com.zp.quickaccess.test;

import java.util.List;

import android.test.AndroidTestCase;

import com.zp.quickaccess.domain.AppUseStatics;
import com.zp.quickaccess.engine.AppInfoProvider;

public class TestGetAppInfo extends AndroidTestCase {

	public void getApps() throws Exception {
		AppInfoProvider provider = new AppInfoProvider(getContext());
		List<AppUseStatics> infos = provider.getAllApps();
		for (AppUseStatics info : infos) {
			System.out.print("name : " + info.getName());
			System.out.println("\t pkgName : " + info.getPkgName());
		}
	}
}
