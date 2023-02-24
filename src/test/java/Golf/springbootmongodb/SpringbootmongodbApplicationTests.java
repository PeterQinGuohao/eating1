package Golf.springbootmongodb;

import Golf.springbootmongodb.model.FitBean;
import Golf.springbootmongodb.repository.FitRespositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootmongodbApplicationTests {
	@Autowired
	FitRespositoryImpl fitRespository;
	@Test
	void contextLoads() {
		FitBean userByUserName = fitRespository.findUserByUserName("20130210");
		System.out.println(userByUserName.toString());
	}

}
