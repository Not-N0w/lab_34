package objects.creatures;

import objects.Positional;

public class Human extends Creature {

    private Emotion _emotion;
    public Human(String name, int age, String[] properties) {
        super(name, age, properties);
    }
    public void setEmotion(Emotion emotion) {
        this._emotion = emotion;
    }
    public Emotion getEmotion() {
        return this._emotion;
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
    public void go_to(Object obj) throws NotPositional {
        if(!(obj instanceof Positional)) {
            throw new NotPositional("К этому объекту нельзя подойти!");
        }
        Positional pos = (Positional) obj;
        this.setPlace(pos.getPlace());
        System.out.println(this.getName() + " подошел к " + this.getPlace().getName());
    }
    @Override 
    public String toString() {
        String out = super.toString();
        out = out.substring(0,out.length()-2);
        try {
            out += "\n    emotion: " + this._emotion.name() + "\n}";
        }
        catch(Exception e) {
            out += "\n    emotion: null\n}";
        }
        return out;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; 
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Human human = (Human) obj; 

        return super.equals(human) && (_emotion == human._emotion || (_emotion != null && _emotion.equals(human._emotion)));
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (_emotion != null ? _emotion.hashCode() : 0);
        return result;
    }
}
