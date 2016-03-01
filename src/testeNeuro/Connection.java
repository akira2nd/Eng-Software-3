package testeNeuro;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

public class Connection {

	/**
	 * Método que recebe a url do JSON e retorna uma string do mesmo.
	 * @param URL do JSON
	 * @return String JSON
	 * @throws JSONException
	 */
    public String getData(String s) throws JSONException {

        final StringBuilder result = new StringBuilder();

        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(s);

            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();
            InputStreamReader isw = new InputStreamReader(in);

            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                result.append(current);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                urlConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result.toString();
    }
    
}