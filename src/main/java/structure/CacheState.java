package structure;

import java.util.ArrayList;
import java.util.List;

public class CacheState {

	private int cacheId;
	private int size;
	private List<Video> videos = new ArrayList<>();

	public CacheState(int cacheId, int size) {
		this.cacheId = cacheId;
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public int getCacheId() {
		return cacheId;
	}

	public int getAvailableSize() {
		int sizeCounted = size;
		for(Video video : videos){
			sizeCounted -= video.getSize();
		}
		return sizeCounted;
	}

	public void addVideo(Video video) {
		videos.add(video);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		CacheState that = (CacheState) o;

		if (cacheId != that.cacheId) {
			return false;
		}
		return size == that.size;
	}

	@Override
	public int hashCode() {
		int result = cacheId;
		result = 31 * result + size;
		return result;
	}

}
