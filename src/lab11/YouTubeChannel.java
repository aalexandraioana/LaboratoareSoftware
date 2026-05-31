package lab11;
import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject{
    private String channelName;
    private List<Observer> observers;

    public YouTubeChannel(String channelName)
    {
        this.channelName = channelName;
        this.observers = new ArrayList<>();
    }

    public void uploadVideo(String title)
    {
        System.out.println(channelName + " uploaded a new video: " + title);
        notifyObservers("New video by " + channelName + ": " + title);
    }

    @Override
    public void addObserver(Observer observer)
    {
          if(!observers.contains(observer))
          {
              observers.add(observer);

          }
          else {
              System.out.println("Observer already added!");
          }
    }

    @Override
    public void removeObserver(Observer observer)
    {
        if(observers.contains(observer))
        {
            observers.remove(observer);
        }
        else
        {
            System.out.println("Observer not registered!");
        }

    }

    @Override
    public void notifyObservers(String message)
    {
        observers.stream()
                .forEach(observer -> observer.update(message));
    }
}