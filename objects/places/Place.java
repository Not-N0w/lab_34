package objects.places;

import objects.Positional;

public class Place implements Positional{
    private final String _name;
    private String[] _properties;

    public Place(String name, String[] properties) {
        _properties = properties;
        _name = name;
    }

    public String getName() {
        return this._name;
    }
    public String[] getProperties() {
        return this._properties;
    }
    public Place getPlace() {
        return this;
    }
    @Override
    protected Place clone() throws CloneNotSupportedException {
        Place res = new Place(_name, _properties);
        return res;
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
        catch (Exception e) {
            out = this.getName() + " {";
        }
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
        Place place = (Place) obj;

        return _name.equals(place._name)
                && java.util.Arrays.equals(_properties, place._properties); 
    }

}
