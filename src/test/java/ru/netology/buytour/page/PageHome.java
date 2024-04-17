package ru.netology.buytour.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class PageHome {
    private final SelenideElement heading = $$(".heading").find(exactText("Путешествие дня")) ;
    private final SelenideElement buttonBuy = $$(".button__text").find(exactText("Купить"));
    private final SelenideElement buttonBuyCredit = $$(".button__text").find(exactText("Купить в кредит"));

    public PageHome() {

        heading.shouldBe(visible);
    }

    public PageDebit buyDebit() {
      buttonBuy.click();
      return new PageDebit();
    }

    public PageCredit buyCredit() {
        buttonBuyCredit.click();
        return new PageCredit();
    }
}
