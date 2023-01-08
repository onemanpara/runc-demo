package run.runc.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class PersonalCabinetPage {

    private final SelenideElement
            userNameInHeader = $("#panel .header-profile span"),
            profileSettingsSaveButton = $(".profile-settings__submit button");

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

}
