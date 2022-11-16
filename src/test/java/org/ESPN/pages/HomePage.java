package org.ESPN.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    //Ad Banner
    @FindBy(css = ".promo-banner-container > iframe:nth-child(1)")
    private WebElement bannerIframe;
    @FindBy(css = ".PromoBanner__CloseBtn")
    private WebElement closeBannerBtn;

    //Login Elements
    @FindBy(id = "global-user-trigger")
    private WebElement IconUserToHover;

    @FindBy(css = "#sideLogin-left-rail > button.button-alt.med")
    private WebElement loginBtnHomePage;

    @FindBy(id = "oneid-iframe")
    private WebElement loginIframe;

    @FindBy(id = "logo")
    private WebElement espnLogoLoginIframe;

    @FindBy(id = "InputLoginValue")
    private WebElement usernameOrEmailInput;

    @FindBy(id = "InputPassword")
    private WebElement passwordInput;

    @FindBy(id = "BtnSubmit")
    private WebElement loginBtnSubmit;

    @FindBy(id = "BtnCreateAccount")
    private WebElement singUpBtnLoginIframe;

    @FindBy(css = "ul > li.user.hover > div > div > ul.account-management > li.display-user")
    private WebElement welcomeText;

    //Logout Elements
    @FindBy(css = "li.user > div > div > ul.account-management > li:nth-child(9) > a")
    private WebElement logoutBtn;

    @FindBy(css = " li.pillar.watch > a > span > span.link-text")
    private WebElement watchBtn;

    //Deactivate User Elements


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void mouseOverUserIcon() {
        super.mouseOver(this.IconUserToHover);
    }

    //Ad Banner
    public void switchToBanner(){
        super.getDriver().switchTo().frame(bannerIframe);
    }

    public void closeBanner(){
        super.clickElement(closeBannerBtn);
    }

    //Login Methods
    public void openLoginModal() {
        super.clickElement(loginBtnHomePage);
    }

    public void switchToModal() {
        super.getDriver().switchTo().frame(loginIframe);
    }

    public void switchToHome() {
        super.getDriver().switchTo().defaultContent();
    }

    public boolean loginModalIsDisplayed() {
        super.waitForVisibility(loginIframe);
        return loginIframe.isDisplayed();
    }

    public boolean ESPNLogoIsDisplayed() {
        super.waitForVisibility(espnLogoLoginIframe);
        return espnLogoLoginIframe.isDisplayed();
    }

    public boolean loginBtnIsDisplayed() {
        super.waitForVisibility(loginBtnSubmit);
        return loginBtnSubmit.isDisplayed();
    }

    public boolean signUpBtnIsDisplayed() {
        super.waitForVisibility(singUpBtnLoginIframe);
        return singUpBtnLoginIframe.isDisplayed();
    }

    public void fillUsernameEmailInput(String user){
        super.typeOnInput(usernameOrEmailInput, user);
    }

    public void fillPasswordInput(String password){
        super.typeOnInput(passwordInput, password);
    }

    public void submitLoginForm(){
        super.clickElement(loginBtnSubmit);
    }

    public void modalIsClosed(){
        super.waitForInvisibility(loginIframe);
    }

    public WatchPage goToWatch(){
        super.clickElement(watchBtn);
        return new WatchPage(getDriver());
    }

    public String welcomeTextValue(){
        return welcomeText.getText();
    }

    //Logout Methods
    public void clickLogoutBtn(){
        super.clickElement(logoutBtn);
    }



}
