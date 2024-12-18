package objects.places;

import objects.Positional;

public class Place implements Positional{
    private final String name;
    private String[] properties;

    public Place(String name_in, String[] properties_in) {
        properties = properties_in;
        name = name_in;
    }

    public String getName() {
        return this.name;
    }
    public String[] getProperties() {
        return this.properties;
    }
    public Place getPlace() {
        return this;
    }
    @Override
    protected Place clone() throws CloneNotSupportedException {
        Place res = new Place(name, properties);
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
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + java.util.Arrays.hashCode(properties);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(this.hashCode() != obj.hashCode()) return false;

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Place place = (Place) obj;

        return name.equals(place.name)
                && java.util.Arrays.equals(properties, place.properties); 
    }
}
