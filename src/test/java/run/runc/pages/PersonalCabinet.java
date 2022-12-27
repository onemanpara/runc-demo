package run.runc.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class PersonalCabinet {

    private final SelenideElement
            userNameInHeader = $("#panel .header-profile span"),
            profileSettingsSaveButton = $(".profile-settings__submit button");

    public PersonalCabinet checkUserNameInHeader(String name, String surname) {
        userNameInHeader.shouldHave(text(name));
        userNameInHeader.shouldHave(text(surname));
        return this;
    }

    public PersonalCabinet profileSettingsSaveButtonClick() {
        profileSettingsSaveButton.scrollIntoView(true);
        profileSettingsSaveButton.doubleClick();
        return this;
    }

}
