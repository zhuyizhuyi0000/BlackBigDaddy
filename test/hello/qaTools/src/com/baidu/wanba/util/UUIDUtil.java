package com.baidu.wanba.util;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Random;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * 
 * @author huicheng yang
 * @version 1.0
 */
public class UUIDUtil {

	private static final int IP;

	public static int IptoInt(byte[] bytes) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
		}
		return result;
	}

	static {
		int ipadd;
		try {
			ipadd = IptoInt(InetAddress.getLocalHost().getAddress());
		} catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd;
	}
	private static short counter = (short) 0;
	private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

	public UUIDUtil() {
	}

	/**
	 * Unique across JVMs on this machine (unless they load this class in the
	 * same quater second - very unlikely)
	 */
	protected static int getJVM() {
		return JVM;
	}

	/**
	 * Unique in a millisecond for this JVM instance (unless there are >
	 * Short.MAX_VALUE instances created in a millisecond)
	 */
	protected static short getCount() {
		synchronized (UUIDUtil.class) {
			if (counter < 0)
				counter = 0;
			return counter++;
		}
	}

	/**
	 * Unique in a local network
	 */
	protected static int getIP() {
		return IP;
	}

	/**
	 * Unique down to millisecond
	 */
	protected static short getHiTime() {
		return (short) (System.currentTimeMillis() >>> 32);
	}

	protected static int getLoTime() {
		return (int) System.currentTimeMillis();
	}

	protected static int getNanoTime() {
		return (int) System.nanoTime();
	}

	protected static String format(int intval) {
		String formatted = Integer.toHexString(intval);
		StringBuffer buf = new StringBuffer("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	protected static String format(short shortval) {
		String formatted = Integer.toHexString(shortval);
		StringBuffer buf = new StringBuffer("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	public static Serializable generate() {
		return new StringBuffer(32).append(format(getIP())).append(format(getJVM())).append(
						format(getHiTime())).append(format(getLoTime())).append(format(getCount()))
						.toString();
	}

	public static Serializable create() {
		return new StringBuffer(32).append(format(getJVM())).append(format(getHiTime())).append(
						format(getNanoTime())).append(format(getCount())).append(format(getLoTime()))
						.toString();
	}

	public static String generateSimple() {
		Random random = new Random();
		int i = random.nextInt(8);
		return new StringBuffer(12).append(format(getNanoTime()).substring(0, i)).append(format(getCount()))
						.append(format(getNanoTime()).substring(i, 8)).toString();
	}

	public static void main(String[] args) {
		UUIDUtil g = new UUIDUtil();
		System.out.println(g.generateSimple());
		System.out.println(g.generateSimple());
		System.out.println(g.generateSimple());
		System.out.println(g.generateSimple());
		System.out.println(g.generate().toString());
		System.out.println(g.create().toString());
		int num = Math.abs(g.generate().hashCode());
		System.out.println(num);
		 num = Math.abs(g.generateSimple().hashCode());
		System.out.println(num);
		System.out.println(g.getNanoTime());
	}

}
