package nap_international.group_project.MusicScreen;
public class Info {
    int button;
    int button2;
    String title;
    int song;

    public Info(int button,int button2, String title, int song) {
        this.button = button;
        this.button2 = button2;
        this.title = title;
        this.song = song;
    }

    public int getButton() {
        return button;
    }

    public void setButton(int button) {
        this.button = button;
    }

    public int getButton2() {
        return button2;
    }

    public void setButton2(int button2) {
        this.button2 = button2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }
}
