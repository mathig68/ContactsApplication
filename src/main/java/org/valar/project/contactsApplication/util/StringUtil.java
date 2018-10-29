package org.valar.project.contactsApplication.util;

public class StringUtil {

	static String result;

	public static String toCommaSeparatedString(Object[] obj) {
		if (obj != null || obj.equals(null)) {
			if (obj.length > 0) {
				StringBuilder sb = new StringBuilder();

				for (Object str : obj) {
					sb.append(str + " ,");
				}
				result = sb.deleteCharAt(obj.length - 1).toString();
			}
		}
		return result;
	}
}
