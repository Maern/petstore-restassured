import java.util.List;

public class PetEntity {

    private int id ;
    private Object category;
    private String name;
    private List<String> photoUrls;
    private List<Object> tags;
    private String status;

    public PetEntity(int id, Object category, String name, List <String> photoUrls, List <Object> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public PetEntity(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Object getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public List <String> getPhotoUrls() {
        return photoUrls;
    }

    public List <Object> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }
}
