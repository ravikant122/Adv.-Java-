package app.drawing;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class InjectingObjects implements InitializingBean, DisposableBean {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public void draw() {
		System.out.println("Point A: " + pointA.getX() + " " + pointA.getY());
		System.out.println("Point B: " + pointB.getX() + " " + pointB.getY());
		System.out.println("Point C: " + pointC.getX() + " " + pointC.getY());
	}
	
	public void init () {
		System.out.println("init method for triangle");
	}
	public void cleanup () {
		System.out.println("cleanup method for triangle");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Spring's init method for triangle");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Spring's cleanup method for triangle");		
		
	}
}
