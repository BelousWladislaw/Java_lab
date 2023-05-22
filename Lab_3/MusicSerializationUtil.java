import java.io.*;

public class MusicSerializationUtil {
    public static void serializeMusic(Music music, String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(music);
            System.out.println("Music object serialized and saved to file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error occurred during serialization: " + e.getMessage());
        }
    }

    public static Music deserializeMusic(String filePath) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Music music = (Music) inputStream.readObject();
            System.out.println("Music object deserialized from file: " + filePath);
            return music;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occurred during deserialization: " + e.getMessage());
            return null;
        }
    }
}