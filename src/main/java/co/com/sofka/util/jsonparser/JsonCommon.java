package co.com.sofka.util.jsonparser;

import co.com.sofka.model.CharacterModel;
import co.com.sofka.model.ComicModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JsonCommon {
    public static JSONObject jsonToObject(String jsonString){
        JSONObject jsonObject = new JSONObject();
        try{
            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  jsonObject;
    }

    public static CharacterModel toCharacter(JSONObject jsonObject) {
        JSONObject data = (JSONObject) jsonObject.get("data");
        JSONObject results = (JSONObject) ((JSONArray) data.get("results")).get(0);

        int id = Integer.parseInt(results.get("id").toString());
        String nombre = (String) results.get("name");
        String descripcion = (String) results.get("description");
        String copyright = (String) jsonObject.get("copyright");

        CharacterModel character = new CharacterModel(id, nombre, descripcion, copyright);

        return character;
    }

    public static ComicModel toComic(JSONObject jsonObject) {
        JSONObject data = (JSONObject) jsonObject.get("data");
        JSONArray results = (JSONArray) data.get("results");
        JSONObject comic = (JSONObject) results.get(0);

        int id = Integer.parseInt(comic.get("id").toString());
        String format = (String) comic.get("format");
        String title = (String) comic.get("title");
        String description = (String) comic.get("description");
        String isbn = (String) comic.get("isbn");

        return new ComicModel(id, format, title, description,isbn);
    }

}
