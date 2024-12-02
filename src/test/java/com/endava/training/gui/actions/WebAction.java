package com.endava.training.gui.actions;

import com.endava.training.gui.utils.ScreenshotUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class WebAction {
    WebDriver driver;

    public WebAction(WebDriver driver){
        this.driver=driver;
    }

    public String getText(WebElement element) {
        String text = "";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
            WebElement clickableElement = wait.until(ExpectedConditions.visibilityOf(element));
            if (clickableElement.isDisplayed()) {
                text= clickableElement.getText();
            }
        }catch (NoSuchElementException e){
            takeScreenShot("error_getting_text_from_"+element);
            throw e;
        }
        return text;
    }

    public void click(WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            if (clickableElement.isDisplayed()) {
                clickableElement.click();
            }
        }catch (NoSuchElementException e){
            takeScreenShot("error_clicking_"+element);
            throw e;
        }
    }

    public void sendKeys(String input, WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
            WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
            if (visibleElement.isEnabled()) {
                visibleElement.clear();
                visibleElement.sendKeys(input);
            }
        }catch (NoSuchElementException e){
            takeScreenShot("error_typing_on_"+element);
            throw e;
        }
    }
    public void selectElement(String input, WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
            WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
            if (visibleElement.isEnabled()) {
                visibleElement.sendKeys(input);
            }
        }catch (NoSuchElementException e){
            takeScreenShot("error_typing_on_"+element);
            throw e;
        }
    }

    public void moveToElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
            WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
            if (visibleElement.isDisplayed()) {
                Actions actions = new Actions(driver);
                actions.moveToElement(visibleElement).perform();
            }
        } catch (NoSuchElementException e) {
            takeScreenShot("error_hovering_on_" + element);
            throw e;
        }
    }

    public void takeScreenShot(String message){
        ScreenshotUtils.takeScreenshot(driver, message + System.currentTimeMillis());
    }
}
