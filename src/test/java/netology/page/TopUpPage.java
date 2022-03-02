package netology.page;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TopUpPage {
    @FindBy (css = "[data-test-id=action-transfer]")
    private SelenideElement topUpButton;
    @FindBy (css = "[data-test-id=amount] .input__control")
    private SelenideElement transferAmount;
    @FindBy (css = "[data-test-id=from] .input__control")
    private SelenideElement fromWhatCardShouldBeTransfer;
    @FindBy (css = "[data-test-id=action-cancel]")
    private SelenideElement cancelButton;
    @FindBy (css = "[data-test-id=error-notification]")
    private SelenideElement bannerError;

    public TopUpPage() {
        $(Selectors.byText("Пополнение карты")).shouldBe(appear);
    }

    public void fillOutForm(int amountToBeTransferred, String chosenCard) {
        transferAmount.setValue(Integer.toString(amountToBeTransferred));
        fromWhatCardShouldBeTransfer.setValue(chosenCard);
    }

    public DashboardPage clickTopUpButton(int amountToBeTransferred, String chosenCard) { //метод клика на кнопку пополнить
        fillOutForm(amountToBeTransferred, chosenCard);
        topUpButton.click();
        return page(DashboardPage.class);
    }
}



