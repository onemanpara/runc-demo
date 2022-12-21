package run.runc.pages;

import run.runc.tests.BaseTest;

import static com.codeborne.selenide.Selenide.open;

public class MainPage extends BaseTest {

    public MainPage openPage() {
        open("");
        return this;
    }

}
