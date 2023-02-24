package Golf.springbootmongodb.repository;

import Golf.springbootmongodb.model.FitBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * Copyright:zhaoyang.wicp.vip
 * Author:王昭阳 -小明机器人
 * Date:2023/2/24
 * Description:代码版权声明
 */
@Service
public class FitRespositoryImpl  {
    @Autowired
    private MongoTemplate mongoTemplate;



    public FitBean findUserByUserName(String date) {
        Query query=new Query(Criteria.where("date").is(date));
        FitBean one = mongoTemplate.findOne(query, FitBean.class);
        return  one;
    }
}
