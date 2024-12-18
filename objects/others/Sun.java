package objects.others;

public record Sun(String name, boolean isShining) {
    public Sun {
        if (!isShining) {
            throw new IllegalArgumentException("Sun must shine!");
        }
    }
    @Override
    public String toString() {
       return this.name + " {\n   isShining: "+  (isShining ? "true\n" : "false\n") + "}";
    }
}