package netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    @FindBy (css = "[data-test-id=action-deposit]")
    private SelenideElement topUpButtonForFirstCard;
    @FindBy (css = ".list__item")
    private ElementsCollection cards;
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public int getFirstCardCreditBalance() {
        val text = cards.get(0).text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public int getSecondCardCreditBalance() {
        val text = cards.get(1).text();
        return extractBalance(text);
    }

    public TopUpPage clickTopUpButton() {
        topUpButtonForFirstCard.click();
        return page(TopUpPage.class);
    }
}
