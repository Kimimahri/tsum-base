package constants.enums;

public enum Notices {
    BAD_EMAIL("Указан некорректный email"),
    SHORT_PASSWORD("Пароль должен быть не менее 8 символов длиной");

    private String title;

    Notices(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
