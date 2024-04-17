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

public class DebitTest {
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
    @DisplayName("Покупка совершена")
    void shouldBuyInDebit() {
        var validCardInfo = DataHelper.getAPPROVED();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(validCardInfo);
        debitPage.approvedMassage();
    }

    @Test
    @DisplayName("Валидная максимальная граница даты")
    void shouldBuyInDebitMax() {
        var validCardInfo = DataHelper.getValidMaxBorderYear();
        var debitPage = new PageHome().buyDebit();
        debitPage.cardInfo(validCardInfo);
        debitPage.approvedMassage();
    }

    @Test
    @DisplayName("Покупка НЕ совершена")
    void debitDeclined() {
        var invalidCardInfo = DataHelper.getDECLINED();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.declinedMassage();
    }

    @Test
    @DisplayName("Поле карты не заполнено")
    void emptyFieldCardDebit() {
        var invalidCardInfo = DataHelper.getInvalidCardNotFilled();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле карты заполнено меньшем количеством цифр (15)")
    void fifteenDigitsFieldCard() {
        var invalidCardInfo = DataHelper.getInvalidCardFifteenDigits();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле месяц не заполнено")
    void fieldMonthNotFilled() {
        var invalidCardInfo = DataHelper.getInvalidMonthNotFilled();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле месяц 00")
    void fieldMonth00() {
        var invalidCardInfo = DataHelper.getInvalidMonth00();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongDeadlineCardMassage();
    }

    @Test
    @DisplayName("Поле месяц одна цифра")
    void fieldMonthOneDigit() {
        var invalidCardInfo = DataHelper.getInvalidMonthOneDigit();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Карта просрочена в прошлом месяце")
    void expiredLastMonth() {
        var invalidCardInfo = DataHelper.getInvalidExpiredLastMonth();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongDeadlineCardMassage();
    }

    @Test
    @DisplayName("13-й месяц")
    void fieldMonth13() {
        var invalidCardInfo = DataHelper.getInvalidMonth13();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongDeadlineCardMassage();
    }

    @Test
    @DisplayName("14-й месяц")
    void fieldMonth14() {
        var invalidCardInfo = DataHelper.getInvalidMonth14();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongDeadlineCardMassage();
    }

    @Test
    @DisplayName("Поле год не заполнено")
    void fieldYearNotFilled() {
        var invalidCardInfo = DataHelper.getInvalidYearNotFilled();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле год одна цифра")
    void fieldYearOneDigit() {
        var invalidCardInfo = DataHelper.getInvalidYearOneDigit();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Карта просрочена в прошлом году")
    void expiredLastYear() {
        var invalidCardInfo = DataHelper.getInvalidExpiredLastYear();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.expiredCardMassage();
    }

    @Test
    @DisplayName("На 1 год превышен срок службы карты")
    void exceedsCardLifespan() {
        var invalidCardInfo = DataHelper.getInvalidExceedsCardLifespan();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongDeadlineCardMassage();
    }

    @Test
    @DisplayName("Поле владелец не заполнено")
    void fieldNameNotFilled() {
        var invalidCardInfo = DataHelper.getInvalidNameNotFilled();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.emptyFieldMassage();
    }

    @Test
    @DisplayName("Поле владелец заполнено кириллицей")
    void fieldNameRus() {
        var invalidCardInfo = DataHelper.getInvalidNameRus();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле владелец меньше допустимого минимума символов")
    void fieldName2Letters() {
        var invalidCardInfo = DataHelper.getInvalidName2Letters();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.emptyFieldMassage();
    }

    @Test
    @DisplayName("Поле владелец с цифрами")
    void fieldNamePlusDigit() {
        var invalidCardInfo = DataHelper.getInvalidNamePlusDigit();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле владелец без пробела")
    void fieldNameNoSpase() {
        var invalidCardInfo = DataHelper.getInvalidNameNoSpase();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле владелец с спецсимволами")
    void fieldNameOtherSigns() {
        var invalidCardInfo = DataHelper.getInvalidNameOtherSigns();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле владелец превышен допустимый максимум")
    void fieldNameExceedsLimit() {
        var invalidCardInfo = DataHelper.getInvalidNameExceedsLimit();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле CVC не заполнено")
    void fieldCvcNotFilled() {
        var invalidCardInfo = DataHelper.getInvalidCvcNotFilled();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.emptyFieldMassage();
    }

    @Test
    @DisplayName("Поле CVC 000")
    void fieldCvcZero() {
        var invalidCardInfo = DataHelper.getInvalidCvcZero();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongFormatMassage();
    }

    @Test
    @DisplayName("Поле CVC 2 цифры")
    void fieldCvcLetters() {
        var invalidCardInfo = DataHelper.getInvalidCvc2Letters();
        var debitPage = new PageHome().buyDebit();;
        debitPage.cardInfo(invalidCardInfo);
        debitPage.wrongFormatMassage();
    }
}
