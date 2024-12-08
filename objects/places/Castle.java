package objects.places;

public final class Castle extends Place{
    private boolean _isShining;
    private String[] _materials;

    public Castle(String name, String[] properties, String[] materials) {
        super(name, properties);
        _isShining = false;
        _materials = materials;
    }
    public void shine() {
        _isShining = true;
        System.out.println(this.getName() + " сверкал");
    }

    @Override 
    public String toString() {
        String out = this.getName() + " {\n";
        out += "    properties: [";
        for(String prop : this.getProperties()) {
            out += "'" + prop + "', ";
        }
        out = out.substring(0, out.length() - 2);
        out += "]\n";
        out += "    materials: [";
        for(String material : this._materials) {
            out += "'" + material + "', ";
        }
        out = out.substring(0, out.length() - 2);
        out += "]\n";
        out += "    isShining: " + (_isShining ? "true\n" : "false\n");
        out += "}";
        return out;
    }
}
