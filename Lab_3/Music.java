import java.io.Serializable;

public class Music implements Serializable {
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
}