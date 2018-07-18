package com.leelen.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class WriteStringToTxt {

	public void WriteStringToFile(String filePath) {
		try {
			File file = new File(filePath);
			PrintStream ps = new PrintStream(new FileOutputStream(file));
			ps.println("http://www.jb51.net");// 往文件里写入字符串
			ps.append("http://www.jb51.net");// 在已有的基础上添加字符串
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void WriteStringToFile2(String filePath) {
		try {
			FileWriter fw = new FileWriter(filePath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append("在已有的基础上添加字符串");
			bw.write("abc\r\n ");// 往已有的文件上添加字符串
			bw.write("def\r\n ");
			bw.write("hijk ");
			bw.close();
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void WriteStringToFile3(String filePath) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(filePath));
			pw.println("abc ");
			pw.println("def ");
			pw.println("hef ");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void WriteStringToFile4(String filePath) {
		try {
			RandomAccessFile rf = new RandomAccessFile(filePath, "rw");
			rf.writeBytes("op\r\n");
			rf.writeBytes("app\r\n");
			rf.writeBytes("hijklllll");
			rf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void WriteStringToFile5(String filePath) {
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			String s = "http://www.jb51.netl\nbvb";
			fos.write(s.getBytes());
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void method1() {
		FileWriter fw = null;
		try {
			// 如果文件存在，则追加内容；如果文件不存在，则创建文件
			File f = new File("E:\\link.txt");
			fw = new FileWriter(f, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println("追加内容");
		pw.flush();
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void method2(String file, String conent) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			out.write(conent + "\r\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void method3(String fileName, String content) {
		try {
			// 打开一个随机访问文件流，按读写方式
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			randomFile.writeBytes(content + "\r\n");
			randomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		char a = 60000;
		System.out.println("a:" + a);
		String filePath = "E:\\link.txt";
		// new WriteStringToTxt().WriteStringToFile(filePath);
		// new WriteStringToTxt().WriteStringToFile2(filePath);
		// new WriteStringToTxt().WriteStringToFile3(filePath);
		// new WriteStringToTxt().WriteStringToFile4(filePath);
		WriteStringToTxt writeStringToTxt = new WriteStringToTxt();
		writeStringToTxt.method1();
		writeStringToTxt.method2("E:\\dd.txt", "记录\nbngvb\n--------------\nxgdfgdfdyyy");
		// writeStringToTxt.method3("E:\\dd.txt", "fbhfghb");
		writeStringToTxt.WriteStringToFile5(filePath);
	}
}