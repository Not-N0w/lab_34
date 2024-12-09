package objects.creatures;

import objects.Positional;
import objects.places.Place;

public abstract class Creature implements Positional{
    private String[] _properties;
    private final String _name;
    private Place _place;
    private int _age;


    public Creature(String name, int age, String[] properties) {
        _properties = properties;
        _name = name;
        _age = age;
    }

    public abstract void go_to(Object obj) throws NotPositional;
    public void setPlace(Place place) {
        this._place = place;
    }
    public String getName() {
        return this._name;
    }
    public int getAge() {
        return this._age;
    }
    public String[] getProperties() {
        return this._properties.clone();
    }
    public Place getPlace() {
        if(this._place == null) {
            Place result = new Place(_name, null);
            return result;
        }
        else {
            return this._place;
        }
    }
    public void live(int years) {
        this._age += years;
    }
    @Override 
    public String toString() {
        String out = this.getName() + " {\n";
        out += "    properties: [";        
        try {
            for(String prop : this._properties) {
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
        out += "    age: " + Integer.toString(_age) + "\n";
        out += "}";
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
        Creature creature = (Creature) obj;
        return _age == creature._age
                && _name.equals(creature._name)
                && (_place == null ? creature._place == null : _place.equals(creature._place))
                && java.util.Arrays.equals(_properties, creature._properties);
    }
    @Override
    public int hashCode() {
        int result = _name.hashCode();
        result = 31 * result + _age;
        result = 31 * result + (_place != null ? _place.hashCode() : 0);
        result = 31 * result + java.util.Arrays.hashCode(_properties);
        return result;
    }

}
