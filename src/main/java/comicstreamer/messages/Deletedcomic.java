package comicstreamer.messages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deletedcomic {

    @SerializedName("comic_id")
    @Expose
    private Integer comicId = 0;
    @SerializedName("id")
    @Expose
    private Integer id = 0;
    @SerializedName("ts")
    @Expose
    private String ts;

    public Integer getComicId() {
        return comicId;
    }

    public void setComicId(Integer comicId) {
        this.comicId = comicId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

}