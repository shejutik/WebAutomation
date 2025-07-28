package com.shejuti.utils;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name = "contactData")
    public static Object[][] getData() {
        return new Object[][] {
            {"Daniel Lewis", "shejutikhan+1@gmail.com", "This is a test contact message"},
            {"Stephen Adams", "shejutikhan+2@gmail.com", "This is a test contact message"},
            {"Gabriel Baker", "shejutikhan+3@gmail.com", "This is a test contact message"}
        };
    }
	
}
