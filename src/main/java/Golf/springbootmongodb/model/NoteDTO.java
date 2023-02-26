package Golf.springbootmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notes")

public class NoteDTO {

    @Id
    private String id;
    private String dailySummaryId;
    private String dailySummaryDate;
    private String title;
    private String text;
    private Date createdAt;
    private Date updatedAt;

}
