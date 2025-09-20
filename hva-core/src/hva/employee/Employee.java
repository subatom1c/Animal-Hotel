package hva.employee;

public abstract class Employee {
    // Attributes
    private String _key;
    private String _name;
    private String _type;

    // Constructor
    public Employee(String key, String name, String type) {
        _key = key;
        _name = name;
        _type = type;
    }

    // Methods
    public abstract int satisfaction();
    public int work(int v){return 0;};


    // Getters
    public String getKey() {return _key;}
    public String getName() {return _name;}
    public String getType() {return _type;}

    // Setters
    public void setKey(String key) {_key = key;}
    public void setName(String name) {_name = name;}
    public void setType(String type) {_type = type;}

    @Override
    public String toString(){
        return _type + "|" + _key + "|" + _name;
    }

}
