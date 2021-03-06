package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import pages.FacebookPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Epic("QA.GURU automation course")
@Story("Facebook tests")
@Tag("facebook")
class FacebookTests extends TestBase {

    @Test
    @Description("Positive test with testid")
    void successfulLoginWithTestId() {
        open("http://facbook.com");

        $(by("data-testid", "royal_email")).setValue("qa.guru.test@gmail.com"); // Do not store private data in code!
//        $("#email").setValue("qa.guru.test@gmail.com");
//        $(byId("email")).setValue("qa.guru.test@gmail.com");
//        $(".inputtext.login_form_input_box").setValue("qa.guru.test@gmail.com");
//        $(".login_form_input_box").setValue("qa.guru.test@gmail.com");

        $(by("data-testid", "royal_pass")).setValue("testpassword#&!");
        $(by("data-testid", "royal_login_button")).click();
//        $(byText("Вход")).click();

        $("html").shouldHave(text("Qa"), text("Guru"));
    }

    @Test
    @Description("Positive test with PageObject")
    void successfulLoginWithPageObject() {
        FacebookPage facebookPage = new FacebookPage();

        open("http://facbook.com");

        facebookPage.typeEmail("qa.guru.test@gmail.com");
        facebookPage.typePassword("testpassword#&!");
        facebookPage.clickSubmit();

        facebookPage.verifyLoggedInAsUser("Qa", "Guru");
    }
}