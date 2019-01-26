package basketTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basketPage.inputElmntsPage;
import qa.base.basketBase;
import qa.base.dataSupplier;

public class inputElmntsTest extends basketBase {
//public class launchURL extends basketMgrBase {
	
	inputElmntsPage iep;
	dataSupplier dsp;
		
	public inputElmntsTest(){
		initProp();
	}
	
   @BeforeMethod
	public void launch(){
	initBrowser();
	driver.get("https://www.seleniumeasy.com/test/");		
	}
   
   //Simple Form Demo Page Tests---------
   
   @Test (enabled=false)
   public void msgEnterTest() throws InterruptedException{
	   String strTest="this is home";
	   iep=new inputElmntsPage();
	   iep.enterMsg(strTest);
	   Assert.assertEquals(strTest,iep.testLabel2);  
   } 
   
   @DataProvider(name="testdataset")
   public Object[][] getData() throws Exception{
	   String filePath = prop.getProperty("filePath");
	   String fileSheet = prop.getProperty("fileSheet");
	   String reqData[][] = new String[20][20];
	   dsp = new dataSupplier();
	   reqData = dsp.getDataSupply(filePath, fileSheet);
	   
   return reqData;
   }
   
//   @Test (enabled=true)
//   public void addCheckTest() {
//	   iep=new inputElmntsPage();
//	   iep.navgToSmplForm();
//	   String strAdd1="0";
//	   String strAdd2="0";	   
//	   iep.addCheck(strAdd1, strAdd2);
//	   Assert.assertEquals("0",iep.testadd);   
//	 }
   
   @Test (dataProvider="testdataset",enabled=false)
   public void addCheckTest(String a1, String a2, String a3) {
	   iep=new inputElmntsPage();
	   iep.navgToSmplForm();	   
	   iep.addCheck(a2, a1);
	   Assert.assertEquals(a3.substring(0, a3.length() - 2),iep.testadd);   
	 }
   
// Checkbox Demo Page Tests---------------
   
   @Test (enabled=false)
   public void msgChkboxDmTest() {
	   iep=new inputElmntsPage();
	   iep.msgChkboxDm();
	   Assert.assertEquals("Success - Check box is checked",iep.strChkBx);	  
   }
   
   @Test (enabled=false)
   public void allChkboxOnTest() {
	   iep=new inputElmntsPage();
	   iep.allChkboxOn();
	   Assert.assertTrue(iep.selChkBx1);
	   Assert.assertTrue(iep.selChkBx2);
	   Assert.assertTrue(iep.selChkBx3);
	   Assert.assertTrue(iep.selChkBx4);	  
   }
   
   @Test (enabled=false)
   public void unCheckAllTest() {
	   iep=new inputElmntsPage();
	   iep.unCheckAll();
	   Assert.assertFalse(iep.selChkBx1);
	   Assert.assertFalse(iep.selChkBx2);
	   Assert.assertFalse(iep.selChkBx3);
	   Assert.assertFalse(iep.selChkBx4);	
	   Assert.assertEquals("Uncheck All", iep.chkBttnLabel);
   }
   
   // Radio Button Demo Page tests-----------  
   
   @Test (enabled=false)
   public void chkRdBtnTest() {
	   iep=new inputElmntsPage();
	   iep.chkRdBtnMsg();
	   Assert.assertEquals("Radio button is Not checked", iep.strChkBttnLabel[0]);
	   Assert.assertEquals("Radio button 'Male' is checked", iep.strChkBttnLabel[1]);
	   Assert.assertEquals("Radio button 'Female' is checked", iep.strChkBttnLabel[2]);
   }
   
   @Test (enabled=false)
   public void chkRdBtnAgeTest(){
	   iep=new inputElmntsPage();
	   iep.chkRdBtnAge();
	   String[] strChkAgeLabelTest = new String[]
			   {"Sex : Male"+"\n"+ "Age group: 0 - 5",
			    "Sex : Female"+"\n"+"Age group: 0 - 5",
                "Sex : Female"+"\n"+"Age group: 5 - 15",
                "Sex :"+"\n"+"Age group: 15 - 50"
					   };
	   for (int i=0; i<strChkAgeLabelTest.length; i++) {
	   Assert.assertEquals(strChkAgeLabelTest[i],iep.strChkAgeLabel[i]);
	   }
   }
      
   
   @AfterMethod
	public void closing(){
	driver.quit();
	}
  
}
  
    

    

