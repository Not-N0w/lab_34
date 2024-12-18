package objects.creatures;

import objects.Positional;
import objects.places.Place;

public class Dragon extends Creature {
    private Place guarding;

    public Dragon(String name, int age, String[] properties) {
        super(name, age, properties);
        guarding = null;
    }
    public void guard(Place place) {
        guarding = place;
        String out = this.getName() + " охраняет " + place.getName();
        System.out.println(out);
    }
    public void moveTo(Object obj) throws NotPositional {
        if(!(obj instanceof Positional)) {
            throw new NotPositional("К этому объекту нельзя подойти!");
        }
        Positional pos = (Positional) obj;
        this.setPlace(pos.getPlace());
        System.out.println(this.getName() + " подлетел к " + this.getPlace().getName());
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
        } catch (Exception e) { out += "    place: null\n"; }
        try {
            out += "    guarding: " + this.guarding.getName() + '\n';
        } catch (Exception e) { out += "    guarding: null\n"; }
        out += "    age: " + Integer.toString(this.getAge()) + "\n";
        out += "}";
        return out;
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + guarding.hashCode();
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if(this.hashCode() != obj.hashCode()) return false;

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Dragon dragon = (Dragon) obj; 

        return super.equals(dragon) && this.guarding.equals(dragon.guarding);
    }
}
