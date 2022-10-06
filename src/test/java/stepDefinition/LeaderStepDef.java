package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import constants.Constants1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.LeaderPage;
import webMethods.WebElementActions;
import webdriver_Manager.DriverManager;

public class LeaderStepDef {
	public static Logger logs=Logger.getLogger(LeaderStepDef.class.getName());
	@Test(priority = 4)
	 @Given("user is navigated to home page")  
	public void naviagte() {
		 
		
		 PageFactory.initElements(DriverManager.driver, LeaderPage.class);
		 WebElementActions.loadUrl(Constants1.URL);
		 WebElementActions.click(LeaderPage.alert);
		 
	 }
	    @When("mouse over to Leader Menu")
	    public void mouseOver() {
	    	logs.info("move to leader module");
	    	WebElementActions.MouseOver(LeaderPage.Leader);
	    }
	    @When("click the subLinks")
	    public void clickSubLinks() throws InterruptedException {
	    	logs.info("user clicks the links");
	    	TimeUnit.SECONDS.sleep(5);
	    	WebElementActions.MouseOverAndClick(LeaderPage.viceCheif);
	    	TimeUnit.SECONDS.sleep(5);
			WebElementActions.MouseOver(LeaderPage.Leader);
			TimeUnit.SECONDS.sleep(5);
			WebElementActions.MouseOverAndClick(LeaderPage.armyCommanders);
	    }
	    @Then("user can see the page")
	    public void VerifyPageBroken() {
	    	if(DriverManager.driver.getCurrentUrl().indexOf("404")>0)
	    		assertEquals(true, false);
	    	else
	    		assertEquals(true, true);
	    }
}
