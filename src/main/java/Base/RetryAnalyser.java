package Base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	//For Initial Count
	int retryCount =0;
	//For Max count to retry fail test scripts
	int maxCount =1;
	@Override
	public boolean retry(ITestResult result) {
		
		// TODO Auto-generated method stub
		//if(!result.isSuccess())
		//{
			if(retryCount <maxCount ) {
				retryCount++;
				return true;
			}
		//}
		return false;
	}
	

}
