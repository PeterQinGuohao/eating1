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
public class ActivityBean {
    private  String activity;
    private  String group;
    private  Boolean manual;
    private String startTime;
    private String endTime;
    private Integer duration;
    private Integer distance;
    private Integer steps;
    private Integer calories;
    private List<String> trackPoints;

}
