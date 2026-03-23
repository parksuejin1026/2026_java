package PracInterface;

public class InterfaceEx {

	public static void main(String[] args) {

		SamsungPhone sp = new SamsungPhone();
		sp.PrintLogo();
		sp.sendCall();
		sp.receiveCall();
		sp.flash();
	}

}
