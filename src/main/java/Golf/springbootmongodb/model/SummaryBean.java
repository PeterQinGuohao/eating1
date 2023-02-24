package Golf.springbootmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SummaryBean {

    private String activity;
    private String group;
    private Integer duration;
    private Integer distance;
    private Integer steps;
    private Integer calories;

}
