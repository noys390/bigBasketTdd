package basketPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.base.basketBase;

public class inputElmntsPage extends basketBase {
	
	// Page OR
	
	// Simple Form Demo Page -----------
	
	@FindBy(partialLinkText = "Input Forms")
	@CacheLookup
	WebElement InputFormsLink;
	
	@FindBy(partialLinkText = "Simple Form Demo")
	@CacheLookup
	WebElement SimpleFormDemoLink;
	
	@FindBy(css="input[id=user-message]")
	WebElement msgBox;
	
	@FindBy(css=".btn-default")
	WebElement msgButton;
	
	@FindBy(css="div[id=user-message]")
	WebElement msgFixed;
	
	@FindBy(xpath="//span[@id='display']")
	WebElement msgDisplay;
	
	@FindBy(id="sum1")
	@CacheLookup
	WebElement sumBox1;
	
	@FindBy(id="sum2")
	@CacheLookup
	WebElement sumBox2;
	
	@FindBy(xpath="//*[@onclick='return total()']")
	@CacheLookup
	WebElement sumButton;
	
	@FindBy(xpath="//span[@id='displayvalue']")
	@CacheLookup
	WebElement sumTotal;
	
	
 //CheckboxDemo------------------------------------
	
	@FindBy(partialLinkText = "Checkbox Demo")
	WebElement checkBoxDmLink;
	
	@FindBy(id="isAgeSelected")
	WebElement chkBx;
	
	@FindBy(id="txtAge")
	WebElement msgChkBx;
	
	@FindBy(xpath="//label[text()='Option 1']/input[@type='checkbox']")
	WebElement chk1;
	
	@FindBy(xpath="//label[text()='Option 2']/input[@type='checkbox']")
	WebElement chk2;
	
	@FindBy(xpath="//label[text()='Option 3']/input[@type='checkbox']")
	WebElement chk3;
	
	@FindBy(xpath="//label[text()='Option 4']/input[@type='checkbox']")
	WebElement chk4;
	
	@FindBy(id="check1")
	WebElement chkBttn;
	
	// Radio Button Demo -----------  
	
	@FindBy(linkText = "Radio Buttons Demo")
	WebElement RadioBtnDmLink;
	
	@FindBy(css="input[type=radio][value=Male][name=optradio]")
	WebElement Mrd;
	
	@FindBy(css="input[type=radio][value=Female][name=optradio]")
	WebElement Frd;
	
	@FindBy(id="buttoncheck")
	WebElement getRdBttn;
	
	@FindBy(css="p.radiobutton")
	WebElement rdOutLabel;
	
	//------
	@FindBy(css="input[type=radio][value=Male][name=gender]")
	WebElement Mrd0;
	
	@FindBy(css="input[type=radio][value=Female][name=gender]")
	WebElement Frd0;
	
	@FindBy(css="input[type=radio][value='0 - 5']")
	WebElement AgeCat1;
	
	@FindBy(css="input[type=radio][value='5 - 15']")
	WebElement AgeCat2;
	
	@FindBy(css="input[type=radio][value='15 - 50']")
	WebElement AgeCat3;
	
	@FindBy(css="button[onclick='getValues();']")
	WebElement getValBtn;
	
	@FindBy(css="p.groupradiobutton")
	WebElement getValOutLabel;
	

	
	// public variables
	public String testLabel2;
	public String testadd;
	WebDriverWait wait;
	
	// Checkbox Demo variables
	public String strChkBx;
	public Boolean selChkBx1;
	public Boolean selChkBx2;
	public Boolean selChkBx3;
	public Boolean selChkBx4;
	public String chkBttnLabel;
	
	// Radio Button Demo Page variables  
    public String[] strChkBttnLabel = new String[3];
    public String rdVal1;
    public String[] strChkAgeLabel = new String[5];
	


 // Simple Form Demo Page Functions-----------
  public inputElmntsPage() {
	PageFactory.initElements(driver, this);
  }


  public void navgToSmplForm(){
	InputFormsLink.click();
	SimpleFormDemoLink.click();	
  }

   public void enterMsg(String str){
	   navgToSmplForm();
	   msgBox.sendKeys(str);
	   try {
		Thread.sleep(1000);
       msgButton.click();;
	   String testLabel1 = msgFixed.getText();
	   	   System.out.println("The label given here is "+testLabel1);
	   Thread.sleep(5000);
	   testLabel2 = msgDisplay.getText();
	   System.out.println("The label given here is "+testLabel2);
		 } catch (InterruptedException e) {}
      }
   

       public void addCheck(String str1, String str2) {
    	   sumBox1.sendKeys(str1);
    	   sumBox2.sendKeys(str2); 
    	   sumButton.click();
  	       try {
			Thread.sleep(1000);
		 } catch (InterruptedException e) {}
  	       testadd = sumTotal.getText();	
       }
       
    // Checkbox Demo Page Functions-----------    
       
       public void navgChkboxDm(){
    	     InputFormsLink.click();
    		checkBoxDmLink.click();	
    	}
       
       public void msgChkboxDm(){
    	   navgChkboxDm();
    	   chkBx.click();
    	   wait = new WebDriverWait (driver, 50);
    	   strChkBx = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtAge"))).getText();      	   
       }
       
       public void allChkboxOn(){
    	    navgChkboxDm();
    	   if(!chk1.isSelected() ) {
    		   chkBttn.click();
    	   }
    	   chkBttnLabel = chkBttn.getAttribute("value");
    	   System.out.println("The current label is "+ chkBttnLabel);
    	   selChkBx1 = chk1.isSelected();
    	   selChkBx2 = chk2.isSelected();
    	   selChkBx3 = chk3.isSelected();
    	   selChkBx4 = chk4.isSelected();    	   
       }
       
       public void unCheckAll(){
    	   navgChkboxDm();
    	   chkBttnLabel = chkBttn.getAttribute("value");
    	   System.out.println("The current label is "+ chkBttnLabel);
    	   if(chkBttnLabel.equals("Check All") ) {
    		   chkBttn.click();
    	   }
    	   //chkBttn = driver.findElement(By.id("check1"));
    	   chkBttnLabel = chkBttn.getAttribute("value");
    	   System.out.println("The current label is "+ chkBttnLabel);
    	   chkBttn.click(); //To unselect all
    	       	   selChkBx1 = chk1.isSelected();
    	   selChkBx2 = chk2.isSelected();
    	   selChkBx3 = chk3.isSelected();
    	   selChkBx4 = chk4.isSelected();    	   
       }
       
    // Radio Button Demo Page Functions-----------  
       
       public void navgRdBtnDm(){
  	     InputFormsLink.click();
  	   RadioBtnDmLink.click();	
  	   }
       
      
       public void chkRdBtnMsg(){
    	 navgRdBtnDm();
    	 getRdBttn.click();
    	 strChkBttnLabel[0] = rdOutLabel.getText();
    	 Mrd.click();
    	 getRdBttn.click();
    	 strChkBttnLabel[1] = rdOutLabel.getText();
    	 Frd.click();
    	 getRdBttn.click();
    	 strChkBttnLabel[2] = rdOutLabel.getText(); 
    	 // validating the values
    	 for (int i=0; i<strChkBttnLabel.length; i++) {
    		    System.out.println( strChkBttnLabel[i]);
    		}
    	 }
       
       
       public void chkRdBtnAge(){  
    	 navgRdBtnDm();
    	 Mrd0.click();
    	 AgeCat1.click();
    	 getValBtn.click();
    	 strChkAgeLabel[0]=getValOutLabel.getText();
    	 Frd0.click();
    	 getValBtn.click();
    	 strChkAgeLabel[1]=getValOutLabel.getText();
    	 AgeCat2.click();
    	 getValBtn.click();
    	 strChkAgeLabel[2]=getValOutLabel.getText();
    	 driver.navigate().refresh();
    	 AgeCat3.click();
    	 getValBtn.click();
    	 strChkAgeLabel[3]=getValOutLabel.getText();  
    	 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
    	 for (int i=0; i<strChkAgeLabel.length; i++) {
 		    System.out.println( strChkAgeLabel[i]);
 		   }  
        }  
        
       

}
