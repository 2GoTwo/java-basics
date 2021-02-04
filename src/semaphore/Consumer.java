package semaphore;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Consumer extends Thread{
	private Semaphore semaphore;
	private List<Integer> channel;
	public Consumer(Semaphore semaphore, List<Integer> channel) {
		super();
		this.semaphore = semaphore;
		this.channel = channel;
	}
	
	@Override
	public void run() {
		while(!interrupted()) {
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			synchronized (channel) {
				if(!channel.isEmpty())
					System.out.println("Received : " + channel);
				channel.removeAll(channel);
			}
		}
	}
}
