package hva.employee;

import java.util.ArrayList;
import java.util.List;



public class Veterinarian extends Employee {
    // Attributes
    List<String> _speciesKeys = new ArrayList<>();

    // Constructor
    public Veterinarian(String key,String name, String type){super(key, name, type);}

    // Methods
    public int satisfaction(){
        return 0;
    } // nono uml
    public void addResponsibility(String speciesKey){
        _speciesKeys.add(speciesKey);
    }
    public void removeResponsibility(String speciesKey){} //NoResponsibilityException se não tiver
    public int population(){return 0;}// for species e ver lista de naimais}
    public int nVeterinarians(){return 0;}

    // Getters
    public List<String> getSpeciesKeys() {return _speciesKeys;}

    @Override
    public String toString(){
        if (_speciesKeys.size()==0){
            return super.toString();
        }
        return super.toString() + "|" + String.join(",", _speciesKeys);
    }
}