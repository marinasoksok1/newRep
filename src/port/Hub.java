package port;

import java.util.Objects;

public class Hub {
    //1. ATTRIBUTES FOR THE HUB (MATRIX)
    protected String hubID;
    private final int rows = 10; //Rows of the hub
    private final int columns = 12; //Columns of the hub
    private Container[][] hub = new Container[rows][columns];
    private boolean priority1full, priority2full, priority3full; //Variables to inform if each of the priorities columns are full
    private boolean full; //Variable that informs it the hub is full or not

    //2. CONSTRUCTORS
    //2.1. BLANK CONSTRUCTOR (CREATES EMPTY MATRIX WITH NO CONTAINERS)
    Hub() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                hub[i][j] = new Container();
            }
        }
    }

    //3. SETTERS AND GETTERS
    public void setHub(Container[][] hub) {
        this.hub = hub;
    }
    public Container[][] getHub() {
        return this.hub;
    }
    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }

    public String getHubID() {
        return hubID;
    }

    public boolean isPriority1full() {
        return priority1full;
    }
    public void setPriority1full(boolean priority1full) {
        this.priority1full = priority1full;
    }
    public boolean isPriority2full() {
        return priority2full;
    }
    public void setPriority2full(boolean priority2full) {
        this.priority2full = priority2full;
    }
    public boolean isPriority3full() {
        return priority3full;
    }
    public void setPriority3full(boolean priority3full) {
        this.priority3full = priority3full;
    }
    public boolean isFull() {
        return full;
    }
    public void setFull(boolean full) {
        this.full = full;
    }

    //4. toString METHOD THAT RETURNS A PLAN OF THE HUB
    public String toString() {
        String hubPlan = ""; //String representing the plan of the hub

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                hubPlan += this.hub[i][j].getContainerID() + "   "; //Identifier of the container and Space to represent each column
            }
            if (i != rows -1) hubPlan += "\n"; //New line to represent each row + If statement to prevent new line after completing all rows
        }
        return hubPlan;
    }

    //5. METHOD TO STACK A CONTAINER ACCORDING TO ITS PRIORITY
    public String stackContainer(Container container) {
        if (container.getPriority() == 1) { //If priority level is 1 (stack in column 1)
            for (int i = 0; i < rows; i++) {
                if (this.hub[rows - i - 1][0].getContainerID() == 0) { //[ROWS - i - 1] means that it starts searching for free slot from down and [0] means first column
                    this.hub[rows - i - 1][0] = container;
                    System.out.println("Container of priority 1 successfully stored in column 1, row " + (i + 1) + ".");
                    return "Container of priority 1 successfully stored in column 1, row " + (i + 1) + "."; //Exit method after success
                }
            }
            System.out.println("Could not store container of priority 1 in column 1 (column already full).");
            this.priority1full = true;
            if (priority2full && priority3full) this.full = true; //Test only for priorities 2 and 3 as, at this point, priority 1 will always be true
            return "Could not store container of priority 1 in column 1 (column already full)."; //Exit method after fail
        } else if (container.getPriority() == 2) { //If priority level is 2 (stack in column 2)
            for (int i = 0; i < rows; i++) {
                if (this.hub[rows - i - 1][1].getContainerID() == 0) { //[ROWS - i - 1] means that it starts searching for free slot from down and [1] means second column
                    this.hub[rows - i - 1][1] = container;
                    System.out.println("Container of priority 2 successfully stored in column 2, row " + (i + 1) + ".");
                    return "Container of priority 2 successfully stored in column 2, row " + (i + 1) + "."; //Exit method after success
                }
            }
            System.out.println("Could not store container of priority 2 in column 2 (column already full).");
            this.priority2full = true;
            if (priority1full && priority3full) this.full = true;
            return "Could not store container of priority 2 in column 2 (column already full)."; //Exit method after fail
        } else { //If priority level is 3 (stack in any other column, from 3-12)
            for (int i = 2; i < columns; i++) { //i = 2 as it starts searching from column 3 to 12
                for (int j = 0; j < rows; j++) {
                    if (this.hub[rows - j - 1][i].getContainerID() == 0) { //[ROWS - j - 1] means that it starts searching for free slot from down and [i] means i column
                        this.hub[rows - j - 1][i] = container;
                        System.out.println("Container of priority 3 successfully stored in column " + i + ", row " + (j + 1) + ".");
                        return "Container of priority 3 successfully stored in column " + i + ", row " + (j + 1) + "."; //Exit method after success
                    }
                }
            }
        }
        System.out.println("Could not store container of priority 3 in any column (columns 3-12 already full).");
        this.priority3full = true;
        if (priority1full && priority2full) this.full = true;
        return "Could not store container of priority 3 in any column (columns 3-12 already full).";
    }

    //6. METHOD TO REMOVE A CONTAINER FROM A DESIRED COLUMN
    public String removeContainer(int column) {
        for (int i = 0; i < rows; i++) {
            if (this.hub[i][column - 1].getContainerID() != 0) { //Checks for a row with a container in the specified column
                System.out.println("Successfully removed container with ID " + this.hub[i][column - 1].getContainerID() + " from column " + column);
                this.hub[i][column - 1] = new Container(); //Sets that slot to free (container with ID = 0)
                return "Successfully removed upper container from column " + column; //Exit method after success
            }
        }
        System.out.println("Could not remove any container from column " + column + " as this column is already empty.");
        return "Could not remove any container from column " + column + " as this column is already empty.";
    }

    //7. METHOD TO DISPLAY ALL DATA FROM A CONTAINER BASED ON ITS IDENTIFIER
    public String displayContainerData(int identifier) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (this.hub[i][j].getContainerID() == identifier) { //Checks if the specified ID is the same as that of any container from the hub
                    return "Displaying data for container with ID " + identifier + ":\n\n> Priority level: " + this.hub[i][j].getPriority() + "\n> Description: " + this.hub[i][j].getDescription() + "\n> Weight: " + this.hub[i][j].getWeight() + " tons \n> Country of origin: " + this.hub[i][j].getCountryOfOrigin() + "\n> Company that sends it: " + this.hub[i][j].getSender() + "\n> Company that receives it: " + this.hub[i][j].getReceiver() + "\n> Has been inspected? " + this.hub[i][j].isInspected();
                }
            }
        }
        System.out.println("Could not find any container with that ID.");
        return "Could not find any container with that ID.";
    }

    //8. METHOD TO CALCULATE THE NUMBER OF CONTAINERS FROM A SPECIFIED COUNTRY
    public int countContainersFromCountry(String country) {
        int count = 0; //Variable to keep track of how many times a container from that country has been found
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (Objects.equals(this.hub[i][j].getCountryOfOrigin(), country)) { //Checks if the specified country is the same as that of any container from the hub
                    count++; //Increments the count by 1
                }
            }
        }
        return count; //Return the number of containers from that country
    }
}
