package thuchanh3.src;

public class number {
    private String lastName; 
    private String telNumber;

    public number() {} 

    public number(String name, String num) {
        lastName = name;
        telNumber = num;
    }

    public String getLastName() { 
        return lastName;
    }

    public String getTelNumber() {
        return telNumber;
    }
}