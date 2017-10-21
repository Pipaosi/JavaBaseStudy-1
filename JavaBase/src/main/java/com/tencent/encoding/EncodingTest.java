package com.tencent.encoding;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * �����ȡ��¼̬��ʱ��һ���ֽ����飬ת����String֮����ȡ�ֽ����飬������֤����ͨ����
 * ���������ַ����������
 * ���С����ܽ���ַ�����ܵ�λ��http://km.oa.com/articles/show/289612?kmref=search&from_page=1&no=7
 * @author ewanzhao
 *
 */
public class EncodingTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		testByteArray();    //���Խ�byte[] ת����String����ȡbyte[]
		System.out.println("###############################");
		
		stringTest("hello,world");    //ASCII�ַ�
		System.out.println("###############################");
		
		stringTest("��Ѷ");	//�����ַ�
		System.out.println("###############################");
	
	}

	private static void testByteArray() throws UnsupportedEncodingException {

		byte[] bytes = new byte[] { 50, 0, -1, 28, -24 };
		testByteArray(bytes, "UTF-8");
		testByteArray(bytes, "ISO-8859-1");
		testByteArray(bytes, "GBK");
		testByteArray(bytes, "US-ASCII");
		
	}
	
	private static void testByteArray(byte[] bytes, String encoding) throws UnsupportedEncodingException {
		String sendString=new String( bytes ,encoding);
		byte[] bytes1 = sendString.getBytes(encoding);
		System.out.print("encoding:"+encoding+":");
		printByte(bytes1);
		System.out.println();
	}

	private static void stringTest(String str) throws UnsupportedEncodingException {
		System.out.println("str:"+str);
		String strEncoding = Charset.defaultCharset().name();     //��ȡ�ļ��ַ�����
		System.out.println("default encoding:"+ strEncoding);    //�޸��ļ����룬���Ե��������Ĭ�ϱ���
		str2bytes(str);    //ʹ���ļ�Ĭ�ϱ���
		str2bytes(str, "GB2312");
		str2bytes(str, "UTF-8");
		str2bytes(str, "UTF-16");
		str2bytes(str, "Unicode");	
	}
	
	
	private static void str2bytes(String str, String encoding) throws UnsupportedEncodingException {
		byte[] byteStr = str.getBytes(encoding);
		System.out.println("encoding:" + encoding + " byte size:" +byteStr.length);
		printByte(byteStr);		
	}
	
	private static void str2bytes(String str) throws UnsupportedEncodingException {
		byte[] byteStr = str.getBytes();
		System.out.println(" byte size:" +byteStr.length);
		printByte(byteStr);		
	}

	public static void printByte(byte[] bytestr) {
		for(int i =0; i < bytestr.length; i++) {
			System.out.print(String.format("%02x", bytestr[i]) +" ");
			
		}
		System.out.println();
	}

}
