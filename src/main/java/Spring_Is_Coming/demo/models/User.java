package Spring_Is_Coming.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
public class User {
    @Id
    private String id;

    @Field
    private String description;

    @Field
    private String note;

    public User(String description, String note) {
        this.description = description;
        this.note = note;
    }
}
