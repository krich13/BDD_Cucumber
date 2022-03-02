package netology.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getCorrectAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }


    public static VerificationCode getValidVerificationCodeFor(AuthInfo authInfo) { //создаем метод внутри вложенного класса, чтобы получить верфикационный код
        return new VerificationCode("12345");
    }

    @Value
    public static class CreditCard {
        private String creditCard;
        private int creditCardBalance;
    }

    public static CreditCard getFirstCreditCard() {
        return new CreditCard("5559 0000 0000 0001", 10000);

    }

    public static CreditCard getSecondCreditCard() {
        return new CreditCard("5559 0000 0000 0002", 10000);
    }

}