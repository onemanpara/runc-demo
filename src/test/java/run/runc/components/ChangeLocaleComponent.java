package run.runc.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ChangeLocaleComponent {

    private final SelenideElement
            dropDownLocaleMenuButton = $(".header .dropdown-toggle"),
            dropDownLocaleMenuWindow = $(".dropdown-menu.show");
    ElementsCollection linksInHeader = $$(".header__menu.d-md-inline-block.d-none ul li");

    public ChangeLocaleComponent chooseLocale(String locale) {
        dropDownLocaleMenuButton.click();
        dropDownLocaleMenuWindow.shouldBe(visible);
        dropDownLocaleMenuWindow.$(byText(locale)).click();
        return this;
    }

    public ChangeLocaleComponent checkButtonsText(List<String> buttonsText) {
        linksInHeader.shouldHave(texts(buttonsText));
        return this;
    }

}
