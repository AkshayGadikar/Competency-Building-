package com.zensar.cb.utility;

import java.util.StringTokenizer;


public class StringParser {
	public static String BindString(String separator,String arrayOfString[])
	{
		String BuidString="";
		for (String str : arrayOfString) {
			BuidString=BuidString+str+separator;
		}
		return BuidString;
	}
	public static String BindLong(String separator,long arrayofLong[])
	{
		String BuidString="";
		for (long  lng: arrayofLong) {
			BuidString=BuidString+lng+separator;
		}
		return BuidString;
	}
	public static String Bindint(String separator,int arrayofint[])
	{
		String BuidString="";
		for (long  lng: arrayofint) {
			BuidString=BuidString+lng+separator;
		}
		return BuidString;
	}
	public static String[] ReleaseintoArrayOfStrings(String separator,String string)
	{
		StringTokenizer tokenizer=new StringTokenizer(string,separator);
		int length=tokenizer.countTokens();
		String keywords[]= new String[length];
		for(int i=0;i<length;i++)
		{
			keywords[i]=tokenizer.nextToken();
		}
		return keywords;
	}
	public static long[] ReleaseintoArrayOfLongs(String separator,String string)
	{
		try {
			StringTokenizer tokenizer=new StringTokenizer(string,separator);
			int length=tokenizer.countTokens();
			long keywords[]=new long[length];
			for(int i=0;i<length;i++)
			{
				keywords[i]=Long.parseLong(tokenizer.nextToken());
			}
			return keywords;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	public static int[] ReleaseintoArrayOfint(String separator,String string)
	{
		try {
			StringTokenizer tokenizer=new StringTokenizer(string,separator);
			int length=tokenizer.countTokens();
			int keywords[]=new int[length];
			for(int i=0;i<length;i++)
			{
				keywords[i]=Integer.parseInt(tokenizer.nextToken());
			}
			return keywords;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
