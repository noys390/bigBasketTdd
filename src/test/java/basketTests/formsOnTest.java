package basketTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basketPage.inputFormsPages;
import qa.base.basketBase;

public class formsOnTest extends basketBase {
//public class launchURL extends basketMgrBase {
	
	inputFormsPages ifp;
		
	public formsOnTest(){
		initProp();
	}
	
   @BeforeMethod
	public void launch(){
	initBrowser();
	driver.get("https://www.seleniumeasy.com/test/");
	}
  
  // drop down test
   @Test(enabled=false)
   public void selectDrpDwnTest(){
	   ifp =new inputFormsPages();
	   ifp.navgToDrpDwnPage();
	   String dS ="Day selected :- ";
	   ifp.selectDrpDwn("Sunday", "Thursday", 3);
	   Assert.assertEquals((dS+"Sunday"),ifp.strDayLabel.get(0));
	   Assert.assertEquals((dS+"Thursday"),ifp.strDayLabel.get(1));
	   Assert.assertEquals((dS+"Tuesday"),ifp.strDayLabel.get(2));
   }
  
   // drop down multi select test 
   @Test(enabled=false)
   public void selMultiDrpDwnTest(){
	   ifp =new inputFormsPages();
	   ifp.navgToDrpDwnPage();
	   ifp.getAllCities();
	   String[] strCities = new String[]{"Pennsylvania","Ohio","California"};
	   System.out.println("The first array value : "+strCities[0]);
	   ifp.selMultiDrpDwn(strCities[0],strCities[1],strCities[2]);
	   Assert.assertEquals(("First selected option is : "+strCities[0]),ifp.frstCityMsg);
	   Assert.assertEquals(("Options selected are : "+strCities[0]+","+strCities[1]+","+strCities[2]),ifp.allCityMsg);
   }
   
   // ajax submit form test
   @Test(enabled=true)
   public void AjaxFormInputTest(){
	   ifp =new inputFormsPages();
	   ifp.navgToAjaxForm();
	   ifp.AjaxFormInput();
	   Assert.assertEquals("Ajax Request is Processing!",ifp.strAjaxMsg);
	   // testing mandatory field
	   Assert.assertEquals("",ifp.strBefReqFieldStyle);
	   Assert.assertEquals("border: 1px solid rgb(255, 0, 0);",ifp.strReqFieldStyle);	   
   }
   
   
   @AfterMethod
	public void closing(){
	driver.quit();
	}
  
}