package hva.employee;

import java.util.ArrayList;
import java.util.List;


public class Keeper extends Employee {
    // Attributes
    List<String> _habitatKeys = new ArrayList<>();

    // Constructor
    public Keeper(String key,String name, String type){super(key, name, type);}

    // Methods
    public int satisfaction(){
        return 0;
    }
    public void addResponsibility(String habitatKey){
        _habitatKeys.add(habitatKey);
    }
    public void removeResponsibility(String habitatKey){}


    // Getters
    public List<String> getHabitatKeys(){return _habitatKeys;}

    @Override
    public String toString(){
      if (_habitatKeys.size()==0){
            return super.toString();
        }
        return super.toString() + "|" + String.join(",", _habitatKeys);
        }
}
   