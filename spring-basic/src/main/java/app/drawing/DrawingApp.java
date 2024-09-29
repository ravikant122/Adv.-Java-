package app.drawing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		// we can use BeanFactory but XmlBeanFactory is deprecated now, we can use ApplicationContext
		// BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		
		// for maven, we've to keep spring.xml in src/main/resources
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//		ctx.registerShutdownHook(); // to call destroy lifecycle hook
		
		BasicCircle shape = (BasicCircle) ctx.getBean("circle");
		shape.draw();
		
		System.out.println(ctx.getMessage("greeting", null, "default greeting message", null));
	}
}
