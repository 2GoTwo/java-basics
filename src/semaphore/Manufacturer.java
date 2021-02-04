package semaphore;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Manufacturer extends Thread {
	private Semaphore semaphore;
	private List<Integer> channel;

	public Manufacturer(Semaphore semaphore, List<Integer> channel) {
		super();
		this.semaphore = semaphore;
		this.channel = channel;
	}
	
	@Override
	public void run() {
		Random r = new Random();
		while(!interrupted()) {
			synchronized (channel) {
				int giveen = r.nextInt();
				System.out.println("Manufacturer has produced : " + giveen);
				channel.add(giveen);
			}
			semaphore.release();
		}
	}
}
