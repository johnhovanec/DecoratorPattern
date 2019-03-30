package decorators;

import abstractClasses.Decorator;
import interfaces.AddOn;
import interfaces.Receipt;

public class PreDecorator extends Decorator{
	private AddOn a;   // ?? a guess on these
	private Receipt r;
	
	public PreDecorator(Receipt r, AddOn a) {
		super(r, a);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void prtReceipt() {
		// TODO Auto-generated method stub
		System.out.println(a.getLines());
		callTrailer();
		
	}

}
