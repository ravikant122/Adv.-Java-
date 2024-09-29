package app.drawing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

// this annotation means its a bean - so no need to mention this in spring.xml
@Component(value = "circle")
public class BasicCircle implements Shape, ApplicationEventPublisherAware {

	private Point center;
	
	@Autowired // since we've single bean of type ResourceBundleMessageSource
	private MessageSource messageSource;
	
	private ApplicationEventPublisher publisher;

	@Override
	public void draw () {
		System.out.println("Circle drawn, Point: " + center.getX() + " " + center.getY());
		DrawEvent event = new DrawEvent(this);
		publisher.publishEvent(event);
		System.out.println(this.messageSource.getMessage("greeting", null, "default greeting message", null));
	}

	public Point getCenter() {
		return center;
	}

	/*
	  lets say if we don't use autowired annotation and if we don't use any bean for pointA
	  for the circle class - then it will throw exception NullPointerException but this exception
	  will be throw when our program in running
	  if we want exception to be thrown at the time of initialization of spring then we can use 
	  this annotation - so that we get the errors before we actually run our program and there's no error then
	  
	  Autowired - first looks for the type of the bean if type not found or multiple types found 
	  	then it will throw exception
	  
	  for this annotation to do work, we need to create this bean
	  <bean class="org.springframework.beans.factory.annotationAutowired.AnnotationBeanPostProcessor" />
	  
	  Qualifier - only can be used with Autowired
	  to match with name/id - use @Qualifier - just use the name of the bean
	  
	  we can use Resource - jsr250 api annotation - give name of the bean,
	  if we don't give name then it will try to match with our variable name
	 */
	@Resource(name = "center")
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;	
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}
