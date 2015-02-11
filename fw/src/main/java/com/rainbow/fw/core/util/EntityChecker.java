package com.rainbow.fw.core.util;

import java.math.BigDecimal;

import com.rainbow.fw.core.exception.SysException;

public class EntityChecker {
	public static void isNotNull(Object arg, Object... desc) {
		if (null == arg) {
			throw new SysException("E9001", desc);
		}
	}

	public static void isNotZero(long arg, Object... desc) {
		if (0 == arg) {
			throw new SysException("E9001", desc);
		}
	}

	public static void isNotZero(int arg, Object... desc) {
		if (0 == arg) {
			throw new SysException("E9001", desc);
		}
	}

	public static void isNotZero(double arg, Object... desc) {
		if (0 == arg) {
			throw new SysException("E9001", desc);
		}
	}

	public static void isNotZero(float arg, Object... desc) {
		if (0 == arg) {
			throw new SysException("E9001", desc);
		}
	}

	public static void isNotZero(BigDecimal arg, Object... desc) {
		if (null == arg || 0 == BigDecimal.ZERO.compareTo(arg)) {
			throw new SysException("E9001", desc);
		}
	}

}
