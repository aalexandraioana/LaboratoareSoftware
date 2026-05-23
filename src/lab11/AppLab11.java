package lab11;

public class AppLab11 {
    public static void main()
    {
        YouTubeChannel channel = new YouTubeChannel("AllAI");

        MediaInterested observer1 = new MediaInterested("Seth");
        MediaInterested observer2 = new MediaInterested("Emma");
        MediaInterested observer3 = new MediaInterested("Lauren");
        MediaInterested observer4 = new MediaInterested("Kirk");
        MediaInterested observer5 = new MediaInterested("Sean");

        channel.addObserver(observer1);
        channel.addObserver(observer2);
        channel.addObserver(observer3);

        channel.uploadVideo("First thoughts on OpenAI's GPT-5");

        channel.removeObserver(observer1);
        channel.removeObserver(observer3);

        channel.uploadVideo("Top 3 LLMs to Use in May 2026");

        channel.addObserver(observer4);
        channel.addObserver(observer5);

        channel.uploadVideo("Is Google's Gemini falling behind?");
    }






}
