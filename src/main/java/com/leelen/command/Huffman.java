/**  
* All rights Reserved, Designed By www.leelen.com
* @Title:  Huffman.java   
* @Package com.xxl.test   
* @Description:    TODO(��һ�仰�������ļ���ʲô)   
* @author: leelen�Ƽ�(xiaoxl)     
* @date:   2018��7��9�� ����11:35:50   
* @version V1.0 
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* ע�⣺�����ݽ��������ֿƼ��ڲ����ģ���ֹ��й�Լ�com.leelen.commandҵĿ��
*/

package com.leelen.command;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
/**   
* @ClassName:  Huffman   
* @Description:TODO(������һ�仰��������������)   
* @author: leelen�Ƽ�(xiaoxl) 
* @date:   2018��7��9�� ����11:35:50   
*     
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* ע�⣺�����ݽ��������ֿƼ��ڲ����ģ���ֹ��й�Լ�������������ҵĿ��
*/
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.GZIPOutputStream;

import com.leelen.utils.Ramdata;

public class Huffman { // Written by: Yancy Vance Paredes, October 17, 2013

	public static PriorityQueue<Node> q;
	public static HashMap<Character, String> charToCode;
	public static HashMap<String, Character> codeToChar;

	static String[] binarys = { "00", "01", "10", "11" };

	static String[] ids = { "2", "0", "1", "3" };

	static String[] strs = { "00", "01", "02", "03", "10", "11", "12", "13", "20", "21", "22", "23", "30", "31", "32",
			"33" };

	public static String generateRandomStr(int len) {
		String code = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		String str = "";
		for (int i = 1; i <= 6; i++) {
			String num = String.valueOf(code.charAt((int) Math.floor(Math.random() * code.length())));
			str += num;
			code = code.replaceAll(num, "");
		}
		return str;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// Read all the contents of the file
		// String text = new Scanner(new File("input.txt")).useDelimiter("\\A").next();
		// // nextLine(); // change it if you only want to read a single line without
		// the new line character.

		// System.out.println("suijishu:" + generateRandomStr(4));

		String text = Ramdata.ramdaSw(33);

		System.out.println("随机数:" + text + "\t" + text.length());

		// Count the frequency of all the characters
		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();

		for (int i = 0; i < text.length(); i++) {
			char a = text.charAt(i);

			if (dict.containsKey(a))
				dict.put(a, dict.get(a) + 1);
			else
				dict.put(a, 1);
		}

		// Create a forest (group of trees) by adding all the nodes to a priority queue
		q = new PriorityQueue<Node>(100, new FrequencyComparator());
		int n = 0;

		for (Character c : dict.keySet()) {
			q.add(new Node(c, dict.get(c)));
			n++;
		}

		// Identify the root of the tree
		Node root = huffman(n);

		// Build the table for the variable length codes
		buildTable(root);

		String compressed = compress(text);
		System.out.println("The compressed used a total of " + compressed.length() + " bits");
		System.out.println(compressed);
		String s = "";
		String[][] aStrings = new String[compressed.length()][1];
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < compressed.length(); i++) {
			// System.out.print(compressed.charAt(i));
			s += compressed.charAt(i);
			if (s.equals("01")) {
				s = "3";
				sBuilder.append(s);
				aStrings[i][0] = s;
				s = "";
			}
			if (s.equals("10")) {
				s = "1";
				sBuilder.append(s);
				s = "";
			}
			if (s.equals("00")) {
				s = "2";
				sBuilder.append(s);
				aStrings[i][0] = s;
				s = "";
			}
			if (s.equals("11")) {
				s = "0";
				sBuilder.append(s);
				s = "";
			}
		}
		// 11111111111111111111111111 26 67108863
		System.out.println(aStrings);
		System.out.println(sBuilder.toString());
		String so = sBuilder.toString().replace("2", "").replace("3", "");
		System.out.println("\n" + so);
		// 1001100110011111001111101111111000011101101
		BigInteger yas = binaryToDecimal(so);
		System.out.println("压缩后:" + yas + "\t" + yas.toString().length() + "位");
		// String so = compressed.substring(0, compressed.length() / 3);
		// String st = compressed.substring(compressed.length() / 3, compressed.length()
		// * 2 / 3);
		// String sth = compressed.substring(compressed.length() * 2 / 3,
		// compressed.length());
		// System.out.println("\n" + so + "\n" + st + "\n" + sth);
		// System.out.println("\n" + binaryToDecimal(so));
		// System.out.println(binaryToDecimal(st));
		// System.out.println(binaryToDecimal(sth));
		// System.out.println("92858834340463540056284030".length());
		// System.out.println("45039230".length());
		//
		// System.out.println(decimalToBinary(binaryToDecimal(compressed)));
		//
		// String decompressed = decompress(compressed);
		// System.out.println("The original text used a total of " +
		// decompressed.length() + " characters");
		// System.out.println(decompressed);

		// saveToFile(compressed);

		// ------------------------------------------------
		// System.out.println("------------------------------------------");
		//
		// byte[] personByteArray = compressed.getBytes();
		// byte[] zipPersonByteArray = compress(personByteArray);
		// System.out.println("after compress:" + new String(zipPersonByteArray));
		// System.out.println("after compress:" + zipPersonByteArray.length);
		//
		// System.out.println("------------------------------------------");
		// System.out.println("随机数:" + Ramdata.ramdaSw(33));
		// 100110001001011010000000//最小8位 24
		System.out.println("101111101011110000011111111".length());// 最大8位 27
		System.out.println("101111101011110000100000000".length());// 最小9位 27

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				getYas();
			}
		}, 100, 1000);

	}

	public static void getYas() {
		String text = Ramdata.ramdaSw(33);

		System.out.println("随机数:" + text + "\t" + text.length());

		// Count the frequency of all the characters
		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();

		for (int i = 0; i < text.length(); i++) {
			char a = text.charAt(i);

			if (dict.containsKey(a))
				dict.put(a, dict.get(a) + 1);
			else
				dict.put(a, 1);
		}

		// Create a forest (group of trees) by adding all the nodes to a priority queue
		q = new PriorityQueue<Node>(100, new FrequencyComparator());
		int n = 0;

		for (Character c : dict.keySet()) {
			q.add(new Node(c, dict.get(c)));
			n++;
		}

		// Identify the root of the tree
		Node root = huffman(n);

		// Build the table for the variable length codes
		buildTable(root);

		String compressed = compress(text);
		System.out.println("The compressed used a total of " + compressed.length() + " bits");
		System.out.println(compressed);
		String s = "";
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < compressed.length(); i++) {
			// System.out.print(compressed.charAt(i));
			s += compressed.charAt(i);
			if (s.equals("01")) {
				s = "3";
				sBuilder.append(s);
				// aStrings[i][0] = s;
				s = "";
			}
			if (s.equals("10")) {
				s = "1";
				sBuilder.append(s);
				s = "";
			}
			if (s.equals("00")) {
				s = "2";
				sBuilder.append(s);
				// aStrings[i][0] = s;
				s = "";
			}
			if (s.equals("11")) {
				s = "0";
				sBuilder.append(s);
				s = "";
			}
		}
		// 11111111111111111111111111 26 67108863
		System.out.println(sBuilder.toString());// 打印第一次过滤数据
		// 220313210010133133313121020323301013032200211300
		yaStrTwo(sBuilder.toString());

		String[][] aStrings = new String[compressed.length()][1];
		for (int i = 0; i < sBuilder.length(); i++) {
			if (sBuilder.charAt(i) == '2' || sBuilder.charAt(i) == '3') {
				aStrings[i][0] = String.valueOf(sBuilder.charAt(i));
			}
		}
		System.out.println(aStrings);// 数组存放除0和1外的数字
		// 打印数组
		for (int i = 0; i < compressed.length(); i++) {
			if (aStrings[i][0] != null) {
				System.out.print(i + ">" + aStrings[i][0] + "|");
			}
		}
		System.out.println("------------");
		for (int i = 0; i < compressed.length(); i++) {
			if (aStrings[i][0] != null) {
				System.out.print(aStrings[i][0]);
			}
		}
		String so = sBuilder.toString().replace("2", "").replace("3", "");
		System.out.println("\n" + so);
		// 1001100110011111001111101111111000011101101
		BigInteger yas = binaryToDecimal(so);
		System.out.println("压缩后:" + yas + "\t" + yas.toString().length() + "位");
	}

	/**
	 * @Title: yaStrTwo @Description: TODO(这里用一句话描述这个方法的作用) @param: @return:
	 * void @throws
	 */

	private static void yaStrTwo(String strs) {
		// TODO Auto-generated method stub
		String s = "";
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < strs.length(); i++) {
			// System.out.print(compressed.charAt(i));
			s += strs.charAt(i);
			if (s.equals("01")) {
				s = "3";
				sBuilder.append(s);
				// aStrings[i][0] = s;
				s = "";
			}
			if (s.equals("10")) {
				s = "1";
				sBuilder.append(s);
				s = "";
			}
			if (s.equals("00")) {
				s = "2";
				sBuilder.append(s);
				// aStrings[i][0] = s;
				s = "";
			}
			if (s.equals("11")) {
				s = "0";
				sBuilder.append(s);
				s = "";
			}
		}
	}

	// This method builds the tree based on the frequency of every characters
	public static Node huffman(int n) {
		Node x, y;

		for (int i = 1; i <= n - 1; i++) {
			Node z = new Node();
			z.left = x = q.poll();
			z.right = y = q.poll();
			z.freq = x.freq + y.freq;
			q.add(z);
		}

		return q.poll();
	}

	// This method builds the table for the compression and decompression
	public static void buildTable(Node root) {
		charToCode = new HashMap<Character, String>();
		codeToChar = new HashMap<String, Character>();

		postorder(root, new String());
	}

	// This method is used to traverse from ROOT-to-LEAVES
	public static void postorder(Node n, String s) {
		if (n == null)
			return;

		postorder(n.left, s + "0");
		postorder(n.right, s + "1");

		// Visit only nodes with keys
		if (n.alpha != '\0') {
			// System.out.println("\'" + n.alpha + "\' -> " + s);
			charToCode.put(n.alpha, s);
			codeToChar.put(s, n.alpha);
		}
	}

	// This method assumes that the tree and dictionary are already built
	public static String compress(String s) {
		String c = new String();

		for (int i = 0; i < s.length(); i++)
			c = c + charToCode.get(s.charAt(i));

		return c;
	}

	// This method assumes that the tree and dictionary are already built
	public static String decompress(String s) {
		String temp = new String();
		String result = new String();

		for (int i = 0; i < s.length(); i++) {
			temp = temp + s.charAt(i);

			if (codeToChar.containsKey(temp)) {
				result = result + codeToChar.get(temp);
				temp = new String();
			}
		}

		return result;
	}

	public static void saveToFile(String l) throws FileNotFoundException {
		PrintWriter oFile = new PrintWriter("output.txt");

		for (String s : codeToChar.keySet())
			oFile.println(s + "->" + codeToChar.get(s));

		oFile.println(l);

		oFile.close();
	}

	/**
	 * @Description: ʮ����ת���ɶ����� ()
	 * @param decimalSource
	 * @return String
	 */
	public static String decimalToBinary(BigInteger decimalSource) {
		// BigInteger bi = new BigInteger(String.valueOf(decimalSource));
		// //ת����BigInteger����
		return decimalSource.toString(2); // ����2ָ������ת����X���ƣ�Ĭ��10����
	}

	/**
	 * @Description: ������ת����ʮ����
	 * @param binarySource
	 * @return int
	 */
	public static BigInteger binaryToDecimal(String binarySource) {
		BigInteger bi = new BigInteger(binarySource, 2); // ת��ΪBigInteger����
		// return Integer.parseInt(bi.toString()); //ת����ʮ����
		return bi; // ת����ʮ����
	}

	/**
	 * 
	 * @description 关闭数据流
	 * @param oStream
	 * 
	 */
	public static void closeStream(Closeable oStream) {
		if (null != oStream) {
			try {
				oStream.close();
			} catch (IOException e) {
				oStream = null;// 赋值为null,等待垃圾回收
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @description 将byte 数组压缩
	 * @param bt
	 * @return
	 */
	public static byte[] compress(byte[] bt) {
		// 将byte数据读入文件流
		ByteArrayOutputStream bos = null;
		GZIPOutputStream gzipos = null;
		try {
			bos = new ByteArrayOutputStream();
			gzipos = new GZIPOutputStream(bos);
			gzipos.write(bt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStream(gzipos);
			closeStream(bos);
		}
		return bos.toByteArray();
	}

}

class Node {

	public char alpha;
	public int freq;
	public Node left, right;

	public Node(char a, int f) {
		alpha = a;
		freq = f;
	}

	public Node() {

	}

	public String toString() {
		return alpha + " " + freq;
	}

}

class FrequencyComparator implements Comparator<Node> {

	public int compare(Node a, Node b) {
		int freqA = a.freq;
		int freqB = b.freq;

		return freqA - freqB;
	}

}