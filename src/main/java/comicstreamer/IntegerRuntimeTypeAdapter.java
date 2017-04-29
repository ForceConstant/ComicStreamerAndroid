
package comicstreamer;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class IntegerRuntimeTypeAdapter extends TypeAdapter<Integer>
{
    public Integer read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        try {
            return in.nextInt();
        } catch (NumberFormatException e) {
            in.skipValue();
            return -999;
        }
    }
    public void write(JsonWriter out, Integer value) throws IOException {
        out.value(value);
    }

}
