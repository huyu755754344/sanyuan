package com.sanyuan.utils;

import java.util.Random;

public class CreateCodeUtils {
	private static Random random = new Random();
    
    public static String createCode() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }
}
