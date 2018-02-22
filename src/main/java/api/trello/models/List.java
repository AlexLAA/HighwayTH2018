package api.trello.models;

/**
 * Created by lolik on 2/22/18.
 */
public class List {

    public String id;
    public String name;
    public Boolean closed;
    public String idBoard;
    public int pos;

    @Override
    public String toString() {
        return "List{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", closed=" + closed +
                ", idBoard='" + idBoard + '\'' +
                ", pos=" + pos +
                '}';
    }
}
