import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;

import com.dao.QuestionDaoHibTemplate;
import com.pojo.Question;


public class TestFind {

	
	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		QuestionDaoHibTemplate dao = (QuestionDaoHibTemplate) context.getBean("hibTemplate");
		List<Question> qstn = dao.getQuestions();
			
		qstn.forEach(System.out::println);
		
		
		
		
		
		
		
	}
}
