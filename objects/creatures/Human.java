package objects.creatures;

import objects.Positional;

public class Human extends Creature {

    private Emotion _emotion;

    private String emotionToString(Emotion emotion) {
        switch (emotion) {
            case Emotion.Happy:
                return "счастливо";
            case Emotion.Sad:
                return "грустно";
            case Emotion.Lovely:
                return "в любви";
            case Emotion.Scary:
                return "в страхе";
            default:
                return "";
        }
    }

    public Human(String name, int age, String[] properties) {
        super(name, age, properties);
    }
    public String getStringEmotion() {
        return emotionToString(_emotion);
    }
    public void setEmotion(Emotion emotion) {
        this._emotion = emotion;
    }
    public void think(Object ... objs) {
        String out = this.getName() + " подумал о ";
        for(Object obj : objs) {
            out += obj.toString() + " ";
        }
        System.out.println(out);
    }
    public void say(String message) {
        String out = this.getName() + " сказал: '" + message + ".'";
        System.out.println(out);
    }
    public void go_to(Object obj) {
        Positional pos = (Positional) obj;
        this.setPlace(pos.getPlace());
        System.out.println(this.getName() + " подошел к " + this.getPlace().getName());
    }
    @Override 
    public String toString() {
        String out = super.toString();
        out = out.substring(0,out.length()-2);
        try {
            out += "\n    emotion: " + this.getStringEmotion() + "\n}";
        }
        catch(Exception e) {
            out += "\n    emotion: null\n}";
        }
        return out;
    }
}
