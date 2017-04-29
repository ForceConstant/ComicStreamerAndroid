package comicstreamer.messages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DbInfo {

    @SerializedName("comic_count")
    @Expose
    private Integer comicCount = 0;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created")
    @Expose
    private String created;

    public Integer getComicCount() {
        return comicCount;
    }

    public void setComicCount(Integer comicCount) {
        this.comicCount = comicCount;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

}