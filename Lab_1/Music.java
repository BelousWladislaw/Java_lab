

class Music {
    private String title;
    private int copiesSold;
    private boolean canDownloadMp3;

    public Music(String title, int copiesSold, boolean canDownloadMp3) {
        this.title = title;
        this.copiesSold = copiesSold;
        this.canDownloadMp3 = canDownloadMp3;
    }

    public Music() {
        this.title = "Default Title";
        this.copiesSold = 0;
        this.canDownloadMp3 = false;
    }

    public String getTitle() {
        return title;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public boolean canDownloadMp3() {
        return canDownloadMp3;
    }
}