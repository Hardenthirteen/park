package park;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.park.dao.AssessDao;
import com.park.dao.UserDao;
import com.park.entity.Assess;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMybatis {
	
	@Autowired
	UserDao userDao;
	@Autowired
	AssessDao assessDao;
	@Test
	public void testInsert(){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date now = new Date();
//		String  assess_time= sdf.format(now);
//		Assess assess=new Assess(1,"1","好",assess_time,"18209183861","1");
//		System.out.println(assessDao.add(assess));
		//System.out.println(userDao.getUserMessage("18209183861"));
		
	}

}
