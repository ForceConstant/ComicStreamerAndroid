
package comicstreamer.messages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Comic {

    @SerializedName("added_ts")
    @Expose
    private String addedTs;
    @SerializedName("series")
    @Expose
    private String series;
    @SerializedName("page_count")
    @Expose
    private Integer pageCount = 0;
    @SerializedName("locations")
    @Expose
    private List<Object> locations = null;
    @SerializedName("month")
    @Expose
    private String month;
    @SerializedName("imprint")
    @Expose
    private String imprint;
    @SerializedName("year")
    @Expose
    private Integer year = 0;
    @SerializedName("id")
    @Expose
    private Integer id = -1;
    @SerializedName("deleted_ts")
    @Expose
    private String deletedTs;
    @SerializedName("genres")
    @Expose
    private List<Object> genres = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("filesize")
    @Expose
    private Integer filesize = 0;
    @SerializedName("issue")
    @Expose
    private Integer issue = 0;
    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("storyarcs")
    @Expose
    private List<Object> storyarcs = null;
    @SerializedName("mod_ts")
    @Expose
    private String modTs;
    @SerializedName("lastread_page")
    @Expose
    private Integer lastreadPage = 0;
    @SerializedName("weblink")
    @Expose
    private String weblink;
    @SerializedName("volume")
    @Expose
    private Integer volume = 0;
    @SerializedName("credits")
    @Expose
    private Credits credits;
    @SerializedName("generictags")
    @Expose
    private List<Object> generictags = null;
    @SerializedName("characters")
    @Expose
    private List<Object> characters = null;
    @SerializedName("lastread_ts")
    @Expose
    private String lastreadTs;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("teams")
    @Expose
    private List<Object> teams = null;

// Members not related to json serialization.
    private String thumbnailUrl;

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getAddedTs() {
        return addedTs;
    }

    public void setAddedTs(String addedTs) {
        this.addedTs = addedTs;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<Object> getLocations() {
        return locations;
    }

    public void setLocations(List<Object> locations) {
        this.locations = locations;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getImprint() {
        return imprint;
    }

    public void setImprint(String imprint) {
        this.imprint = imprint;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeletedTs() {
        return deletedTs;
    }

    public void setDeletedTs(String deletedTs) {
        this.deletedTs = deletedTs;
    }

    public List<Object> getGenres() {
        return genres;
    }

    public void setGenres(List<Object> genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public Integer getIssue() {
        return issue;
    }

    public void setIssue(Integer issue) {
        this.issue = issue;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public List<Object> getStoryarcs() {
        return storyarcs;
    }

    public void setStoryarcs(List<Object> storyarcs) {
        this.storyarcs = storyarcs;
    }

    public String getModTs() {
        return modTs;
    }

    public void setModTs(String modTs) {
        this.modTs = modTs;
    }

    public Integer getLastreadPage() {
        return lastreadPage;
    }

    public void setLastreadPage(Integer lastreadPage) {
        this.lastreadPage = lastreadPage;
    }

    public String getWeblink() {
        return weblink;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Credits getCredits() {
        return credits;
    }

    public void setCredits(Credits credits) {
        this.credits = credits;
    }

    public List<Object> getGenerictags() {
        return generictags;
    }

    public void setGenerictags(List<Object> generictags) {
        this.generictags = generictags;
    }

    public List<Object> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Object> characters) {
        this.characters = characters;
    }

    public String getLastreadTs() {
        return lastreadTs;
    }

    public void setLastreadTs(String lastreadTs) {
        this.lastreadTs = lastreadTs;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<Object> getTeams() {
        return teams;
    }

    public void setTeams(List<Object> teams) {
        this.teams = teams;
    }

}
