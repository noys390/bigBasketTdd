package basketPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.base.basketBase;

public class inputFormsPages extends basketBase {
	
	//Dropdown page
	@FindBy(partialLinkText = "Input Forms")
	WebElement InputFormsLink;
	
	@FindBy(linkText = "Select Dropdown List")
	WebElement dropdownListLink;
	
	@FindBy(id = "select-demo")
	WebElement ddDays;
	
	@FindBy(css="p.selected-value")
	WebElement ddDaysMsg;
	
	// drop down mult select
	
	@FindBy(id = "multi-select")
	WebElement ddCities;
	
	@FindBy(id = "printMe")
	WebElement frstSelBttn;
	
	@FindBy(id = "printAll")
	WebElement allSelBttn;
	
	@FindBy(css="p.getall-selected")
	WebElement ddCitiesMsg;
	
	// Ajax form submit
	@FindBy(linkText = "Ajax Form Submit")
	WebElement ajaxFormLink;
	
	@FindBy(id = "title")
	WebElement nameTxt;
	
	@FindBy(id = "description")
	WebElement commntTxtBx;
	
	@FindBy(id = "btn-submit")
	WebElement submitBttn;
	
	@FindBy(id = "submit-control")
	WebElement ajaxsubmitMsg;
	
	//Jquery Dropdown page
	@FindBy(linkText = "JQuery Select dropdown")
	WebElement JQuerydropdownLink;
	
	@FindBy(id = "select2-country-container")
	WebElement selCountry;
	
	
	// Variables
	
	// drop down variables
	public List<String> strDayLabel = new ArrayList<String>();
	public List<String> strCityLabel = new ArrayList<String>();
	public String frstCityMsg;
	public String allCityMsg;
	
	// ajax form variables
	public String strAjaxMsg;
	public String strReqFieldStyle;
	public String strBefReqFieldStyle;
		
	public inputFormsPages(){
		PageFactory.initElements(driver, this);
	}

   // methods of Drp down page
	
	public void navgToDrpDwnPage(){
		InputFormsLink.click();
		dropdownListLink.click();
	  } 
	
	public void selectDrpDwn(String dd0, String dd1, int dd2){
		Select day = new Select(ddDays);
		day.selectByValue(dd0);
		strDayLabel.add(ddDaysMsg.getText()) ;
		day.selectByVisibleText(dd1);
		strDayLabel.add(ddDaysMsg.getText()) ;
		day.selectByIndex(dd2);
		strDayLabel.add(ddDaysMsg.getText()) ;		
	}
	
	public void getAllCities(){
		Select city = new Select(ddCities);
		List<WebElement> optionsList = city.getOptions();
        System.out.println("The options list : ");
        for (WebElement option : optionsList) {
                 System.out.println(option.getText());
        }
	}
	
	
	public void selMultiDrpDwn(String xCity0, String xCity1, String xCity2){
		String strCityXpath1 ="//select[@id='multi-select']/option[@value='"+xCity1+"']";
		String strCityXpath2 ="//select[@id='multi-select']/option[@value='"+xCity2+"']";
		Select city = new Select(ddCities);
		city.selectByValue(xCity0);
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL)
		.click(driver.findElement(By.xpath(strCityXpath1)))
		.click(driver.findElement(By.xpath(strCityXpath2)))
		.keyUp(Keys.CONTROL).build().perform();
		frstSelBttn.click();
		frstCityMsg = ddCitiesMsg.getText();
				allSelBttn.click();
		allCityMsg = ddCitiesMsg.getText();	
	}
	
	// methods of Ajax form submit
	
	public void navgToAjaxForm(){
		InputFormsLink.click();
		ajaxFormLink.click();
	}
	
	public void AjaxFormInput(){
		nameTxt.sendKeys("this is a an ajax form");
		commntTxtBx.sendKeys("this is the commnet");
		submitBttn.click();
		strAjaxMsg=ajaxsubmitMsg.getText();
		System.out.println("The first ajx msg value : "+strAjaxMsg);
		strBefReqFieldStyle = nameTxt.getAttribute("style");
		driver.navigate().refresh();
		submitBttn.click();
		strReqFieldStyle = nameTxt.getAttribute("style");
				
	}	

}