package run.runc.components;

import com.codeborne.selenide.SelenideElement;
import run.runc.data.Genders;
import run.runc.data.MailingsLanguage;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SignInModal {

    private final SelenideElement
            openModalButton = $(".header [data-target=\"#signinModal\"]"),
            signInEmailInput = $("#signinEmail"),
            signInPasswordInput = $("#signinPassword"),
            signInButton = $("#firstTab .signin__submit button"),
            registrationTab = $x("//div[@class='signin']//a[contains(text(), 'Зарегистрироваться')]"),
            firstNameInput = $("#signupFirstName"),
            surnameInput = $("#signupLastName"),
            dateOfBirthday = $("#signupDay"),
            monthSelect = $("#id_month"),
            yearInput = $("#signupYear"),
            citizenshipSelect = $("#id_country_of_citizenship"),
            manGenderRadio = $("#id_gender_0"),
            womanGenderRadio = $("#id_gender_1"),
            passwordInput = $("#signupPassword1"),
            passwordAgainInput = $("#signupPassword2"),
            signUpEmailInput = $("#signupEmail"),
            mailingLanguageIsRussianRadio = $("#id_mailings_language_0"),
            mailingLanguageIsEnglishRadio = $("#id_mailings_language_1"),
            agreementIsAcceptedCheckbox = $("[name=\"agreement_is_accepted\""),
            registrationButton = $("#secondTab .signin__submit button"),
            closeModalButton = $(".close");

    public SignInModal openSignInModal() {
        openModalButton.click();
        return this;
    }

    public SignInModal closeSignInModal() {
        closeModalButton.click();
        return this;
    }

    public SignInModal setSignInEmail(String signInEmail) {
        signInEmailInput.setValue(signInEmail);
        return this;
    }

    public SignInModal setSignInPassword(String signInPassword) {
        signInPasswordInput.setValue(signInPassword);
        return this;
    }

    public SignInModal signInButtonClick() {
        signInButton.click();
        return this;
    }

    public SignInModal clickRegistrationTab() {
        registrationTab.click();
        return this;
    }

    public SignInModal setFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public SignInModal setSurname(String surname) {
        surnameInput.setValue(surname);
        return this;
    }

    public SignInModal setBirthday(List<String> birthday) {
        dateOfBirthday.setValue(birthday.get(0));
        monthSelect.selectOptionByValue(birthday.get(1));
        yearInput.setValue(birthday.get(2));
        return this;
    }


    public SignInModal setCitizenship(String citizenship) {
        citizenshipSelect.selectOptionByValue(citizenship);
        return this;
    }

    public SignInModal setGender(Genders gender) {
        switch (gender) {
            case MAN:
                manGenderRadio.sibling(0).click();
                break;
            case WOMAN:
                womanGenderRadio.sibling(0).click();
                break;
        }
        return this;
    }

    public SignInModal setPassword(String password) {
        passwordInput.setValue(password);
        passwordAgainInput.setValue(password);
        return this;
    }

    public SignInModal setSignUpEmail(String signUpEmail) {
        signUpEmailInput.setValue(signUpEmail);
        return this;
    }

    public SignInModal setMailingsLanguage(MailingsLanguage mailingsLanguage) {
        switch (mailingsLanguage) {
            case RU:
                mailingLanguageIsRussianRadio.sibling(0).click();
            case EN:
                mailingLanguageIsEnglishRadio.sibling(0).click();
        }
        return this;
    }

    public SignInModal agreementIsAcceptedCheckBoxClick() {
        agreementIsAcceptedCheckbox.sibling(0).click();
        return this;
    }


    public SignInModal registrationButtonClick() {
        registrationButton.click();
        return this;
    }
}
