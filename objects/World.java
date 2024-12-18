package objects;

import java.util.ArrayList;
import java.util.Random;

import objects.creatures.Dragon;
import objects.creatures.Fish;
import objects.creatures.NotPositional;
import objects.creatures.Princess;
import objects.creatures.Turtle;
import objects.creatures.Urashima;
import objects.others.Family;
import objects.others.Sun;
import objects.places.Castle;
import objects.places.Sea;
import objects.places.Village;
import objects.creatures.Fish;


public class World {
    Random random = new Random();


    public void run() {
        Castle castle = new Castle("Дворец", new String[]{"подводный"}, new String[]{"из кораллов", "из жемчуга"});
        ArrayList<Dragon> dragons = new ArrayList<Dragon>() {{
                        add(new Dragon("Дракон1", random.nextInt(100) + 1, new String[]{"с нежно-бархатной кожей"}));
                        add(new Dragon("Дракон2", random.nextInt(100) + 1, new String[]{"с нежно-бархатной кожей"}));
        }};
        Urashima urashima = new Urashima("Урашима", random.nextInt(20) + 20, null);
        Princess princess = new Princess("Принцесса", random.nextInt(20) + 20, new String[]{"красавица"});
        Sea sea = new Sea("Море", null);
        Turtle turtle = new Turtle("Черепаха", random.nextInt(10) + 1, new String[]{"маленькая"});
        Village village = new Village("Деревня", null);
        Family family = new Family("Семья");
        Fish fish = new Fish("Рыбка", random.nextInt(4) + 1, new String[]{"хрустальная", "с золотыми плавниками"});

        //Story
        System.out.println(urashima.toString());
        System.err.println();
        System.out.println(princess.toString());
        urashima.setCanTalk(false);
        System.out.println( "-> " + urashima.toString());

        System.out.println("-".repeat(50) + "\n");

        urashima.setCanTalk(true);
        urashima.say("Да");

        System.err.println();
        System.out.println(fish.toString());

        try {
            princess.moveTo(castle);
        } catch(NotPositional ex) {
            System.out.println(ex.getMessage());
        }

        try {
            urashima.follow(princess);
        } catch(NotPositional ex) {
            System.out.println(ex.getMessage());
        }

        try {
            fish.follow(urashima, princess);
        } catch(NotPositional ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("-".repeat(50) + "\n");

        System.out.println(castle.toString());
        System.out.println("\n");
        castle.shine();
        System.out.println( "-> " + castle.toString());
        System.out.println("\n");
        
        for(Dragon dragon : dragons) {
            dragon.setPlace(castle);
            System.out.println(dragon.toString());
            dragon.guard(castle);
            System.out.println( "-> " + dragon.toString());
            System.out.println("\n");
        }
        System.out.println("-".repeat(50) + "\n");

        urashima.setPlace(castle);
        princess.setPlace(castle);
        System.out.println(urashima.toString());
        System.out.println("\n");

        System.out.println(princess.toString());
        System.out.println("\n");

        urashima.live(4, princess);
        
        System.out.println( "-> " +urashima.toString());

        System.out.println("-> " +princess.toString());
        System.out.println("\n");

        System.out.println("-".repeat(50) + "\n");

        try {
            Sun sun = new Sun("Солнце", (Math.random() > 0.5 ? true : false));
            System.out.println(sun.toString());
            System.out.println("\n");
            sea.shine();
            sea.spark();
            System.out.println( "-> " +sea.toString());
        }
        catch(IllegalArgumentException e) {
            System.out.println(sea.toString());
        }

        System.out.println("\n");
        System.out.println("-".repeat(50) + "\n");

        System.out.println(turtle.toString());
        System.out.println("\n");

        if(Math.random() > 0.5) {
            try {
                urashima.moveTo(turtle);
            } catch(NotPositional ex) {
                System.out.println(ex.getMessage());
            }
        }
        urashima.remember(family,village);

        urashima.setHomeSick(true);
        princess.know(urashima);
    }
}
