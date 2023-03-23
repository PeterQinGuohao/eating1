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
public class SegmentsBean {
    PlaceBean place;
    List<ActivityBean> activities;
    private String type;
    private String startTime;
    private String endTime;
    private String lastUpdate;

}
