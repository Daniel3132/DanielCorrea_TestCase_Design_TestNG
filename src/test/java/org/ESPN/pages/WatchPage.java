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

    public boolean checkElementInCard(WebElement element, String selector){
        return !element.findElement(By.cssSelector(selector)).getText().equals("");
    }

    public boolean checkAllCardsTitle() {
        List<Boolean> titlesCheckedList = new ArrayList<>();
        for (int i = 0; i < getCards().size(); i++) {
            titlesCheckedList.add(checkElementInCard(getCards().get(i),"h2.WatchTile__Title" ));
        }
        return !titlesCheckedList.contains(false);
    }

    public boolean checkAllCardsDescription() {
        List<Boolean> descriptionsCheckedList = new ArrayList<>();
        for (int i = 0; i < getCards().size(); i++) {
            descriptionsCheckedList.add(checkElementInCard(getCards().get(i),".WatchTile__Meta" ));
        }
        return !descriptionsCheckedList.contains(false);
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
    }
}
