package com.rainbow.fw.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.util.NumberUtils;

/**
 * Converts from a String any JDK-standard Number implementation.
 * 
 * <p>
 * Support Number classes including Byte, Short, Integer, Float, Double, Long,
 * BigInteger, BigDecimal. This class delegates to
 * {@link NumberUtils#parseNumber(String, Class)} to perform the conversion.
 * 
 * @author Keith Donald
 * @since 3.0
 * @see java.lang.Byte
 * @see java.lang.Short
 * @see java.lang.Integer
 * @see java.lang.Long
 * @see java.math.BigInteger
 * @see java.lang.Float
 * @see java.lang.Double
 * @see java.math.BigDecimal
 * @see NumberUtils
 */
final class StringToNumberConverterFactory implements ConverterFactory<String, Number> {

	public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
		return new StringToNumber<T>(targetType);
	}

	private static final class StringToNumber<T extends Number> implements Converter<String, T> {

		private final Class<T> targetType;

		public StringToNumber(Class<T> targetType) {
			this.targetType = targetType;
		}

		public T convert(String source) {
			//System.out.println("in string to number converter factory!");
			if (source.length() == 0) {
				throw new IllegalArgumentException(String.format("类型转换失败，需要数字格式"));
			}
			//System.out.println("in string to number converter factory!");
			if (!source.matches("[0-9]*")) {
				// return null;
				// ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				// "firstName", "First name can't be blank");
				throw new IllegalArgumentException(String.format("类型转换失败，需要数字格式，但格式是[%s]", source));
			}

			return NumberUtils.parseNumber(source, this.targetType);
		}
	}

}
