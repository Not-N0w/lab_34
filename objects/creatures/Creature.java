package objects.creatures;

import java.util.ArrayList;

import objects.Positional;
import objects.places.Place;

public abstract class Creature implements Positional{
    private String[] properties;
    private final String name;
    private Place place;
    private int age;


    public Creature(String name_in, int age_in, String[] properties_in) {
        properties = properties_in;
        name = name_in;
        age = age_in;
    }
    public abstract void moveTo(Object obj) throws NotPositional;
    
    public void follow(Creature ... creatures ) throws NotPositional {
        Place place =creatures[0].getPlace();
        
        String out = this.getName() + " последовал за ";
        for(Creature obj : creatures) {
            if(!(obj instanceof Positional)) {
                throw new NotPositional("К этому объекту нельзя подойти!");
            }
            else {
                if(place != obj.getPlace()) {
                    return;
                }
                out += obj.getName() + " ";
            }
        }
        this.setPlace(place);
        out += "и очутился у " + place.getName() + ".";

        System.out.println(out);
    }
    public void setPlace(Place place) {
        this.place = place;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String[] getProperties() {
        return this.properties.clone();
    }
    public Place getPlace() {
        if(this.place == null) {
            Place result = new Place(name, null);
            return result;
        }
        else {
            return this.place;
        }
    }
    public void live(int years) {
        this.age += years;
    }


}
