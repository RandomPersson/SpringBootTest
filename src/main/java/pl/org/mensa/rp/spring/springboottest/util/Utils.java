package pl.org.mensa.rp.spring.springboottest.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

public class Utils {
	private static final String color_prefix = "\u001B[",
								color_suffix = "m";
	
	private static final Map<String, String> color_map = new HashMap<String, String>();
	static {
		color_map.put("&0", "30");
		color_map.put("&1", "34");
		color_map.put("&2", "32");
		color_map.put("&3", "36");
		color_map.put("&4", "31");
		color_map.put("&5", "35");
		color_map.put("&6", "33");
		color_map.put("&7", "37");
		
		color_map.put("&8", "90");
		color_map.put("&9", "94");
		color_map.put("&a", "92");
		color_map.put("&b", "96");
		color_map.put("&c", "91");
		color_map.put("&d", "95");
		color_map.put("&e", "93");
		color_map.put("&f", "97");
		
		color_map.put("&r", "0");
	}
	
	// ye, I noticed this doesn't work on Tomcat
	// but looks cool when testing so it stays :D
	public static String ANSIfyColors(String text) {
		String pattern_string = "(" + StringUtils.join(color_map.keySet(), "|") + ")";
		Pattern pattern = Pattern.compile(pattern_string);
		Matcher matcher = pattern.matcher(text);

		StringBuffer string_buffer = new StringBuffer();
		while(matcher.find()) {
		    matcher.appendReplacement(string_buffer, color_prefix + color_map.get(matcher.group(1)) + color_suffix);
		}
		matcher.appendTail(string_buffer);

		return string_buffer.toString();
	}
	
	public static void log(String message, Logger logger) {
		logger.info(ANSIfyColors(message));
	}
	
	public static String buildString(Object... objects) {
		StringBuilder string_builder = new StringBuilder(objects.length);
		
		for (Object object : objects) {
			string_builder.append(object);
		}
		
		return string_builder.toString();
	}
}
