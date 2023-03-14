package port;

public class Container {
    int IDNumber;
    double weight;
    StringBuilder description;

    public Container(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    public Container() {
    }

    public Container(int IDNumber, double weight, StringBuilder description) {
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
}
