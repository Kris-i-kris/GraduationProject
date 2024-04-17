package ru.netology.buytour.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.netology.buytour.data.DataHelper;
import ru.netology.buytour.page.PageHome;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class CreditTest {
    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        Configuration.browserCapabilities = options;

        open("http://localhost:8080");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    @DisplayName("Одобренный кредит")
    void shouldBuyInCredit() {
        var validCardInfo = DataHelper.getAPPROVED();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(validCardInfo);
        creditPage.approvedMassage();
    }

    @Test
    @DisplayName("Валидная максимальная граница даты")
    void shouldBuyInCreditMax() {
        var validCardInfo = DataHelper.getValidMaxBorderYear();
        var creditPage = new PageHome().buyCredit();
        creditPage.cardInfo(validCardInfo);
        creditPage.approvedMassage();
    }

    @Test
    @DisplayName("Отклоненный кредит")
    void creditDeclined() {
        var invalidCardInfo = DataHelper.getDECLINED();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.declinedMassage();
    }

    @Test
    @DisplayName("Поле карты не заполнено")
    void emptyFieldCardCredit() {
        var invalidCardInfo = DataHelper.getInvalidCardNotFilled();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле карты заполнено меньшем количеством цифр (15)")
    void fifteenDigitsFieldCard() {
        var invalidCardInfo = DataHelper.getInvalidCardFifteenDigits();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле месяц не заполнено")
    void fieldMonthNotFilled() {
        var invalidCardInfo = DataHelper.getInvalidMonthNotFilled();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле месяц 00")
    void fieldMonth00() {
        var invalidCardInfo = DataHelper.getInvalidMonth00();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongDeadlineCardMassage();
    }

    @Test
    @DisplayName("Поле месяц одна цифра")
    void fieldMonthOneDigit() {
        var invalidCardInfo = DataHelper.getInvalidMonthOneDigit();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Карта просрочена в прошлом месяце")
    void expiredLastMonth() {
        var invalidCardInfo = DataHelper.getInvalidExpiredLastMonth();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongDeadlineCardMassage();
    }

    @Test
    @DisplayName("13-й месяц")
    void fieldMonth13() {
        var invalidCardInfo = DataHelper.getInvalidMonth13();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongDeadlineCardMassage();
    }

    @Test
    @DisplayName("14-й месяц")
    void fieldMonth14() {
        var invalidCardInfo = DataHelper.getInvalidMonth14();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongDeadlineCardMassage();
    }

    @Test
    @DisplayName("Поле год не заполнено")
    void fieldYearNotFilled() {
        var invalidCardInfo = DataHelper.getInvalidYearNotFilled();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле год одна цифра")
    void fieldYearOneDigit() {
        var invalidCardInfo = DataHelper.getInvalidYearOneDigit();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Карта просрочена в прошлом году")
    void expiredLastYear() {
        var invalidCardInfo = DataHelper.getInvalidExpiredLastYear();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.expiredCardMassage();
    }

    @Test
    @DisplayName("На 1 год превышен срок службы карты")
    void exceedsCardLifespan() {
        var invalidCardInfo = DataHelper.getInvalidExceedsCardLifespan();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongDeadlineCardMassage();
    }

    @Test
    @DisplayName("Поле владелец не заполнено")
    void fieldNameNotFilled() {
        var invalidCardInfo = DataHelper.getInvalidNameNotFilled();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.emptyFieldMassage();
    }

    @Test
    @DisplayName("Поле владелец заполнено кириллицей")
    void fieldNameRus() {
        var invalidCardInfo = DataHelper.getInvalidNameRus();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле владелец меньше допустимого минимума символов")
    void fieldName2Letters() {
        var invalidCardInfo = DataHelper.getInvalidName2Letters();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.emptyFieldMassage();
    }

    @Test
    @DisplayName("Поле владелец с цифрами")
    void fieldNamePlusDigit() {
        var invalidCardInfo = DataHelper.getInvalidNamePlusDigit();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле владелец без пробела")
    void fieldNameNoSpase() {
        var invalidCardInfo = DataHelper.getInvalidNameNoSpase();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле владелец с спецсимволами")
    void fieldNameOtherSigns() {
        var invalidCardInfo = DataHelper.getInvalidNameOtherSigns();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле владелец превышен допустимый максимум")
    void fieldNameExceedsLimit() {
        var invalidCardInfo = DataHelper.getInvalidNameExceedsLimit();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле CVC не заполнено")
    void fieldCvcNotFilled() {
        var invalidCardInfo = DataHelper.getInvalidCvcNotFilled();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.emptyFieldMassage();
    }

    @Test
    @DisplayName("Поле CVC 000")
    void fieldCvcZero() {
        var invalidCardInfo = DataHelper.getInvalidCvcZero();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле CVC 2 цифры")
    void fieldCvcLetters() {
        var invalidCardInfo = DataHelper.getInvalidCvc2Letters();
        var creditPage = new PageHome().buyCredit();;
        creditPage.cardInfo(invalidCardInfo);
        creditPage.wrongFormatMassage();
    }
}
