package com.zp.quickaccess.utils;

import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class IconUtils {

	/**
	 *  Drawable 对象转为Bitmap
	 *  
	 * @param drawable
	 * @return
	 */
	public static Bitmap drawableToBitamp(Drawable drawable) {
		BitmapDrawable bd = (BitmapDrawable) drawable;
		return bd.getBitmap();
	}
	
	/**
	 *  Drawable对象转化为byte数组
	 * 
	 * @param drawable
	 * @return
	 */
	public static byte[] getIconData(Drawable drawable) {
		// 将Drawable对象转换为bitmap对象
		Bitmap bmp = IconUtils.drawableToBitamp(drawable);
		int size = bmp.getWidth() * bmp.getHeight() * 4;
		// 将Bitmap转换为流存并返回
		ByteArrayOutputStream out = new ByteArrayOutputStream(size);
		try {
			bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
			out.close();
		} catch (Exception e) {
			return null;
		}
		return out.toByteArray();
	}
	
	/**
	 * bytes数组转化为Bitmap
	 * 
	 * @param bytes
	 * @return
	 */
	public static Bitmap getBitmapFromBytes(byte bytes[]){
		return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
	}
	
	/**
	 * Bitmap转化为Drawable
	 * 
	 * @param bmp
	 * @return
	 */
	public static Drawable getDrawableFromBitmap(Bitmap bmp){
		return new BitmapDrawable(bmp);
	}
	
}
