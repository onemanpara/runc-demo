package run.runc.data;

public enum Locale {

    EN("Eng"), RU("Рус");

    private final String localeName;

    Locale(String localeName) {
        this.localeName = localeName;
    }

    public String getLocaleName() {return this.localeName;}

}
