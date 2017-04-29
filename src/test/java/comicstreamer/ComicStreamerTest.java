package comicstreamer;

import org.junit.Test;

import java.util.List;

import comicstreamer.messages.Comic;
import comicstreamer.messages.DbInfo;
import comicstreamer.messages.DbVersion;
import comicstreamer.messages.Deletedcomic;

import static org.junit.Assert.assertTrue;

/**
 * Created by brian on 3/20/2017.
 */
public class ComicStreamerTest {
    @Test
    public void getDBInfo() throws Exception {
        ComicStreamer cs = new ComicStreamer();

            DbInfo dbinfo = cs.getDBInfo();
            assertTrue (dbinfo.getComicCount() > 0);
            System.out.println(dbinfo);
    }

    @Test
    public void getVersion() throws Exception {
        ComicStreamer cs = new ComicStreamer();
            DbVersion res = cs.getVersion();

            assertTrue(res.toString().length() > 0);
            System.out.println("Done");
    }

    @Test
    public void getDeleted() throws Exception {
        ComicStreamer cs = new ComicStreamer();
            List<Deletedcomic> res = cs.getDeleted(null);

            assertTrue(res.size() > 0);

            System.out.println("Done");
    }

    @Test
    public void getComicInfo() throws Exception {
        ComicStreamer cs = new ComicStreamer();
            Comic res = cs.getComicInfo(125);

            assertTrue(res.getId() == 125);

            System.out.println("Done");
    }

    @Test
    public void getComicPage() throws Exception {
        ComicStreamer cs = new ComicStreamer();
            byte[] res = cs.getComicPage(125,1);

            assertTrue(res.length > 0);

            System.out.println("Done");
    }

    @Test
    public void setBookmark() throws Exception {
        ComicStreamer cs = new ComicStreamer();
        boolean res = cs.setBookmark(125,1);

        assertTrue(res);

        System.out.println("Done");
    }

    @Test
    public void getThumbnail() throws Exception {
        ComicStreamer cs = new ComicStreamer();
            byte[] res = cs.getThumbnail(125);

            assertTrue(res.length > 0);

            System.out.println("Done");
    }

    @Test
    public void getFile() throws Exception {
        ComicStreamer cs = new ComicStreamer();
            byte[] res = cs.getFile(125);

            assertTrue(res.length > 0);

            System.out.println("Done");
    }

    @Test
    public void getComicList() throws Exception {
        ComicStreamer cs = new ComicStreamer();

        List<Comic> res = cs.getComicList("");

        assertTrue(res.size() > 100);

        System.out.println("Done");
    }

    @Test
    public void getUrls(){
        ComicStreamer cs = new ComicStreamer();

        String res = cs.getThumbnailUrl(125);
        System.out.println(res);

        res = cs.getPageUrl(125, 1);
        System.out.println(res);
    }
}

