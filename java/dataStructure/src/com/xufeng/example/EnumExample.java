package com.xufeng.example;

interface Constants {
    public static final int GUANG = 1;
    public static final int SINA = 2;
    public static final int TENCENT = 3;
   
    public enum gender {
           male,  /** 男 **/
           female,       /** 女 **/
           unknown       /** 未知 **/
    }
}

public class EnumExample {
	public static void main(String[] args) {
		System.out.println(Constants.SINA);
		System.out.println(Constants.gender.male);
	}
}
