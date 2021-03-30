package callbacks;

@FunctionalInterface
interface OnDumpEventListener {
	void onDumpEvent();
}

class SynchronousCallback {
	void doStuff(OnDumpEventListener callback) {
		System.out.println("i'm doing my work");

		if (callback != null) {
			callback.onDumpEvent();
		}
	}
}

class AsynchronousCallback {
	void doStuff(OnDumpEventListener callback) {
		System.out.println("i'm doing my work");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (callback != null) {
			new Thread(() -> {
				callback.onDumpEvent();
			}).start();
		}
	}
}

public class Main {
	public static void main(String[] args) {
		SynchronousCallback x = new SynchronousCallback();
		x.doStuff(() -> System.out.println("callback doing his work"));

		AsynchronousCallback y = new AsynchronousCallback();
		y.doStuff(() -> System.out.println("callback doing his work asynch"));
	}
}
