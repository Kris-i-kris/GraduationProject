package ru.netology.buytour.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    public static String approvedStatus = "4444 4444 4444 4441";
    public static String declinedStatus = "4444 4444 4444 4442";
    private static final Faker faker = new Faker(new Locale("en"));
    private static final Faker fakerRus = new Faker(new Locale("ru"));

    public DataHelper() {
    }

    @Value
    public static class CardInfo {
        String numberCard;
        String month;
        String year;
        String holder;
        String cvc;
    }

    public static String getCard15Digits() {

        return "1111 2222 3333 444";
    }

    public static String getMonth() {

        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getMonthMinus1() {
        return LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getMonth00() {

        return "00";
    }

    public static String getMonthOneDigit() {

        return "5";
    }

    public static String getMonth13() {

        return "13";
    }

    public static String getMonth14() {

        return "14";
    }

    public static String getYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getYearMinus1() {
        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getYearPlus5() {
        return LocalDate.now().plusYears(5).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getYearPlus6() {
        return LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("yy"));
    }
    public static String getYearOneDigit() {
        return "4";
    }

    public static String getName() {

        return faker.name().fullName();
    }

    public static String getRusName() {
        return fakerRus.name().fullName();
    }

    public static String getName2Letters() {
        return "su";
    }

    public static String getNamePlusDigit() {
        return "Kristin9 Ivan9 ";
    }

    public static String getNameNoSpase() {
        return "KristinIvan";
    }

    public static String getNameOtherSigns() {

        return "Kristin!@# Ivan";
    }

    public static String getNameExceedsLimit() {

        return "KristinIvan KristinIvan";
    }

    public static String getCvc() {
        return faker.numerify("###");
    }

    public static String getCvc2Letters() {

        return faker.numerify("##");
    }

    public static String getCvcZero() {
        return "000";
    }

    public static String getEmptyField() {

        return " ";
    }

    public static CardInfo getAPPROVED() {
        return new CardInfo(approvedStatus, getMonth(), getYear(), getName(), getCvc());
    }
    public static CardInfo getValidMaxBorderYear() {
        return new CardInfo(approvedStatus, getMonth(), getYearPlus5(), getName(), getCvc());
    }
    public static CardInfo getDECLINED() {
        return new CardInfo(declinedStatus, getMonth(), getYear(), getName(), getCvc());
    }
    public static CardInfo getInvalidCardNotFilled() {
        return new CardInfo(getEmptyField(), getMonth(), getYear(), getName(), getCvc());
    }
    public static CardInfo getInvalidCardFifteenDigits() {
        return new CardInfo(getCard15Digits(), getMonth(), getYear(), getName(), getCvc());
    }
    public static CardInfo getInvalidMonthNotFilled() {
        return new CardInfo(approvedStatus, getEmptyField(), getYear(), getName(), getCvc());
    }
    public static CardInfo getInvalidMonth00() {
        return new CardInfo(approvedStatus, getMonth00(), getYear(), getName(), getCvc());
    }
    public static CardInfo getInvalidMonthOneDigit() {
        return new CardInfo(approvedStatus, getMonthOneDigit(), getYear(), getName(), getCvc());
    }
    public static CardInfo getInvalidExpiredLastMonth() {
        return new CardInfo(approvedStatus, getMonthMinus1(), getYear(), getName(), getCvc());
    }
    public static CardInfo getInvalidMonth13() {
        return new CardInfo(approvedStatus, getMonth13(), getYear(), getName(), getCvc());
    }
    public static CardInfo getInvalidMonth14() {
        return new CardInfo(approvedStatus, getMonth14(), getYear(), getName(), getCvc());
    }
    public static CardInfo getInvalidYearNotFilled() {
        return new CardInfo(approvedStatus, getMonth(), getEmptyField(), getName(), getCvc());
    }
    public static CardInfo getInvalidYearOneDigit() {
        return new CardInfo(approvedStatus, getMonth(), getYearOneDigit(), getName(), getCvc());
    }
    public static CardInfo getInvalidExpiredLastYear() {
        return new CardInfo(approvedStatus, getMonth(), getYearMinus1(), getName(), getCvc());
    }
    public static CardInfo getInvalidExceedsCardLifespan() {
        return new CardInfo(approvedStatus, getMonth(), getYearPlus6(), getName(), getCvc());
    }
    public static CardInfo getInvalidNameNotFilled() {
        return new CardInfo(approvedStatus, getMonth(), getYear(), getEmptyField(), getCvc());
    }
    public static CardInfo getInvalidNameRus() {
        return new CardInfo(approvedStatus, getMonth(), getYear(), getRusName(), getCvc());
    }
    public static CardInfo getInvalidName2Letters() {
        return new CardInfo(approvedStatus, getMonth(), getYear(), getName2Letters(), getCvc());
    }
    public static CardInfo getInvalidNamePlusDigit() {
        return new CardInfo(approvedStatus, getMonth(), getYear(), getNamePlusDigit(), getCvc());
    }
    public static CardInfo getInvalidNameNoSpase() {
        return new CardInfo(approvedStatus, getMonth(), getYear(), getNameNoSpase(), getCvc());
    }
    public static CardInfo getInvalidNameOtherSigns() {
        return new CardInfo(approvedStatus, getMonth(), getYear(), getNameOtherSigns(), getCvc());
    }
    public static CardInfo getInvalidNameExceedsLimit() {
        return new CardInfo(approvedStatus, getMonth(), getYear(), getNameExceedsLimit(), getCvc());
    }
    public static CardInfo getInvalidCvcNotFilled() {
        return new CardInfo(approvedStatus, getMonth(), getYear(), getName(), getEmptyField());
    }
    public static CardInfo getInvalidCvcZero() {
        return new CardInfo(approvedStatus, getMonth(), getYear(), getName(), getCvcZero());
    }
    public static CardInfo getInvalidCvc2Letters() {
        return new CardInfo(approvedStatus, getMonth(), getYear(), getName(), getCvc2Letters());
    }


}
