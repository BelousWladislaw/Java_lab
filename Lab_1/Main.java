import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Music[] musicArray = new Music[10];
        musicArray[0] = null;
        musicArray[1] = new Music();  // объект, созданный конструктором по умолчанию
        musicArray[2] = new Music("Song A", 100, true);
        musicArray[3] = new Music("Song B", 50, false);
        musicArray[4] = new Music("Song C", 200, true);
        musicArray[5] = new Music("Song D", 75, false);
        musicArray[6] = new Music("Song E", 300, true);
        musicArray[7] = new Music("Song F", 125, false);
        musicArray[8] = new Music("Song G", 250, true);
        musicArray[9] = new Music("Song H", 150, false);

        // Сортировка массива по возрастанию
        Arrays.sort(musicArray, Comparator.nullsLast(
                Comparator.comparing(Music::getTitle).thenComparingInt(Music::getCopiesSold)
        ));

        // Вывод массива 3 раза
        for (int i = 0; i < 3; i++) {
            for (Music music : musicArray) {
                if (music != null) {
                    System.out.println("Title: " + music.getTitle() +
                            ", Copies Sold: " + music.getCopiesSold() +
                            ", Can Download MP3: " + music.canDownloadMp3());
                } else {
                    System.out.println("null");
                }
            }
            System.out.println();
        }
    }
}