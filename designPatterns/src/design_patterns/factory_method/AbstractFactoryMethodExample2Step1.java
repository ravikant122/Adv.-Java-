package design_patterns.factory_method;

// lets take example of a company which builds GPU for msi and asus brand
// abstract factory pattern example will look like this
interface Item {
	public void prepare();
}
interface Gpu extends Item {
	public void gpuPrepare();
}
class MsiGpu implements Gpu{
	@Override
	public void prepare() {
		System.out.println("MsiGpu is preparing");
	}

	@Override
	public void gpuPrepare() {
		System.out.println("Gpu is preparing");		
	}
}
class AsusGpu implements Gpu{
	@Override
	public void prepare() {
		System.out.println("AsusGpu is preparing");
	}
	
	@Override
	public void gpuPrepare() {
		System.out.println("Gpu is preparing");		
	}
}

interface Monitor extends Item {
	
}
class MsiMonitor implements Monitor{
	@Override
	public void prepare() {
		System.out.println("MsiMonitor is preparing");
	}
}
class AsusMonitor implements Monitor{
	@Override
	public void prepare() {
		System.out.println("AsusGpu is preparing");
	}
}

abstract class Company {
	public Item order(Item item) { // this will recieve Gpu/Monitor - subInterface
		item.prepare(); // prepare method is in sub-sub class(grand child class)
		// item.gpuPrepare() - we can't call this because there's no gpuPrepare method in Item
		return item;
	}
	
	public abstract Gpu createGpu();
	public abstract Monitor createMonitor();
}

class MsiPrepare extends Company{
	@Override
	public Gpu createGpu() {
		return new MsiGpu();
	}
	@Override
	public Monitor createMonitor() {
		return new MsiMonitor();
	}
}
class AsusPrepare extends Company{
	@Override
	public Gpu createGpu() {
		return new AsusGpu();
	}
	@Override
	public Monitor createMonitor() {
		return new AsusMonitor();
	}
}

public class AbstractFactoryMethodExample2Step1 {
	public static void main(String[] args) {
		Company c1 = new MsiPrepare();
		c1.order(c1.createGpu()); // here we are creating object of type Gpu
		c1.order(c1.createMonitor());
		
		MsiGpu g = new MsiGpu();
		c1.order(g); // we can also pass grandchild of interface and no erros
		
		Company c2 = new AsusPrepare();
		c2.order(c2.createGpu());
		c2.order(c2.createMonitor());
	}
}



