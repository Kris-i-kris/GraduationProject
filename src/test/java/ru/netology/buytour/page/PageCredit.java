package ru.netology.buytour.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.netology.buytour.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageCredit {
    private final SelenideElement heading = $$(".heading").find(exactText("Кредит по данным карты"));
    private final SelenideElement numberCard = $(".input [placeholder='0000 0000 0000 0000']");
    private final SelenideElement month = $(".input [placeholder='08']");
    private final SelenideElement year = $(".input [placeholder='22']");
    private final SelenideElement holder = $$(By.className("input__top")).find(Condition.text("Владелец")).parent().find(By.className("input__control"));
    private final SelenideElement cvc = $(".input [placeholder='999']");
    private final SelenideElement buttonContinue = $$(".button").find(exactText("Продолжить"));
    private final SelenideElement emptyField = $$(".input__sub").find(exactText("Поле обязательно для заполнения"));
    private final SelenideElement wrongFormat = $$(".input__sub").find(exactText("Неверный формат"));
    private final SelenideElement expiredCard = $$(".input__sub").find(exactText("Истёк срок действия карты"));
    private final SelenideElement wrongDeadlineCard = $$(".input__sub").find(exactText("Неверно указан срок действия карты"));
    private final SelenideElement approved = $$(".notification__content").find(exactText("Операция одобрена Банком."));
    private final SelenideElement declined = $$(".notification__content").find(exactText("Ошибка! Банк отказал в проведении операции."));

    public PageCredit() {
        heading.shouldBe(visible);
    }

    public void cardInfo(DataHelper.CardInfo cardInfo) {
        numberCard.setValue(cardInfo.getNumberCard());
        month.setValue(cardInfo.getMonth());
        year.setValue(cardInfo.getYear());
        holder.setValue(cardInfo.getHolder());
        cvc.setValue(cardInfo.getCvc());
        buttonContinue.click();
    }

    public void emptyFieldMassage() {
        emptyField.shouldBe(visible);
    }

    public void wrongFormatMassage() {
        wrongFormat.shouldBe(visible);
    }

    public void expiredCardMassage() {
        expiredCard.shouldBe(visible);
    }

    public void wrongDeadlineCardMassage() {
        wrongDeadlineCard.shouldBe(visible);
    }

    public void approvedMassage() {
        approved.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void declinedMassage() {
        declined.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
