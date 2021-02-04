package semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;


public class Main {
	public static void main(String[] args) {
		Semaphore s = new Semaphore(0);
		List<Integer> channel = new ArrayList<>();
		
		Manufacturer manufacturer = new Manufacturer(s, channel);
		Consumer consumer = new Consumer(s, channel);
		
		consumer.start();
		manufacturer.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		manufacturer.interrupt();
		consumer.interrupt();
	}
}
