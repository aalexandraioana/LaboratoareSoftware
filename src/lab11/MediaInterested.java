package lab11;

public class MediaInterested implements Observer{
    private String name;

    public MediaInterested(String name) {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
}