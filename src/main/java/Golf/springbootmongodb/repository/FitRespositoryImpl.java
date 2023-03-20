package Golf.springbootmongodb.repository;

import Golf.springbootmongodb.model.FitBean;
import Golf.springbootmongodb.model.SummaryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;


@Service
public class FitRespositoryImpl  {
    @Autowired
    private MongoTemplate mongoTemplate;



    public FitBean findUserByUserName(String date) {
        Query query=new Query(Criteria.where("date").is(date));
        FitBean one = mongoTemplate.findOne(query, FitBean.class);
        return  one;
    }



    public Integer getCalories(String date) {
        FitBean one = findUserByUserName(date);
        List<SummaryBean> summary = one.getSummary();
       BigDecimal sum= BigDecimal.ZERO;
        if(!Objects.isNull(summary)){
            for (SummaryBean summaryBean : summary) {
                Integer calories = summaryBean.getCalories();
                if(!Objects.isNull(calories)){
                    sum=sum.add(BigDecimal.valueOf(calories));
                }

            }

        }
        return sum.intValue();
    }
}
