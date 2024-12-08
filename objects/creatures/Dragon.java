package objects.creatures;

import objects.Positional;
import objects.places.Place;

public class Dragon extends Creature {
    private Place _guarding;

    public Dragon(String name, int age, String[] properties) {
        super(name, age, properties);
        _guarding = null;
    }
    public void guard(Place place) {
        _guarding = place;
        String out = this.getName() + " охраняет " + place.getName();
        System.out.println(out);
    }
    @Override 
    public String toString() {
        String out = this.getName() + " {\n";
        
        try {
            out += "    properties: [";
            for(String prop : this.getProperties()) {
                out += "'" + prop + "', ";
            }
            out = out.substring(0, out.length() - 2);
            out += "]\n";
        }
        catch(Exception e) {
            out = this.getName() + " {\n";
        }
        try {
            out += "    place: " + this.getPlace().getName() + '\n';
        } catch (Exception e) {}
        try {
            out += "    guarding: " + this._guarding.getName() + '\n';
        } catch (Exception e) {}
        out += "    age: " + Integer.toString(this.getAge()) + "\n";
        out += "}";
        return out;
    }
    public void go_to(Object obj) {
        Positional pos = (Positional) obj;
        this.setPlace(pos.getPlace());
        System.out.println(this.getName() + " подлетел к " + this.getPlace().getName());
    }
}
