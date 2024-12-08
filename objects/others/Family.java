package objects.others;

public record Family(String _name) {
    @Override
    public final String toString() {
        return this._name() + " {}";
    }
}
