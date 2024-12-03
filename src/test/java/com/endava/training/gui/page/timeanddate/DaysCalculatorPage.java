package com.endava.training.gui.page.timeanddate;

import com.endava.training.gui.actions.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DaysCalculatorPage {

    private final WebDriver driver;
    WebAction actor;

    @FindBy(xpath="//*[text()=\"Start Date\"]/ancestor::div[@class=\"five columns\"]//button[@class=\"btn-datepicker\"]")
    private WebElement startDateCalendar;

    @FindBy(xpath="//*[text()=\"End Date\"]/ancestor::div[@class=\"five columns\"]//button[@class=\"btn-datepicker\"]")
    private WebElement endDateCalendar;

    @FindBy(css="table.calendar > tbody > tr:nth-of-type(2) > td:first-of-type")
    private WebElement startDateNumber;

    @FindBy(css="table.calendar > tbody > tr:nth-of-type(3) > td:nth-of-type(7)")
    private WebElement endDateNumber;

    @FindBy(id="subbut2")
    private WebElement calculateDurationButton;

    @FindBy(xpath="//div[@class=\"bx-result\"]//h2[contains(text(),\"Result\")]")
    private WebElement resultTitle;

    public DaysCalculatorPage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void clickStartCalendar(){
        actor.click(startDateCalendar);
    }

    public void clickStartDateCalendar(){
        actor.click(startDateNumber);
    }

    public void clickEndCalendar(){
        actor.click(endDateCalendar);
    }

    public void clickEndDateCalendar(){
        actor.click(endDateNumber);
    }

    public void clickCalculateDuration(){
        actor.click(calculateDurationButton);
    }

    public String getResult(){
        return actor.getText(resultTitle);
    }

    public void calculateDuration(){
        System.out.println("click start Calendar");
        clickStartCalendar();
        System.out.println("click start Date Calendar");
        clickStartDateCalendar();
        System.out.println("click end Calendar");
        clickEndCalendar();
        System.out.println("click end Date Calendar");
        clickEndDateCalendar();
        System.out.println("click Calculate Duration");
        clickCalculateDuration();
    }

}
