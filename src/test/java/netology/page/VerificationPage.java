package netology.page;

import com.codeborne.selenide.SelenideElement;
import netology.data.DataHelper;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class VerificationPage {
    @FindBy (css = "[data-test-id=code] input")
    private SelenideElement codeField;
    @FindBy (css = "[data-test-id=action-verify]")
    private SelenideElement verifyButton;


    public DashboardPage validVerify(DataHelper.VerificationCode verificationCode) {
        codeField.setValue(verificationCode.getCode());
        verifyButton.click();
        return page(DashboardPage.class);
    }

}