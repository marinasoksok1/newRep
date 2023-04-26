package port;

public class Hub {
    int IDNumber;
    double weight;
    StringBuilder description;
    String [][]location;

    public Hub(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    public Hub() {
    }

    public Hub(int IDNumber, double weight, StringBuilder description) {
        this.IDNumber = IDNumber;
        this.weight = weight;
        this.description = description;
    }

    public void setIDNumber(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public void setLocation(String[][] location) {
        this.location = location;
    }
    void pile(){
        System.out.println("Piled");
    }
}
