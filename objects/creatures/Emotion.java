package objects.creatures;

public enum Emotion {
    Happy("счастливо"),
    Sad("грустно"),
    Lovely("в любви"),
    Scary("в страхе");

    private final String translation;

    Emotion(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}