package Golf.springbootmongodb.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright:zhaoyang.wicp.vip
 * Author:王昭阳 -小明机器人
 * Date:2023/2/24
 * Description:代码版权声明
 */
@Data
@NoArgsConstructor
@Document(collection = "fit")
@Builder
@AllArgsConstructor
@ToString
public class FitBean implements Serializable {
    private  String id;
    private String date;
    private List<SummaryBean> summary;
    private List<SegmentsBean> segments;
    private  Integer caloriesIdle;
    private  String lastUpdate;

}
