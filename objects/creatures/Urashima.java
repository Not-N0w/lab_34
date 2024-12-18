package objects.creatures;

public final class Urashima extends Human {

    private boolean met_turtle;
    private boolean isHomeSick = false;
    
    public Urashima(String name, int age, String[] properties) {
        super(name, age, properties);
        met_turtle = false;
    }

    public void setHomeSick(boolean input) {
        this.isHomeSick = input;
    }
    public void live(int years, Human ... with) {
        super.live(years);
        this.setEmotion(Emotion.Happy);
        String out = this.getName() + " прожил " + this.getEmotion().getTranslation() + " ";
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
    public String toString() {
        String out = super.toString();
        out = out.substring(0,out.length()-1);
        out += "    isHomeSick: " + (isHomeSick ? "True" : "False")+ "\n}";
        return out;
    }
    @Override
    public void remember(Object ... objs) {
        if(!met_turtle) return;
        super.remember(objs);
    }
    @Override
    public void moveTo(Object obj) throws NotPositional {
        try {
            Turtle tmp = (Turtle)obj;
            met_turtle = true;
        }
        catch(Exception e) {}

        super.moveTo(obj);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (met_turtle != false ? 1 : 0) + (isHomeSick != false ? 1 : 0) ;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if(this.hashCode() != obj.hashCode()) return false;

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Urashima urashima = (Urashima) obj; 

        return super.equals(urashima) && met_turtle == urashima.met_turtle && isHomeSick == urashima.isHomeSick;
    }
}