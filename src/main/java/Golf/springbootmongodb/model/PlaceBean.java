package Golf.springbootmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class PlaceBean {

    private  Long id;
    private  String name;
    private  String type;
    private  LocationBean location;
}
