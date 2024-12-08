package objects.creatures;

import objects.Positional;

public class Turtle extends Creature{
    public Turtle(String name, int age, String[] properties) {
        super(name, age, properties);
    }
    public void go_to(Object obj) {
        Positional pos = (Positional) obj;
        this.setPlace(pos.getPlace());
        System.out.println(this.getName() + " приползла к " + this.getPlace().getName());
    }
}
