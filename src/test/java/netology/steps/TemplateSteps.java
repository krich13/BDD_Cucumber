package netology.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import netology.data.DataHelper;
import netology.page.DashboardPage;
import netology.page.LoginPage;
import netology.page.TopUpPage;
import netology.page.VerificationPage;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.open;

public class TemplateSteps {

    private static LoginPage loginPage;
    private static VerificationPage verificationPage;
    private static DashboardPage dashboardPage;
    private static TopUpPage topUpPage;


    @Пусть("открыта страница с формой авторизации {string}")
    public void открытаСтраницаСФормойАвторизации(String url) {
        loginPage = open(url, LoginPage.class);
    }

    @И("пользователь залогинен с именем {string} и паролем {string}")
    public void пользовательЗалогиненСИменемИПаролем(String name, String password) {
        DataHelper.AuthInfo authinfo = new DataHelper.AuthInfo(name, password);
        verificationPage = loginPage.validLogin(authinfo);
    }

    @И("вводит код аутентификации {string}")
    public void вводитКодАутентификации(String authCode) {
        DataHelper.VerificationCode code = new DataHelper.VerificationCode(authCode);
        dashboardPage = verificationPage.validVerify(code);
    }

    @Когда("пользователь переводит {string} рублей с карты с номером {string} на свою {string} карту с главной страницы")
    public void пользовательПереводитРублейСКартыСНомеромНаСвоюКартуСГлавнойСтраницы(String amountToBeTransferred,
                                                                                     String sourceCard,
                                                                                     String destinationIdCard) {
        TopUpPage topUp = dashboardPage.clickTopUpButton();
        dashboardPage = topUp.clickTopUpButton(Integer.parseInt(amountToBeTransferred), sourceCard);
    }

    @Тогда("тогда баланс его {string} карты из списка на главной странице должен стать {string} рублей")
    public void тогдаБалансЕгоКартыИзСпискаНаГлавнойСтраницеДолженСтатьРублей(String destinationCreditCard, String balanceOfDestinationCreditCard) {
        int balance = dashboardPage.getFirstCardCreditBalance();
        Assertions.assertEquals(Integer.parseInt(balanceOfDestinationCreditCard), balance);
    }

}
