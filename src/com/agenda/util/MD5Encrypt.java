package com.agenda.util;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class MD5Encrypt {

	public MD5Encrypt() {

	}

	private final static String[] hexDigits = {

	"0", "1", "2", "3", "4", "5", "6", "7",

	"8", "9", "a", "b", "c", "d", "e", "f"

	};

	public static String byteArrayToString(byte[] b) {

		StringBuffer resultSb = new StringBuffer();

		for (int i = 0; i < b.length; i++) {

			resultSb.append(byteToNumString(b[i]));

		}

		return resultSb.toString();

	}

	private static String byteToNumString(byte b) {

		int _b = b;

		if (_b < 0) {

			_b = 256 + _b;

		}

		return String.valueOf(_b);

	}

	private static String byteToHexString(byte b) {

		int n = b;

		if (n < 0) {

			n = 256 + n;

		}

		int d1 = n / 16;

		int d2 = n % 16;

		return hexDigits[d1] + hexDigits[d2];

	}

	public static String MD5Encode(String origin) {

		String resultString = null;

		try {

			resultString = new String(origin);

			MessageDigest md = MessageDigest.getInstance("MD5");

			resultString =

			byteArrayToString(md.digest(resultString.getBytes()));

		}

		catch (Exception ex) {

		}

		return resultString;

	}

	public static int byteToInt(byte b) {
		// Java 总是把 byte 当做有符处理；我们可以通过将其和 0xFF 进行二进制与得到它的无符值
		return b & 0xFF;
	}

	public static byte intToByte(int x) {
		return (byte) x;
	}

	// byte 数组与 int 的相互转换
	public static int byteArrayToInt(byte[] b) {
		return b[3] & 0xFF | (b[2] & 0xFF) << 8 | (b[1] & 0xFF) << 16
				| (b[0] & 0xFF) << 24;
	}

	public static byte[] intToByteArray(int a) {
		return new byte[] { (byte) ((a >> 24) & 0xFF),
				(byte) ((a >> 16) & 0xFF), (byte) ((a >> 8) & 0xFF),
				(byte) (a & 0xFF) };
	}

	public static byte[] long2Byte(long x) {
		byte[] bb = new byte[8];
		bb[0] = (byte) (x >> 56);
		bb[1] = (byte) (x >> 48);
		bb[2] = (byte) (x >> 40);
		bb[3] = (byte) (x >> 32);
		bb[4] = (byte) (x >> 24);
		bb[5] = (byte) (x >> 16);
		bb[6] = (byte) (x >> 8);
		bb[7] = (byte) (x >> 0);
		return bb;
	}

	public static long byte2Long(byte[] bb) {
		return ((((long) bb[0] & 0xff) << 56) | (((long) bb[1] & 0xff) << 48)
				| (((long) bb[2] & 0xff) << 40) | (((long) bb[3] & 0xff) << 32)
				| (((long) bb[4] & 0xff) << 24) | (((long) bb[5] & 0xff) << 16)
				| (((long) bb[6] & 0xff) << 8) | (((long) bb[7] & 0xff) << 0));
	}

	

	public static void main(String[] args) throws Exception {

		String str = "fdsf_456fdsfdsffsdf";
		byte[] b = str.getBytes("utf-8");
		System.out.println(b.length);
		System.out.println(byte2Long(b));
		System.out.println(new String(long2Byte(7378148973060830518L)));
		System.out.println("yyyy-MM-dd".length());

	}

}
