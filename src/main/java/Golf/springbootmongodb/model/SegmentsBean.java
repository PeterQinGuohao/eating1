package Golf.springbootmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Copyright:zhaoyang.wicp.vip
 * Author:王昭阳 -小明机器人
 * Date:2023/2/24
 * Description:代码版权声明
 */
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
