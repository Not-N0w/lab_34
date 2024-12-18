package objects.creatures;

import objects.Positional;

public class Turtle extends Creature{
    public Turtle(String name, int age, String[] properties) {
        super(name, age, properties);
    }
    public void moveTo(Object obj) {
        Positional pos = (Positional) obj;
        this.setPlace(pos.getPlace());
        System.out.println(this.getName() + " приползла к " + this.getPlace().getName());
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
        out += "    age: " + Integer.toString(this.getAge()) + "\n";
        out += "}";
        return out;
    }
}
