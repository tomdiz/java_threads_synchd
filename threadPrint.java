
public class threadPrint {
	
	boolean turnOne = true;
	int count = 0;
	final int MAX_LOOP_COUNT = 20;
	
	synchronized void setFlag(boolean f) {
		turnOne = f;
	}
	
	synchronized boolean getFlag() {
		return turnOne;
	}

	public class threadOne extends Thread {
		public void run() {
			while (true) {
				if (getFlag() == true) {
					System.out.print("1");
					setFlag(false);
					if (count < MAX_LOOP_COUNT)
						count++;
					else
						break;
				}
			}
		}
	}
	
	class threadTwo extends Thread {
		public void run() {
			while (true) {
				if (getFlag() == false) {
					System.out.print("2");
					setFlag(true);
					if (count < MAX_LOOP_COUNT)
						count++;
					else
						break;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		threadPrint tp = new threadPrint();
		threadOne one = tp.new threadOne();
		threadTwo two = tp.new threadTwo();
		
		one.start();
		two.start();
	}
} 
