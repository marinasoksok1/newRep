package port;

public class Container {

    //• Content description (String with no more than 100 characters)
    //• Company that sends the container (String with no more than 20 characters)
    //• Company that receives the container (String with no more than 20 characters).

    int containerID;
    int weight;
    String countryOfOrigin;
    boolean isInspected;
    int priority;
   // enum priority{PR1,PR2,PR3};
    String contentPriority;
    String sender;
    String receiver;
    String plan;
    String description;


    public Container(int containerID) {
        this.containerID = containerID;
    }

    public Container(int containerID, int weight, String countryOfOrigin, String contentPriority) {
        this.containerID = containerID;
        this.weight = weight;
        this.countryOfOrigin = countryOfOrigin;
        this.contentPriority = contentPriority;
    }

    public Container(int containerID, int weight, String countryOfOrigin, boolean isInspected, String contentPriority, String sender, String receiver) {
        this.containerID = containerID;
        this.weight = weight;
        this.countryOfOrigin = countryOfOrigin;
        this.isInspected = isInspected;
        this.contentPriority = contentPriority;
        this.sender = sender;
        this.receiver = receiver;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public void setInspected(boolean inspected) {
        isInspected = inspected;
    }

    public void setContentPriority(String contentPriority) {
        this.contentPriority = contentPriority;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setContainerID(int containerID) {
        this.containerID = containerID;
    }

    public int getContainerID() {
        return containerID;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    void setInspection(boolean inspected) {
        isInspected = inspected;
    }

    //method to get data from the container
    String getDescription(){
        String information = "Container ID: " + containerID + "\n" +
                             "Weight: " + weight + "\n" +
                             "Country of origin: " + countryOfOrigin + "\n" +
                             "Content priority: " + contentPriority + "\n" +
                             "Sender: " + sender + "\n" +
                             "Receiver: " + receiver + "\n";
        return information;
    }

    void stackContainer(String plan, int containerID){

        System.out.println("making place for the container");
    }





}
