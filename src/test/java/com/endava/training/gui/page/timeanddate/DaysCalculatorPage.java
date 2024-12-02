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

    public void clickCalendar(WebElement calendar){
        actor.click(calendar);
    }

    public void clickDateCalendar(WebElement date){
        actor.click(date);
    }

    public void clickCalculateDuration(){
        actor.click(calculateDurationButton);
    }

    public String getResult(){
        return actor.getText(resultTitle);
    }

    public void calculateDuration(){
        clickCalendar(startDateCalendar);
        clickDateCalendar(startDateNumber);
        clickCalendar(endDateCalendar);
        clickCalendar(endDateNumber);
        clickCalculateDuration();
    }

}
