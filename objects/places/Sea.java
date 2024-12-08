package objects.places;

public final class Sea extends Place{
    private boolean _isShining;
    private boolean _isSparking;

    public Sea(String name, String[] properties) {
        super(name, properties);
        _isSparking = false;
        _isShining = false;
    }
    public void spark() {
        _isSparking = true;
        System.out.println(getName() + " искрилось");
    }
    public void shine() {
        _isShining= true;
        System.out.println(getName() + " сияло");
    }
    @Override 
    public String toString() {
        String out = this.getName() + " {\n";
        out += "    isShining: " + (_isShining ? "true" : "false") + "\n";        
        out += "    isSparking: " + (_isSparking ? "true" : "false") + "\n";
        out += "}";
        return out;
    }
}
