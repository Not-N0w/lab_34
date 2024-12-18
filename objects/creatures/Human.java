package objects.creatures;

import objects.Positional;

public class Human extends Creature {

    private Object[] thoughts;
    private Emotion emotion;
    private boolean canTalk = true;
    public Human(String name, int age, String[] properties) {
        super(name, age, properties);
    }
    public void remember(Object ... objs) {
        this.thoughts = objs;
        String out = this.getName() + " вспомнил о:\n";
        for(Object obj : thoughts) {
            out += "    " + obj.toString() + "\n";
        }
        System.out.println(out);
    }
    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }
    public Emotion getEmotion() {
        return this.emotion;
    }
    public void think(Object ... objs) {
        String out = this.getName() + " подумал о ";
        for(Object obj : objs) {
            out += obj.toString() + " ";
        }
        System.out.println(out);
    }
    public void say(String message) {
        if(!canTalk) {
            System.out.println(this.getName() + " не может говорить!");
        }
        String out = this.getName() + " сказал: '" + message + ".'";
        System.out.println(out);
    }
    public void moveTo(Object obj) throws NotPositional {
        if(!(obj instanceof Positional)) {
            throw new NotPositional("К этому объекту нельзя подойти!");
        }
        Positional pos = (Positional) obj;
        this.setPlace(pos.getPlace());
        System.out.println(this.getName() + " подошел к " + this.getPlace().getName());
    }
    public void setCanTalk(boolean input) {
        this.canTalk = input;
    }
    public void know(Object ... objs) {
        this.thoughts = objs;
        String out = this.getName() + " знал о:\n";
        for(Object obj : thoughts) {
            out += obj.toString() + "\n";
        }
        System.out.println(out);
    }
    @Override 
    public String toString() {
        String out = this.getName() + " {\n";
        out += "    properties: [";        
        try {
            for(String prop : this.getProperties()) {
                out += "'" + prop + "', ";
            }
            out = out.substring(0, out.length() - 2);
            out += "]\n";
        }
        catch(Exception e) {
            out += "]\n";
        }
        try {
            out += "    place: " + this.getPlace().getName() + '\n';
        } catch (Exception e) {}
        out += "    age: " + Integer.toString(this.getAge());
        try {
            out += "\n    emotion: " + this.emotion.name() + "\n";
        }
        catch(Exception e) {
            out += "\n    emotion: null\n";
        }
        out += "    canTalk: " + (canTalk ? "True" : "False")+ "\n}";
        return out;
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (emotion != null ? emotion.hashCode() : 0) + (canTalk != false ? 1 : 0) + thoughts.hashCode();
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if(this.hashCode() != obj.hashCode()) return false;

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Human human = (Human) obj; 

        return super.equals(human) && emotion == human.emotion &&
               java.util.Arrays.equals(thoughts, human.thoughts) &&
               canTalk == human.canTalk;
    }
}
