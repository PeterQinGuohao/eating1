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
