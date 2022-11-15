package org.ESPN.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WatchPage extends BasePage {
    @FindBy(css = "section.Carousel")
    private List<WebElement> cardsList;

    @FindBy(css = "div.Carousel__Wrapper--canScrollRight ul.Carousel__Inner li:nth-child(2) > a")
    private WebElement secondCard;

    @FindBy(css = "section.lightbox__contentBox")
    private WebElement cardSelectedModal;

    @FindBy(css = ".lightbox__closebtn")
    private WebElement closeBtnModal;

    public WatchPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCards() {
        return cardsList.get(1).findElements(By.cssSelector("ul.Carousel__Inner li"));
    }

    public boolean checkAllCardsTitle() {
        List<Boolean> isTitle = new ArrayList<>();
        getCards().forEach(element -> {
            isTitle.add(element.findElement(By.cssSelector("h2.WatchTile__Title")).isDisplayed() && !element.findElement(By.cssSelector("h2.WatchTile__Title")).getText().equals(""));
        });
        return !isTitle.contains(false);
    }

    public boolean checkAllCardsDescription() {
        List<Boolean> isDescription = new ArrayList<>();
        getCards().forEach(element -> {
            isDescription.add(element.findElement(By.cssSelector(".WatchTile__Meta")).isDisplayed() && !element.findElement(By.cssSelector(".WatchTile__Meta")).getText().equals(""));
        });
        return !isDescription.contains(false);
    }

    public void clickSecondCard() {
        super.clickElement(this.secondCard);
    }

    public boolean closeBtnModalIsDisplayed() {
        super.waitForVisibility(this.closeBtnModal);
        return this.closeBtnModal.isDisplayed();
    }

    public void closeCardModal() {
        super.clickElement(this.closeBtnModal);
    }

    public void backHome() {
        super.getDriver().navigate().back();
        new HomePage(getDriver());
    }
}
