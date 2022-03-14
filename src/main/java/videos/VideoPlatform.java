package videos;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VideoPlatform {

    private List<Channel> channels = new ArrayList<>();

    public List<Channel> getChannels() {
        return Collections.unmodifiableList(channels);
    }

    public void readDataFromFile(Path path) {
        try (Scanner scanner = new Scanner(path)){
            scanner.nextLine();
            while (scanner.hasNext()) {
                addChannel(scanner.nextLine());
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot open file for read!");
        }
    }

    private void addChannel(String line) {
        String[] parts = line.split(";");
        String channel = parts[0];
        int subscriptions = Integer.parseInt(parts[1]);
        int numberOfVideos = Integer.parseInt(parts[2]);
        channels.add(new Channel(channel, subscriptions, numberOfVideos));
    }

    public int calculateSumOfVideos() {
        return channels.stream().mapToInt(Channel::getNumberOfVideos).sum();
    }
}
