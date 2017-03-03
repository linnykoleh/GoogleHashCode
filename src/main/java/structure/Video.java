package structure;

public class Video {

    private int id;
    private int size;

    public Video(int id, int size) {
        this.id = id;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }
}
