package ru.netology.buytour.tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.buytour.data.DBHelper;
import ru.netology.buytour.data.DataHelper;
import ru.netology.buytour.page.PageHome;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertNull;
import static ru.netology.buytour.data.DBHelper.getCreditId;

public class DBTest {
    @BeforeEach
    void setup() {
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
    @DisplayName("База Данных.Покупка по карте APPROVED")
    void checkAPPROVEDCardDebit() {
        var validCardInfo = DataHelper.getAPPROVED();
        var debitPage = new PageHome().buyDebit();
        debitPage.cardInfo(validCardInfo);
        debitPage.approvedMassage();
        Assertions.assertEquals("APPROVED", DBHelper.getPaymentStatus());
//        assertEquals(45000, DBHelper.getPaymentAmount());
    }

    @Test
    @DisplayName("База Данных.Покупка по карте DECLINED")
    void checkDECLINEDCardDebit() {
        var invalidCardInfo = DataHelper.getDECLINED();
        var debitPage = new PageHome().buyDebit();
        debitPage.cardInfo(invalidCardInfo);
        debitPage.declinedMassage();
        Assertions.assertEquals("DECLINED", DBHelper.getPaymentStatus());
    }

    @Test
    @DisplayName("База Данных.Кредит по карте APPROVED")
    void checkAPPROVEDCardCredit() {
        var validCardInfo = DataHelper.getAPPROVED();
        var debitPage = new PageHome().buyDebit();
        debitPage.cardInfo(validCardInfo);
        debitPage.approvedMassage();
        Assertions.assertEquals("APPROVED", DBHelper.getCreditRequestStatus());
        Assertions.assertNull(getCreditId());
    }

    @Test
    @DisplayName("База Данных.Кредит по карте DECLINED")
    void checkDECLINEDCardCredit() {
        var invalidCardInfo = DataHelper.getDECLINED();
        var debitPage = new PageHome().buyDebit();
        debitPage.cardInfo(invalidCardInfo);
        debitPage.declinedMassage();
        Assertions.assertEquals("DECLINED", DBHelper.getCreditRequestStatus());
        Assertions.assertNull(getCreditId());
    }
}
