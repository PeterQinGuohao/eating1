package Golf.springbootmongodb.controller;

import Golf.springbootmongodb.model.FitBean;
import Golf.springbootmongodb.repository.FitRespositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright:zhaoyang.wicp.vip
 * Author:王昭阳 -小明机器人
 * Date:2023/2/24
 * Description:代码版权声明
 */
@RestController
@RequestMapping("/fit")
public class FitController {
    @Autowired
    FitRespositoryImpl fitRespository;
    @GetMapping("/getByDate")
    public FitBean getByDate(String date){
        return  fitRespository.findUserByUserName(date);
    }
}
