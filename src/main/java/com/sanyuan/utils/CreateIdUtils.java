package com.sanyuan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateIdUtils {
    private static boolean tmpIDlocked = false;
    
    
	public static long getId(){
		long tmpID = 0;
        long ltime = 0;
        while (true){
            if(tmpIDlocked == false){
                tmpIDlocked = true;
                //当前：（年、月、日、时、分、秒、毫秒）*10000
                ltime = Long.valueOf(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()).toString());
                if(tmpID < ltime){
                    tmpID = ltime;
                }else {
                    tmpID = tmpID + 1;
                    ltime = tmpID;
                }
                tmpIDlocked = false;
                return ltime;
            }
        }
    }
	
	public static int createId(){
		int tmpID = 0;
		int ltime = 0;
		while (true){
			if(tmpIDlocked == false){
				tmpIDlocked = true;
				ltime = Integer.valueOf(new SimpleDateFormat("mmssSSS").format(new Date()).toString());
				if(tmpID < ltime){
					tmpID = ltime;
				}else {
					tmpID = tmpID + 1;
					ltime = tmpID;
				}
				tmpIDlocked = false;
				return ltime;
			}
		}
	}
	/*
	 * public static void main(String[] args) { for (int i = 0; i < 10; i++) {
	 * System.out.println(createId()); } }
	 */
}
