import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;



public class AuthTest {
    @Test
    public void positiveLoginTest() {
        open("https://postelka.ru/login");

        $("#input-email").setValue("vmarkushin04@mail.ru");
        $("#input-password").setValue("password");

        $("button[type='submit'].ui-btn.ui-btn-primary.ui-btn-60.ui-btn-fullwidth").click();

    }
    @Test
    public void negativeLoginTest() {
        open("https://postelka.ru/login");

        $("#input-email").setValue("123");
        $("#input-password").setValue("123");

        $("button[type='submit'].ui-btn.ui-btn-primary.ui-btn-60.ui-btn-fullwidth").click();


        $(".alert__text").shouldHave(Condition.text(
                "Не найден введённый адрес E-Mail и/или пароль указан неправильно."
        ));
    }


}

