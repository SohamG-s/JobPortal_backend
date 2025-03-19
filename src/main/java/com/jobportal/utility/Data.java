package com.jobportal.utility;

public class Data {
	
public static String getMessageBody(String otp,String name) {
	String genOtp = Utilities.generateOTP(); // Generate OTP

	
	return "<html>" +
    "<body>" +
    "<h2 style='color:black;'>Hello, " + name + "!</h2>" +
    "<p>Your OTP code is: <b>" + otp + "</b></p>" +
    "<p>Please use this code to verify your email.</p>" +
    "<p>Best Regards,<br>Your Company</p>" +
    "</body>" +
    "</html>";

}
}
