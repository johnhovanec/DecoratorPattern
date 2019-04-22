package decorators;

import abstractClasses.Decorator;
import interfaces.AddOn;
import interfaces.Receipt;

public class PreDecorator extends Decorator{
	private AddOn a;   // ?? a guess on these
	private Receipt r;
	
	public PreDecorator(Receipt r, AddOn a) {
		super(r, a);
		this.r = r;		// Check if call to this is OK?
		this.a = a;
	}

	@Override
	public void prtReceipt() {
		// TODO Auto-generated method stub
		System.out.println(a.getLines());
		callTrailer();
		
	}

}
