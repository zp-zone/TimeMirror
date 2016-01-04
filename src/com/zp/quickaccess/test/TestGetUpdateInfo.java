package com.zp.quickaccess.test;

import android.test.AndroidTestCase;

import com.zp.quickaccess.domain.UpdateInfo;
import com.zp.quickaccess.engine.UpdateInfoService;
import com.zp.quickaccess.R;

public class TestGetUpdateInfo extends AndroidTestCase {

	public void testGetUpdateInfo() throws Exception{
		UpdateInfoService updateInfoService = new UpdateInfoService(getContext());
		UpdateInfo info = updateInfoService.getUpdataInfo(R.string.updateurl);
		assertEquals("2.0", info.getVersion());
	}
}
