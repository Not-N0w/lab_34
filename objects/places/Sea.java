package objects.places;

import objects.creatures.Human;

public final class Sea extends Place{
    private boolean isShining;
    private boolean isSparking;

    public Sea(String name, String[] properties) {
        super(name, properties);
        isSparking = false;
        isShining = false;
    }
    public void spark() {
        isSparking = true;
        System.out.println(getName() + " искрилось");
    }
    public void shine() {
        isShining= true;
        System.out.println(getName() + " сияло");
    }
    @Override 
    public String toString() {
        String out = this.getName() + " {\n";
        out += "    isShining: " + (isShining ? "true" : "false") + "\n";        
        out += "    isSparking: " + (isSparking ? "true" : "false") + "\n";
        out += "}";
        return out;
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isShining != false ? 1: 0) + (isSparking != false ? 1: 0) ;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if(this.hashCode() != obj.hashCode()) return false;

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Sea sea = (Sea) obj; 

        return super.equals(sea) &&
               this.isShining == sea.isShining && this.isSparking == sea.isSparking;
    }
    
}
