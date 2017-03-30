package com.aotu.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.java_websocket.util.Base64;

/**
 * 将二进制流转换成图片文件
 */
public class ImgErToFileUtil {

	/**
	 * 将接收的字符串转换成图片保存
	 * 
	 * @param imgStr
	 *            二进制流转换的字符串
	 * @param imgPath
	 *            图片的保存路径
	 * @param imgName
	 *            图片的名称
	 * @return 1：保存正常 0：保存失败
	 */
	public static int saveToImgByStr(String imgStr, String imgPath,
			String imgName) {
		try {
			System.out.println("===imgStr.length()====>" + imgStr.length()
					+ "=====imgStr=====>" + imgStr);
//			Base64.decode("");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		int stateInt = 1;
		if (imgStr != null && imgStr.length() > 0) {
			try {

				// 将字符串转换成二进制，用于显示图片
				// 将上面生成的图片格式字符串 imgStr，还原成图片显示
//				byte[] imgByte = hex2byte(imgStr);
				
				byte[] imgByte = Base64.decode(imgStr);

				InputStream in = new ByteArrayInputStream(imgByte);

				File file = new File(imgPath, imgName);// 可以是任何图片格式.jpg,.png等
				FileOutputStream fos = new FileOutputStream(file);

				byte[] b = new byte[1024];
				int nRead = 0;
				while ((nRead = in.read(b)) != -1) {
					fos.write(b, 0, nRead);
				}
				fos.flush();
				fos.close();
				in.close();

			} catch (Exception e) {
				stateInt = 0;
				e.printStackTrace();
			} finally {
			}
		}
		return stateInt;
	}

	/**
	 * 将二进制转换成图片保存
	 * 
	 * @param imgStr
	 *            二进制流转换的字符串
	 * @param imgPath
	 *            图片的保存路径
	 * @param imgName
	 *            图片的名称
	 * @return 1：保存正常 0：保存失败
	 */
	public static int saveToImgByBytes(File imgFile, String imgPath,
			String imgName) {

		int stateInt = 1;
		if (imgFile.length() > 0) {
			try {
				File file = new File(imgPath, imgName);// 可以是任何图片格式.jpg,.png等
				FileOutputStream fos = new FileOutputStream(file);

				FileInputStream fis = new FileInputStream(imgFile);

				byte[] b = new byte[1024];
				int nRead = 0;
				while ((nRead = fis.read(b)) != -1) {
					fos.write(b, 0, nRead);
				}
				fos.flush();
				fos.close();
				fis.close();

			} catch (Exception e) {
				stateInt = 0;
				e.printStackTrace();
			} finally {
			}
		}
		return stateInt;
	}

	/**
	 * 二进制转字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) // 二进制转字符串
	{
		StringBuffer sb = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0XFF);
			if (stmp.length() == 1) {
				sb.append("0" + stmp);
			} else {
				sb.append(stmp);
			}

		}
		return sb.toString();
	}

	/**
	 * 字符串转二进制
	 * 
	 * @param str
	 *            要转换的字符串
	 * @return 转换后的二进制数组
	 */
	public static byte[] hex2byte(String str) { // 字符串转二进制
		if (str == null)
			return null;
		str = str.trim();
		int len = str.length();
		if (len == 0 || len % 2 == 1)
			return null;
		byte[] b = new byte[len / 2];
		try {
			for (int i = 0; i < str.length(); i += 2) {
				b[i / 2] = (byte) Integer
						.decode("0X" + str.substring(i, i + 2)).intValue();
			}
			return b;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		
		String imgStr = "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";
		String imgPath = "D:/workspace/upload";
		String imgName = "test.jpg";
		saveToImgByStr(imgStr,imgPath,imgName );
	}

}
