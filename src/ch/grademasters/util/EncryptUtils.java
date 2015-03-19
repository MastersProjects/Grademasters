package ch.grademasters.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptUtils {

	public static final String DEFAULT_ENCODING = "UTF-8";
	static BASE64Encoder enc = new BASE64Encoder();
	static BASE64Decoder dec = new BASE64Decoder();

	public static String base64encode(String text) {
		try {
			String rez = enc.encode(text.getBytes(DEFAULT_ENCODING));
			return rez;
		}
		catch (UnsupportedEncodingException e) {
			return null;
		}
	}// base64encode

	public static String base64decode(String text) {

		try {
			return new String(dec.decodeBuffer(text), DEFAULT_ENCODING);
		}
		catch (IOException e) {
			return null;
		}

	}// base64decode
}
