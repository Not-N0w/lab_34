package objects.creatures;

public final class Urashima extends Human {

    private boolean _met_turtle;
    private Object[] _thoughts;
    
    
    public Urashima(String name, int age, String[] properties) {
        super(name, age, properties);
        _met_turtle = false;
    }

    public void remember(Object ... objs) {
        if(!_met_turtle) return;
        this._thoughts = objs;
        String out = this.getName() + " вспомнил о:\n";
        for(Object obj : _thoughts) {
            out += "    " + obj.toString() + "\n";
        }
        System.out.println(out);
    }
    public void live(int years, Human ... with) {
        super.live(years);
        this.setEmotion(Emotion.Happy);
        String out = this.getName() + " прожил " + this.getEmotion().name() + " ";
        out += Integer.toString(years) + " лет c ";
        for(Creature who : with) {
            try {
                Human tmp = (Human) who;
                tmp.setEmotion(Emotion.Happy);
            }
            catch(Exception e) {}
            out += who.getName() + ", ";
        }
        System.out.println(out.substring(0, out.length()-2));
    }
    @Override
    public void go_to(Object obj) {
        try {
            Turtle tmp = (Turtle)obj;
            _met_turtle = true;
        }
        catch(Exception e) {}
        super.go_to(obj);
    }


}