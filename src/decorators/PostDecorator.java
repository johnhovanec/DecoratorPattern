package decorators;

import abstractClasses.Decorator;
import interfaces.AddOn;
import interfaces.Receipt;

public class PostDecorator extends Decorator {
	private AddOn a; // ?? a guess on these
	private Receipt r;

	public PostDecorator(Receipt r, AddOn a) {
		super(r, a);
		this.r = r;
		this.a = a;
	}

	@Override
	public void prtReceipt() {
		callTrailer();
		System.out.println(a.getLines());
	}
}
