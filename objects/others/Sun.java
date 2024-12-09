package objects.others;

public record Sun(String _name, boolean _isShining) {
    public Sun {
        if (!_isShining) {
            throw new IllegalArgumentException("Sun must shine!");
        }
    }
    @Override
    public String toString() {
       return this._name + " {\n   isShining: "+  (_isShining ? "true\n" : "false\n") + "}";
    }
}