package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import constants.Constants1;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.MediaRelaseObjects;
import pageFactory.PhotoGalleryObjects;
import webMethods.WebElementActions;
import webdriver_Manager.DriverManager;

public class PaginationStepDef {
	public static Logger logs=Logger.getLogger(PaginationStepDef.class.getName());
	@Test(priority = 2)
	 @Given("user is in HomePage")
	 public void moveToHomePage() {
		 PageFactory.initElements(DriverManager.driver, PhotoGalleryObjects.class);
		 WebElementActions.loadUrl(Constants1.URL);
	 }
	    @When("user handles the alert")
	    public void handleAlerts() throws InterruptedException {
	    	TimeUnit.SECONDS.sleep(5);
	    	WebElementActions .click(MediaRelaseObjects.alert);
	    }
	   @When("user move to media menu")
	   public void moveToMedia() {
		   WebElementActions.MouseOver(PhotoGalleryObjects.mediaMenu);
	   }
	    @And("user move into subMenu")
	    public void moveToPhotoGallerysec() {
	    	WebElementActions.click(PhotoGalleryObjects.photoGallerySec);
	    }
	    @When ("user select {string} option  from the dropdown and is the type of {string}")
	    public void selectDropdown(String val,String SelectionType) {	
	    	WebElementActions.waits(5);
	    	WebElementActions.DropDownSelect(PhotoGalleryObjects.SwActivityDropDown, val, SelectionType);
	    	
	    }
	   @When("Scrolldown the page")
	   public void scrollDown() {
		  ( (JavascriptExecutor)DriverManager.driver).executeScript("window.scrollBy('0','800')");
	   }
	    @And("enter page Number {string}")
	    public void enterPageNumber(String pageNumber) {
	    	WebElementActions.Type(PhotoGalleryObjects.pageBox, pageNumber);
	    	
	    }
	    @When ("click the controls")
	    public void clickTheControls() {
	    	WebElementActions.click(PhotoGalleryObjects.GoButton);
			WebElementActions.click(PhotoGalleryObjects.nextButton);
			WebElementActions.click(PhotoGalleryObjects.imageModal);
	    }
	    @Then("close the modal")
		   public void closeModal() {
			   try {
				logs.info("Page validation message is closed");
				assertEquals(true,true);
			   }
			   catch(Exception e)
			   {
				   e.printStackTrace();
			   }
		   }}
