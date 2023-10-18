package com.dafzaportal.utils;

import java.util.Random;

public class Utility {
	


	    // Define characters from which to generate the random string
	    private static final String CHARACTERS = "0123456789";

	    public static String generateRandomString(int length) {
	        if (length <= 0) {
	            throw new IllegalArgumentException("Length must be greater than zero.");
	        }

	        Random random = new Random();
	        StringBuilder sb = new StringBuilder();
	        String str = null;

	        for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(CHARACTERS.length());
	            char randomChar = CHARACTERS.charAt(randomIndex);
	            str = "TestCompany-"+sb.append(randomChar);
	           
	        }

	        return str.toString();
	    }
	    
	    public static void main(String args[])
	    
	    {
	    	System.out.println(generateRandomString(3));
	    	
	    }





}
