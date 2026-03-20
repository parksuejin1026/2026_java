package PracInterface;

public interface PhoneInterface {
	final int TimeOut = 10000;
	void sendCall();
	void receiveCall();
	default void PrintLogo() {
		System.out.println("** Phone **");
	}
}
