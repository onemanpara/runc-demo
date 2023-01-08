package run.runc.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SpecialFormComponent {


    private final SelenideElement
            formParticipation = $("#signupFormParticipation"),
            specialFormCheckBox = $("[name=\"is_invalid\"]"),
            phoneInput = $("#id_contact_phone_number"),
            documentsUploadInput = $("input[type=file].dz-hidden-input"),
            modalSpecialFormCancelConfirm = $(".modal--confirm"),
            cancelSpecialFormButton = $("#disabilityButtonYes"),
            additionalFieldsForInvalids = $(".additional-fields-for-invalids"),
            dragDropFilesUl = $(".dragdrop-files-list");

    private final ElementsCollection
            signupFormParticipationElements = $$("#signupFormParticipation option");

    public SpecialFormComponent setFormParticipation() {
        int elementsSource = signupFormParticipationElements.size();
        formParticipation.selectOption(ThreadLocalRandom.current().nextInt(0, elementsSource));
        return this;
    }

    public SpecialFormComponent setPhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    public void specialFormCheckboxClick() {
        specialFormCheckBox.sibling(0).click();
    }

    public void uploadDocument(String fileName) {
        documentsUploadInput.uploadFromClasspath("img/" + fileName);
    }

    public SpecialFormComponent completeSpecialForm(String phone, String fileName) {
        specialFormCheckboxClick();
        setFormParticipation();
        setPhone(phone);
        uploadDocument(fileName);
        return this;
    }

    public SpecialFormComponent checkSpecialFormCheckBoxSelected() {
        specialFormCheckBox.shouldHave(attribute("checked"));
        return this;
    }


    public SpecialFormComponent cancelSpecialForm() {
        specialFormCheckboxClick();
        modalSpecialFormCancelConfirm.shouldBe(attribute
                ("style", "padding-right: 17px; display: block;")
        );
        sleep(500);
        cancelSpecialFormButton.click();
        return this;
    }

    public SpecialFormComponent checkSpecialFormCheckBoxNotSelected() {
        additionalFieldsForInvalids.shouldNotBe(visible);
        modalSpecialFormCancelConfirm.$(byText("Вы уверены, что хотите убрать статус «Инвалидность»?")).shouldNotBe(visible);
        return this;
    }

    public SpecialFormComponent checkPhoneNumberInSpecialForm(String phoneNumber) {
        phoneInput.shouldHave(attribute("value", phoneNumber));
        return this;
    }

    public SpecialFormComponent checkDragDropFilesUlIsEmpty() {
        dragDropFilesUl.shouldNotBe(visible);
        return this;
    }
}
