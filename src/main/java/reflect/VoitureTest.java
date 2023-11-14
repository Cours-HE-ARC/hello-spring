package reflect;

import java.lang.reflect.Field;

public class VoitureTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Voiture v1 = new Voiture("Twingo","Renault");
        Voiture v2 = new Voiture("Touran","VW");

        System.out.println(v1);
        System.out.println(v2);

        Field modelField = Voiture.class.getDeclaredField("model");
        modelField.setAccessible(true);
        modelField.set(v1, "Porsche");

        System.out.println(v1);
        System.out.println(v2);


    }
}
