// Idea and how to implement : 12 10

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class DriverClass {
	public static int resultFlag;

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {

		String testDataPath = "C:/Users/Abhis_lw0caw1/Google Drive/Aug 10 2016/Read only/Framework/TestSuit.xls";

		String[][] recData = ReusableMethods.readSheet(testDataPath, "Sheet1");

		for(int i =1; i<recData.length; i++){
			resultFlag = 0;
			if(recData[i][1].equalsIgnoreCase("Y")){

				String TestCaseName = recData[i][2];

				/*Java Reflection or Reflexive API*/
				Method testCase = AutomationScripts.class.getMethod(TestCaseName, null);
				testCase.invoke(testCase, args);
				
				if(resultFlag == 0){
					ReusableMethods.writeXlSheet(testDataPath, "Sheet1", i, 3, "Pass");
				}else{
					ReusableMethods.writeXlSheet(testDataPath, "Sheet1", i, 3, "Fail");
				}
				
			}else{
				System.out.println("Row no:" + i + " Test Script did not execute");
				ReusableMethods.writeXlSheet(testDataPath, "Sheet1", i, 3, "NA");
			}
			
			


		}









		/*Java Reflection or Reflexive API*/
		//Method ts = AutomationScripts.class.getMethod(automationScript);
		//ts.invoke(ts);



		//		AutomationScripts.testScript1();
		//		AutomationScripts.testScript2();
		//		AutomationScripts.testScript3();
		//		AutomationScripts.testScript4();


	}
}
