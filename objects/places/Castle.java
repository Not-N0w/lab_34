package objects.places;

public final class Castle extends Place{
    private boolean isShining;
    private String[] materials;

    public Castle(String name_in, String[] properties_in, String[] materials_in) {
        super(name_in, properties_in);
        isShining = false;
        materials = materials_in;
    }
    public void shine() {
        isShining = true;
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
        for(String material : this.materials) {
            out += "'" + material + "', ";
        }
        out = out.substring(0, out.length() - 2);
        out += "]\n";
        out += "    isShining: " + (isShining ? "true\n" : "false\n");
        out += "}";
        return out;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isShining != false ? 1: 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(this.hashCode() != obj.hashCode()) return false;

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Castle castle = (Castle) obj;

        return super.equals(castle)
                && java.util.Arrays.equals(this.materials, castle.materials); 
    }
}
