package com.example.module7_3.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PricingIndividualPage {

    private WebDriverWait wait;
    private final Logger log = LoggerFactory.getLogger((PricingIndividualPage.class));

    @FindBy(xpath = "//a[@type='button' and contains(@href,'https://www.jetbrains.com/shop/buy?item=P:N:ALL:Y')]")
    private WebElement buttonPackYear;

    @FindBy(xpath = "//input[@value='monthly' and @name='rs-switcher-_r_17_']/following-sibling::span/div/div")
    private WebElement switchMonthly;

    @FindBy(xpath = "//p[@data-test='product-price-title-second-year']")
    private WebElement titleSecondYear;

    @FindBy(xpath = "//input[@value='students' and @name = 'rs-switcher-_r_2_']/following-sibling::span/div/div[contains(text(),'Students, Teachers & Community')]")
    private WebElement tabStudents;

    @FindBy(xpath = "//h3[contains(.,'For classroom assistance free')]")
    private WebElement titleClassroomFree;

    @Step("Проверка, что кнопка покупки доступна")
    public boolean enabledButtonPackYear() {
        log.info("Проверка, что кнопка покупки доступна");
        return buttonPackYear.isEnabled();
    }

    @Step("Проверка, что можем переключиться на страницу месячных подписок")
    public boolean enabledSwitchMonthly() {
        log.info("Проверка, что можем переключиться на страницу месячных подписок");
        return switchMonthly.isEnabled();
    }

    @Step("Произошёл клик на страницу месячных подписок")
    public void clickSwitchMonthly() {
        switchMonthly.click();
        log.info("Произошёл клик на страницу месячных подписок");
    }

    @Step("Переходим на вкладку с информацией для студентов и учителей")
    public void clickTabStudents() {
        log.info("Переходим на вкладку с информацией для студентов и учителей");
        tabStudents.click();
    }

    @Step("Проверяем, что заголовок о втором годе не отображается")
    public void NoDisplayTitleSecondYear() {
        log.info("Проверяем, что заголовок о втором годе не отображается");
        wait.until(ExpectedConditions.invisibilityOf(titleSecondYear));
    }

    @Step("Заголовок \"For classroom assistance free\" отобразился")
    public boolean displayTitleClassroom() {
        log.info("Заголовок \"For classroom assistance free\" отобразился");
        return titleClassroomFree.isDisplayed();
    }

    public PricingIndividualPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
}
