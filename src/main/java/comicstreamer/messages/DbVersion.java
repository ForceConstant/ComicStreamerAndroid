package comicstreamer.messages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DbVersion {

    @SerializedName("last_build")
    @Expose
    private String lastBuild;
    @SerializedName("version")
    @Expose
    private String version;

    public String getLastBuild() {
        return lastBuild;
    }

    public void setLastBuild(String lastBuild) {
        this.lastBuild = lastBuild;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}