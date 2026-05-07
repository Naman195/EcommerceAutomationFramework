package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	
//	private static final int MAX_NUMBEROF_ATTEMPTS= Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "MAX_NUMBEROF_ATTEMPTS"));
	private static final int MAX_NUMBEROF_ATTEMPTS=  JSONUtility.readJson(Env.QA).getMAX_NUMBEROF_ATTEMPTS();

	private static int CURRENT_ATTEMPT=1;

	@Override
	public boolean retry(ITestResult result) {
		if(CURRENT_ATTEMPT <= MAX_NUMBEROF_ATTEMPTS) {
			CURRENT_ATTEMPT++;
			return true;
		}
		
		return false;
		
		
		
		
	}
	
	
	
	

}
