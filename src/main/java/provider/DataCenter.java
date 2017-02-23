package provider;

import structure.Video;

import java.util.List;

/**
 * Class for working with video
 */
public class DataCenter {

    private List<Video> videos;

    public DataCenter(List<Video> videos) {
        this.videos = videos;
    }

    public Video getVideoById(int id){
        return videos.stream().filter(vidos -> vidos.getId() == id).findFirst().get();
    }
}
