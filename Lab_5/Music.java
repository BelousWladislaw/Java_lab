import java.io.*;

public class Music {
    private String title;
    private int soldCopies;
    private boolean canDownloadMp3;

    public Music(String title, int soldCopies, boolean canDownloadMp3) {
        this.title = title;
        this.soldCopies = soldCopies;
        this.canDownloadMp3 = canDownloadMp3;
    }

    public String getTitle() {
        return title;
    }

    public int getSoldCopies() {
        return soldCopies;
    }

    public boolean canDownloadMp3() {
        return canDownloadMp3;
    }

    public static void main(String[] args) {
        Music[] musicArray = new Music[10];

        try {
            // Чтение параметров создания объектов из файла
            readMusicParametersFromFile(musicArray, "music_parameters.txt");

            // Подсчет общего количества проданных копий
            int totalSoldCopies = calculateTotalSoldCopies(musicArray);
            System.out.println("Total sold copies: " + totalSoldCopies);

            // Подсчет количества произведений, которые можно скачать в mp3
            int mp3DownloadableCount = calculateMp3DownloadableCount(musicArray);
            System.out.println("MP3 downloadable count: " + mp3DownloadableCount);
        } catch (IOException e) {
            System.out.println("Error reading music parameters from file: " + e.getMessage());
        } catch (InvalidMusicParametersException e) {
            System.out.println("Invalid music parameters: " + e.getMessage());
        }
    }

    private static void readMusicParametersFromFile(Music[] musicArray, String filePath) throws IOException, InvalidMusicParametersException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            for (int i = 0; i < musicArray.length; i++) {
                String line = reader.readLine();
                if (line == null) {
                    throw new InvalidMusicParametersException("Not enough lines in the file");
                }

                String[] params = line.split(",");
                if (params.length != 3) {
                    throw new InvalidMusicParametersException("Invalid number of parameters");
                }

                String title = params[0].trim();
                int soldCopies = Integer.parseInt(params[1].trim());
                boolean canDownloadMp3 = Boolean.parseBoolean(params[2].trim());

                musicArray[i] = new Music(title, soldCopies, canDownloadMp3);
            }
        }
    }

    private static int calculateTotalSoldCopies(Music[] musicArray) {
        int totalSoldCopies = 0;
        for (Music music : musicArray) {
            totalSoldCopies += music.getSoldCopies();
        }
        return totalSoldCopies;
    }

    private static int calculateMp3DownloadableCount(Music[] musicArray) {
        int mp3DownloadableCount = 0;
        for (Music music : musicArray) {
            if (music.canDownloadMp3()) {
                mp3DownloadableCount++;
            }
        }
        return mp3DownloadableCount;
    }
}
