        package comicstreamer.messages;

        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Deleted {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount = 0;
    @SerializedName("page_count")
    @Expose
    private Integer pageCount = 0;
    @SerializedName("deletedcomics")
    @Expose
    private List<Deletedcomic> deletedcomics = null;

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

    public List<Deletedcomic> getDeletedcomics() {
        return deletedcomics;
    }

    public void setDeletedcomics(List<Deletedcomic> deletedcomics) {
        this.deletedcomics = deletedcomics;
    }

}