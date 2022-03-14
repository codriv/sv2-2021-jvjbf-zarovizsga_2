package videos;

public class Channel {

    private String channel;
    private int subscriptions;
    private int numberOfVideos;

    public Channel(String channel, int subscriptions, int numberOfVideos) {
        this.channel = channel;
        this.subscriptions = subscriptions;
        this.numberOfVideos = numberOfVideos;
    }

    public String getChannelName() {
        return channel;
    }

    public int getSubscriptions() {
        return subscriptions;
    }

    public int getNumberOfVideos() {
        return numberOfVideos;
    }
}
