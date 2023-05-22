import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создание объектов класса Music с вводом параметров из командной строки
        Music[] musicArray = createMusicArrayFromCommandLine(10);

        // Сохранение созданных объектов в файл
        String filePath = "music.dat";
        saveMusicArrayToFile(musicArray, filePath);

        // Загрузка объектов из файла
        Music[] loadedMusicArray = loadMusicArrayFromFile(filePath);

        // Вывод информации о загруженных объектах
        displayMusicArray(loadedMusicArray);
    }

    private static Music[] createMusicArrayFromCommandLine(int count) {
        Scanner scanner = new Scanner(System.in);
        Music[] musicArray = new Music[count];

        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for Music #" + (i + 1));
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Sold Copies: ");
            int soldCopies = scanner.nextInt();
            System.out.print("Can download MP3 (true/false): ");
            boolean canDownloadMp3 = scanner.nextBoolean();
            scanner.nextLine(); // Считываем символ новой строки

            Music music = new Music(title, soldCopies, canDownloadMp3);
            musicArray[i] = music;
        }

        return musicArray;
    }

    private static void saveMusicArrayToFile(Music[] musicArray, String filePath) {
        for (Music music : musicArray) {
            MusicSerializationUtil.serializeMusic(music, filePath);
        }
    }

    private static Music[] loadMusicArrayFromFile(String filePath) {
        Music[] loadedMusicArray = new Music[10];

        for (int i = 0; i < 10; i++) {
            Music loadedMusic = MusicSerializationUtil.deserializeMusic(filePath);
            loadedMusicArray[i] = loadedMusic;
        }

        return loadedMusicArray;
    }

    private static void displayMusicArray(Music[] musicArray) {
        for (Music music : musicArray) {
            System.out.println("Title: " + music.getTitle());
            System.out.println("Sold Copies: " + music.getSoldCopies());
            System.out.println("Can download MP3: " + music.canDownloadMp3());
            System.out.println();
        }
    }
}