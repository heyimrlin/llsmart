/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月20日下午5:08:38
 * @包名:com.leelen.utils
 * @描述:TODO
 */
package com.leelen.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xiaoxl 字符串工具类
 */
public class StringUtil {

	/**
	 * 过滤空NULL
	 * 
	 * @param o
	 * @return
	 */
	public static String FilterNull(Object o) {
		return o != null && !"null".equals(o.toString()) ? o.toString().trim() : "";
	}

	/**
	 * 是否为空
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		}
		if ("".equals(FilterNull(o.toString()))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 是否不为空
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isNotEmpty(Object o) {
		if (o == null) {
			return false;
		}
		if ("".equals(FilterNull(o.toString()))) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 是否可转化为数字
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isNum(Object o) {
		try {
			new BigDecimal(o.toString());
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * 是否可转化为Long型数字
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isLong(Object o) {
		try {
			new Long(o.toString());
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * 转化为Long型数字, 不可转化时返回0
	 * 
	 * @param o
	 * @return
	 */
	public static Long toLong(Object o) {
		if (isLong(o)) {
			return new Long(o.toString());
		} else {
			return 0L;
		}
	}

	/**
	 * 转化为int型数字, 不可转化时返回0
	 * 
	 * @param o
	 * @return
	 */
	public static int toInt(Object o) {
		if (isNum(o)) {
			return new Integer(o.toString());
		} else {
			return 0;
		}
	}

	/**
	 * 按字符从左截取固定长度字符串, 防止字符串超长, 默认截取50
	 * 
	 * @param o
	 * @return
	 */
	public static String holdmaxlength(Object o) {
		int maxlength = 50;
		if (o == null) {
			return "";
		}
		return subStringByByte(o, maxlength);
	}

	/**
	 * 从左截取固定长度字符串, 防止字符串超长, maxlength为0时默认50
	 * 
	 * @param o
	 * @return
	 */
	public static String holdmaxlength(Object o, int maxlength) {
		maxlength = maxlength <= 0 ? 50 : maxlength;
		if (o == null) {
			return "";
		}
		return subStringByByte(o, maxlength);
	}

	/**
	 * 按字节截取字符串
	 * 
	 * @param str
	 * @param len
	 * @return
	 */
	private static String subStringByByte(Object o, int len) {
		if (o == null) {
			return "";
		}
		String str = o.toString();
		String result = null;
		if (str != null) {
			byte[] a = str.getBytes();
			if (a.length <= len) {
				result = str;
			} else if (len > 0) {
				result = new String(a, 0, len);
				int length = result.length();
				if (str.charAt(length - 1) != result.charAt(length - 1)) {
					if (length < 2) {
						result = null;
					} else {
						result = result.substring(0, length - 1);
					}
				}
			}
		}
		return result;
	}

	/**
	 * 逗号表达式_添加
	 * 
	 * @param commaexpress
	 *            原逗号表达式 如 A,B
	 * @param newelement
	 *            新增元素 C
	 * @return A,B,C
	 */
	public static String comma_add(String commaexpress, String newelement) {
		return comma_rect(FilterNull(commaexpress) + "," + FilterNull(newelement));
	}

	/**
	 * 逗号表达式_删除
	 * 
	 * @param commaexpress
	 *            原逗号表达式 如 A,B,C
	 * @param delelement
	 *            删除元素 C,A
	 * @return B
	 */
	public static String comma_del(String commaexpress, String delelement) {
		if ((commaexpress == null) || (delelement == null) || (commaexpress.trim().equals(delelement.trim()))) {
			return "";
		}
		String[] deletelist = delelement.split(",");
		String result = commaexpress;
		for (String delstr : deletelist) {
			result = comma_delone(result, delstr);
		}
		return result;
	}

	/**
	 * 逗号表达式_单一删除
	 * 
	 * @param commaexpress
	 *            原逗号表达式 如 A,B,C
	 * @param delelement
	 *            删除元素 C
	 * @return A,B
	 */
	public static String comma_delone(String commaexpress, String delelement) {
		if ((commaexpress == null) || (delelement == null) || (commaexpress.trim().equals(delelement.trim()))) {
			return "";
		}
		String[] strlist = commaexpress.split(",");
		StringBuffer result = new StringBuffer();
		for (String str : strlist) {
			if ((!str.trim().equals(delelement.trim())) && (!"".equals(str.trim()))) {
				result.append(str.trim() + ",");
			}
		}
		return result.toString().substring(0, result.length() - 1 > 0 ? result.length() - 1 : 0);
	}

	/**
	 * 逗号表达式_判断是否包含元素
	 * 
	 * @param commaexpress
	 *            逗号表达式 A,B,C
	 * @param element
	 *            C
	 * @return true
	 */
	public static boolean comma_contains(String commaexpress, String element) {
		boolean flag = false;
		commaexpress = FilterNull(commaexpress);
		element = FilterNull(element);
		if (!"".equals(commaexpress) && !"".equals(element)) {
			String[] strlist = commaexpress.split(",");
			for (String str : strlist) {
				if (str.trim().equals(element.trim())) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * 逗号表达式_取交集
	 * 
	 * @param commaexpressA
	 *            逗号表达式1 A,B,C
	 * @param commaexpressB
	 *            逗号表达式2 B,C,D
	 * @return B,C
	 */
	public static String comma_intersect(String commaexpressA, String commaexpressB) {
		commaexpressA = FilterNull(commaexpressA);
		commaexpressB = FilterNull(commaexpressB);
		StringBuffer result = new StringBuffer();
		String[] strlistA = commaexpressA.split(",");
		String[] strlistB = commaexpressB.split(",");
		for (String boA : strlistA) {
			for (String boB : strlistB) {
				if (boA.trim().equals(boB.trim())) {
					result.append(boA.trim() + ",");
				}
			}
		}
		return comma_rect(result.toString());
	}

	/**
	 * 逗号表达式_规范
	 * 
	 * @param commaexpress
	 *            逗号表达式 ,A,B,B,,C
	 * @return A,B,C
	 */
	public static String comma_rect(String commaexpress) {
		commaexpress = FilterNull(commaexpress);
		String[] strlist = commaexpress.split(",");
		StringBuffer result = new StringBuffer();
		for (String str : strlist) {
			if (!("".equals(str.trim())) && !("," + result.toString() + ",").contains("," + str + ",")
					&& !"null".equals(str)) {
				result.append(str.trim() + ",");
			}
		}
		return result.toString().substring(0, (result.length() - 1 > 0) ? result.length() - 1 : 0);
	}

	/**
	 * 逗号表达式_反转
	 * 
	 * @param commaexpress
	 *            A,B,C
	 * @return C,B,A
	 */
	public static String comma_reverse(String commaexpress) {
		commaexpress = FilterNull(commaexpress);
		String[] ids = commaexpress.split(",");
		StringBuffer str = new StringBuffer();
		for (int i = ids.length - 1; i >= 0; i--) {
			str.append(ids[i] + ",");
		}
		return comma_rect(str.toString());
	}

	/**
	 * 逗号表达式_获取首对象
	 * 
	 * @param commaexpress
	 *            A,B,C
	 * @return A
	 */
	public static String comma_first(String commaexpress) {
		commaexpress = FilterNull(commaexpress);
		String[] ids = commaexpress.split(",");
		System.out.println("length:" + ids.length);
		if ((ids != null) && (ids.length > 0)) {
			return ids[0];
		}
		return null;
	}

	/**
	 * 逗号表达式_获取尾对象
	 * 
	 * @param commaexpress
	 *            A,B,C
	 * @return C
	 */
	public static String comma_last(String commaexpress) {
		commaexpress = FilterNull(commaexpress);
		String[] ids = commaexpress.split(",");
		if ((ids != null) && (ids.length > 0)) {
			return ids[(ids.length - 1)];
		}
		return null;
	}

	/**
	 * 替换字符串,支持字符串为空的情形
	 * 
	 * @param strData
	 * @param regex
	 * @param replacement
	 * @return
	 */
	public static String replace(String strData, String regex, String replacement) {
		return strData == null ? "" : strData.replaceAll(regex, replacement);
	}

	/**
	 * 字符串转为HTML显示字符
	 * 
	 * @param strData
	 * @return
	 */
	public static String String2HTML(String strData) {
		if (strData == null || "".equals(strData)) {
			return "";
		}
		strData = replace(strData, "&", "&amp;");
		strData = replace(strData, "<", "&lt;");
		strData = replace(strData, ">", "&gt;");
		strData = replace(strData, "\"", "&quot;");
		return strData;
	}

	/** * 把异常信息转换成字符串，以方便保存 */
	public static String getexceptionInfo(Exception e) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			e.printStackTrace(new PrintStream(baos));
		} finally {
			try {
				baos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return baos.toString();
	}

	/** 过滤特殊符号 */
	public static String regex(String str) {
		Pattern pattern = Pattern.compile("[0-9-:/ ]");// 中文汉字编码区间
		Matcher matcher;
		char[] array = str.toCharArray();
		for (int i = 0; i < array.length; i++) {
			matcher = pattern.matcher(String.valueOf(array[i]));
			if (!matcher.matches()) {// 空格暂不替换
				str = str.replace(String.valueOf(array[i]), "");// 特殊字符用空字符串替换
			}
		}

		return str;
	}

	public static String comma_insert(String commaexpress, String newelement, int index) {
		int length = commaexpress.length();
		if (index > length) {
			index = length;
		} else if (index < 0) {
			index = 0;
		}
		String result = commaexpress.substring(0, index) + newelement
				+ commaexpress.substring(index, commaexpress.length());
		return result;
	}

	/**
	 * 将"/"替换成"\"
	 * 
	 * @param strDir
	 * @return
	 */
	public static String changeDirection(String strDir) {
		String s = "/";
		String a = "\\";
		if (strDir != null && !" ".equals(strDir)) {
			if (strDir.contains(s)) {
				strDir = strDir.replace(s, a);
			}
		}
		return strDir;
	}

	/**
	 * 去除字符串中 头和尾的空格，中间的空格保留
	 * 
	 * @Title: trim @Description: TODO @return String @throws
	 */
	public static String trim(String s) {
		int i = s.length();// 字符串最后一个字符的位置
		int j = 0;// 字符串第一个字符
		int k = 0;// 中间变量
		char[] arrayOfChar = s.toCharArray();// 将字符串转换成字符数组
		while ((j < i) && (arrayOfChar[(k + j)] <= ' '))
			++j;// 确定字符串前面的空格数
		while ((j < i) && (arrayOfChar[(k + i - 1)] <= ' '))
			--i;// 确定字符串后面的空格数
		return (((j > 0) || (i < s.length())) ? s.substring(j, i) : s);// 返回去除空格后的字符串
	}

	/**
	 * 得到大括号中的内容
	 * 
	 * @param str
	 * @return
	 */
	public static String getBrackets(String str) {
		int a = str.indexOf("{");
		int c = str.indexOf("}");
		if (a >= 0 && c >= 0 & c > a) {
			return (str.substring(a + 1, c));
		} else {
			return str;
		}
	}

	/**
	 * 将字符串中所有的，替换成|
	 * 
	 * @param str
	 * @return
	 */
	public static String commaToVerti(String str) {
		if (str != null && !"".equals(str) && str.contains(",")) {
			return str.replaceAll(",", "|");
		} else {
			return str;
		}
	}

	/**
	 * 去掉字符串中、前、后的空格
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static String extractBlank(String name) {
		if (name != null && !"".equals(name)) {
			return name.replaceAll(" +", "");
		} else {
			return name;
		}
	}

	/**
	 * 将null换成""
	 * 
	 * @param str
	 * @return
	 */
	public static String ConvertStr(String str) {
		return str != null && !"null".equals(str) ? str.trim() : "";
	}

	public static void main(String[] args) {
		System.out.println(isNum("a"));
		System.out.println(isNum("-1"));
		System.out.println(isNum("01"));
		System.out.println(isNum("1E3"));
		System.out.println(isNum("1.a"));
		System.out.println(isLong("014650"));
		System.out.println(Long.parseLong("014650"));
	}

	/**
	 * 首字母变小写
	 * 
	 * @param str
	 * @return
	 */
	public static String firstCharToLowerCase(String str) {
		char firstChar = str.charAt(0);
		if (firstChar >= 'A' && firstChar <= 'Z') {
			char[] arr = str.toCharArray();
			arr[0] += ('a' - 'A');
			return new String(arr);
		}
		return str;
	}

	/**
	 * 首字母变大写
	 * 
	 * @param str
	 * @return
	 */
	public static String firstCharToUpperCase(String str) {
		char firstChar = str.charAt(0);
		if (firstChar >= 'a' && firstChar <= 'z') {
			char[] arr = str.toCharArray();
			arr[0] -= ('a' - 'A');
			return new String(arr);
		}
		return str;
	}

	/**
	 * 判断是否为空
	 * 
	 * @param str
	 * @return
	 */
	// public static boolean isEmpty(final String str) {
	// return (str == null) || (str.length() == 0);
	// }

	/**
	 * 判断是否不为空
	 * 
	 * @param str
	 * @return
	 */
	// public static boolean isNotEmpty(final String str) {
	// return !isEmpty(str);
	// }

	/**
	 * 判断是否空白
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(final String str) {
		int strLen;
		if ((str == null) || ((strLen = str.length()) == 0))
			return true;
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断是否不是空白
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(final String str) {
		return !isBlank(str);
	}

	/**
	 * 判断多个字符串全部是否为空
	 * 
	 * @param strings
	 * @return
	 */
	public static boolean isAllEmpty(String... strings) {
		if (strings == null) {
			return true;
		}
		for (String str : strings) {
			if (isNotEmpty(str)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断多个字符串其中任意一个是否为空
	 * 
	 * @param strings
	 * @return
	 */
	public static boolean isHasEmpty(String... strings) {
		if (strings == null) {
			return true;
		}
		for (String str : strings) {
			if (isEmpty(str)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * checkValue为 null 或者为 "" 时返回 defaultValue
	 * 
	 * @param checkValue
	 * @param defaultValue
	 * @return
	 */
	public static String isEmpty(String checkValue, String defaultValue) {
		return isEmpty(checkValue) ? defaultValue : checkValue;
	}

	/**
	 * 字符串不为 null 而且不为 "" 并且等于other
	 * 
	 * @param str
	 * @param other
	 * @return
	 */
	public static boolean isNotEmptyAndEquelsOther(String str, String other) {
		if (isEmpty(str)) {
			return false;
		}
		return str.equals(other);
	}

	/**
	 * 字符串不为 null 而且不为 "" 并且不等于other
	 * 
	 * @param str
	 * @param other
	 * @return
	 */
	public static boolean isNotEmptyAndNotEquelsOther(String str, String... other) {
		if (isEmpty(str)) {
			return false;
		}
		for (int i = 0; i < other.length; i++) {
			if (str.equals(other[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 字符串不等于other
	 * 
	 * @param str
	 * @param other
	 * @return
	 */
	public static boolean isNotEquelsOther(String str, String... other) {
		for (int i = 0; i < other.length; i++) {
			if (other[i].equals(str)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串不为空
	 * 
	 * @param strings
	 * @return
	 */
	public static boolean isNotEmpty(String... strings) {
		if (strings == null) {
			return false;
		}
		for (String str : strings) {
			if (str == null || "".equals(str.trim())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 比较字符相等
	 * 
	 * @param value
	 * @param equals
	 * @return
	 */
	public static boolean equals(String value, String equals) {
		if (isAllEmpty(value, equals)) {
			return true;
		}
		return value.equals(equals);
	}

	/**
	 * 比较字符串不相等
	 * 
	 * @param value
	 * @param equals
	 * @return
	 */
	public static boolean isNotEquals(String value, String equals) {
		return !equals(value, equals);
	}

	public static String[] split(String content, String separatorChars) {
		return splitWorker(content, separatorChars, -1, false);
	}

	public static String[] split(String str, String separatorChars, int max) {
		return splitWorker(str, separatorChars, max, false);
	}

	public static final String[] EMPTY_STRING_ARRAY = new String[0];

	private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
		if (str == null) {
			return null;
		}
		int len = str.length();
		if (len == 0) {
			return EMPTY_STRING_ARRAY;
		}
		List<String> list = new ArrayList<String>();
		int sizePlus1 = 1;
		int i = 0, start = 0;
		boolean match = false;
		boolean lastMatch = false;
		if (separatorChars == null) {
			while (i < len) {
				if (Character.isWhitespace(str.charAt(i))) {
					if (match || preserveAllTokens) {
						lastMatch = true;
						if (sizePlus1++ == max) {
							i = len;
							lastMatch = false;
						}
						list.add(str.substring(start, i));
						match = false;
					}
					start = ++i;
					continue;
				}
				lastMatch = false;
				match = true;
				i++;
			}
		} else if (separatorChars.length() == 1) {
			char sep = separatorChars.charAt(0);
			while (i < len) {
				if (str.charAt(i) == sep) {
					if (match || preserveAllTokens) {
						lastMatch = true;
						if (sizePlus1++ == max) {
							i = len;
							lastMatch = false;
						}
						list.add(str.substring(start, i));
						match = false;
					}
					start = ++i;
					continue;
				}
				lastMatch = false;
				match = true;
				i++;
			}
		} else {
			while (i < len) {
				if (separatorChars.indexOf(str.charAt(i)) >= 0) {
					if (match || preserveAllTokens) {
						lastMatch = true;
						if (sizePlus1++ == max) {
							i = len;
							lastMatch = false;
						}
						list.add(str.substring(start, i));
						match = false;
					}
					start = ++i;
					continue;
				}
				lastMatch = false;
				match = true;
				i++;
			}
		}
		if (match || (preserveAllTokens && lastMatch)) {
			list.add(str.substring(start, i));
		}
		return (String[]) list.toArray(EMPTY_STRING_ARRAY);
	}

	/**
	 * 消除转义字符
	 * 
	 * @param str
	 * @return
	 */
	public static String escapeXML(String str) {
		if (str == null)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			switch (c) {
			case '\u00FF':
			case '\u0024':
				break;
			case '&':
				sb.append("&amp;");
				break;
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case '\"':
				sb.append("&quot;");
				break;
			case '\'':
				sb.append("&apos;");
				break;
			default:
				if (c >= '\u0000' && c <= '\u001F')
					break;
				if (c >= '\uE000' && c <= '\uF8FF')
					break;
				if (c >= '\uFFF0' && c <= '\uFFFF')
					break;
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}

	/**
	 * 将字符串中特定模式的字符转换成map中对应的值
	 *
	 * @param s
	 *            需要转换的字符串
	 * @param map
	 *            转换所需的键值对集合
	 * @return 转换后的字符串
	 */
	public static String replace(String s, Map<String, Object> map) {
		StringBuilder ret = new StringBuilder((int) (s.length() * 1.5));
		int cursor = 0;
		for (int start, end; (start = s.indexOf("${", cursor)) != -1 && (end = s.indexOf("}", start)) != -1;) {
			ret.append(s.substring(cursor, start)).append(map.get(s.substring(start + 2, end)));
			cursor = end + 1;
		}
		ret.append(s.substring(cursor, s.length()));
		return ret.toString();
	}

	public static String replace(String s, Object... objs) {
		if (objs == null || objs.length == 0)
			return s;
		if (s.indexOf("{}") == -1)
			return s;
		StringBuilder ret = new StringBuilder((int) (s.length() * 1.5));
		int cursor = 0;
		int index = 0;
		for (int start; (start = s.indexOf("{}", cursor)) != -1;) {
			ret.append(s.substring(cursor, start));
			if (index < objs.length)
				ret.append(objs[index]);
			else
				ret.append("{}");
			cursor = start + 2;
			index++;
		}
		ret.append(s.substring(cursor, s.length()));
		return ret.toString();
	}

	/**
	 * 字符串格式化工具,参数必须以{0}之类的样式标示出来.大括号中的数字从0开始。
	 * 
	 * @param source
	 *            源字符串
	 * @param params
	 *            需要替换的参数列表,写入时会调用每个参数的toString().
	 * @return 替换完成的字符串。如果原始字符串为空或者参数为空那么将直接返回原始字符串。
	 */
	public static String replaceArgs(String source, Object... params) {
		if (params == null || params.length == 0 || source == null || source.isEmpty()) {
			return source;
		}
		StringBuilder buff = new StringBuilder(source);
		StringBuilder temp = new StringBuilder();
		int startIndex = 0;
		int endIndex = 0;
		String param = null;
		for (int count = 0; count < params.length; count++) {
			if (params[count] == null) {
				param = null;
			} else {
				param = params[count].toString();
			}

			temp.delete(0, temp.length());
			temp.append("{");
			temp.append(count);
			temp.append("}");
			while (true) {
				startIndex = buff.indexOf(temp.toString(), endIndex);
				if (startIndex == -1) {
					break;
				}
				endIndex = startIndex + temp.length();

				buff.replace(startIndex, endIndex, param == null ? "" : param);
			}
			startIndex = 0;
			endIndex = 0;
		}
		return buff.toString();
	}

	public static String substringBefore(final String s, final String separator) {
		if (isEmpty(s) || separator == null) {
			return s;
		}
		if (separator.isEmpty()) {
			return "";
		}
		final int pos = s.indexOf(separator);
		if (pos < 0) {
			return s;
		}
		return s.substring(0, pos);
	}

	public static String substringBetween(final String str, final String open, final String close) {
		if (str == null || open == null || close == null) {
			return null;
		}
		final int start = str.indexOf(open);
		if (start != -1) {
			final int end = str.indexOf(close, start + open.length());
			if (end != -1) {
				return str.substring(start + open.length(), end);
			}
		}
		return null;
	}

	public static String substringAfter(final String str, final String separator) {
		if (isEmpty(str)) {
			return str;
		}
		if (separator == null) {
			return "";
		}
		final int pos = str.indexOf(separator);
		if (pos == -1) {
			return "";
		}
		return str.substring(pos + separator.length());
	}

	/**
	 * 转换为字节数组
	 * 
	 * @param str
	 * @return
	 */
	public static String toString(byte[] bytes) {
		try {
			return new String(bytes, "utf-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * 转换为字节数组
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] getBytes(String str) {
		if (str != null) {
			try {
				return str.getBytes("utf-8");
			} catch (UnsupportedEncodingException e) {
				return null;
			}
		} else {
			return null;
		}
	}
}
