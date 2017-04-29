
package comicstreamer.messages;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComicContainer {

    @SerializedName("comics")
    @Expose
    private List<Comic> comics = null;
    @SerializedName("total_count")
    @Expose
    private Integer totalCount = 0;
    @SerializedName("page_count")
    @Expose
    private Integer pageCount = 0;

    public List<Comic> getComics() {
        return comics;
    }

    public void setComics(List<Comic> comics) {
        this.comics = comics;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

}
