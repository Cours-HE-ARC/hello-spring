package reflect;

public class Voiture {

    private String nom;
    private String model;

    public Voiture(String nom, String model){
        this.nom = nom;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "nom='" + nom + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
