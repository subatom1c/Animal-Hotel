package hva.animal;

import java.util.ArrayList;
import java.util.List;
import java.io.Serial;
import java.io.Serializable;

public class Animal implements Serializable{
    // Attributes
    private String _key;
    private String _name;
    private String _speciesKey;
    private List<String> _healthState = new ArrayList<>();
    private String _habitatKey;

    // Constructor
    public Animal(String key, String name,String speciesKey, String habitatKey){
        _key = key;
        _name = name;
        _speciesKey = speciesKey;
        _habitatKey = habitatKey;
    }

    // Methods
    public int calculateSatisfaction() {return 0;}
    public void transferToHabitat(String habitatKey){_habitatKey = habitatKey;}
    public void addHealthState(String healthState){}

    // Getters
    public String getKey(){return _key;}
    public String getName(){return _name;}
    public String getSpeciesKey(){return _speciesKey;}
    public String getHabitatKey(){return _habitatKey;}
    public List<String> getHealthState(){return _healthState;}

    // Setters
    public void setKey(String key){_key = key;}
    public void setName(String name){_name = name;}
    public void setSpeciesKey(String speciesKey){_speciesKey = speciesKey;}

    @Override
    public String toString(){
        if (_healthState.size() == 0){
            return "ANIMAL|" + _key + "|" + _name + "|" + _speciesKey + "|VOID|" + _habitatKey;
        }
        
        else {
            String history = String.join(",", _healthState);
            return "ANIMAL|" + _key + "|" + _name + "|" + _speciesKey + "|" + history + "|" + _habitatKey;
        }

    }
}
