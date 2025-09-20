package hva.animal;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Species implements Serializable{
    // Attributes
    private String _key;
    private String _name;
    private List<String> _animalKeys = new ArrayList<>();

    // Constructor
    public Species(String key, String name) {
        _key = key;
        _name = name;
    }

    // Methods
    public void addAnimal(String animalKey) {_animalKeys.add(animalKey);}

    // Getters
    public String getKey() {return _key;}
    public String getName() {return _name;}

    // Setters
    public List<String> getAnimals() {return _animalKeys;}
}