import org.json.JSONObject;
import org.json.JSONException;

public class Main {
    public static void main(String[] args) {
        String json_string = "{\"name\":\"Null\",\"country\":\"Russia\",\"city\":\"Ulyanovsk\",\"age\":\"18\"}";
        try {
            JSONObject json = new JSONObject(json_string);
            StringBuilder sql_select = new StringBuilder("SELECT * FROM students");
            StringBuilder sql_where = new StringBuilder();
            for (int i = 0; i < json.length(); i++) {
                String key = (String) json.names().get(i);
                String value = json.getString(key);
                if (!value.equalsIgnoreCase("null")) {
                    if (sql_where.length() > 0) {
                        sql_where.append(" AND ");
                    } else {
                        sql_where.append(" WHERE ");
                    }
                    sql_where.append(key).append("=").append(value);
                }
            }
            System.out.println(sql_select.append(sql_where));
        }
        catch (JSONException err){
            System.out.println(err.toString());
        }
    }
}