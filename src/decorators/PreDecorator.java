package decorators;

import abstractClasses.Decorator;
import interfaces.AddOn;
import interfaces.Receipt;

public class PreDecorator extends Decorator{
	private AddOn a;   
	private Receipt r;
	
	public PreDecorator(Receipt r, AddOn a) {
		super(r, a);
		this.r = r;		
		this.a = a;
	}

	@Override
	public void prtReceipt() {
		System.out.println(a.getLines());
		callTrailer();
	}
}
