package nap_international.group_project.RecyclerScreen;

public class VideoDataClass {
    private String title;
    private String likes;
    private String Views;
    private int image;
    private String Address;

    public VideoDataClass(String title, String likes, String views, int image, String address) {
        this.title = title;
        this.likes = likes;
        this.Views = views;
        this.image = image;
        this.Address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getViews() {
        return Views;
    }

    public void setViews(String views) {
        Views = views;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
