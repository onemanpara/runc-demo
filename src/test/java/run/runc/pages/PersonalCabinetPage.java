package run.runc.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class PersonalCabinetPage {

    private final SelenideElement
            userNameInHeader = $("#panel .header-profile span"),
            profileSettingsSaveButton = $(".profile-settings__submit button"),
            logOutButton = $("#panel .i-signout"),
            openSignInModalButton = $(".header [data-target=\"#signinModal\"]");

    public PersonalCabinetPage checkUserNameInHeader(String name, String surname) {
        userNameInHeader.shouldHave(text(name));
        userNameInHeader.shouldHave(text(surname));
        return this;
    }

    public PersonalCabinetPage profileSettingsSaveButtonClick() {
        profileSettingsSaveButton.scrollIntoView(true);
        profileSettingsSaveButton.doubleClick();
        return this;
    }

    public PersonalCabinetPage logOut() {
        logOutButton.click();
        openSignInModalButton.shouldHave(text("Войти"));
        return this;
    }

}
