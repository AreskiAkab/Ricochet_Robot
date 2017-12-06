

public class Timer {
	private int seconds ;
	private boolean stop;
	private long t1,t2,temps;
	public Timer() {
		this.t1 = System.currentTimeMillis();
		this.t2 = System.currentTimeMillis();
	}
		
		public  void startTimer() {
			this.t1 = System.currentTimeMillis();
			System.out.println(this.t1);
		}
		public  long checkTimer() {
			this.t2 = System.currentTimeMillis();
			System.out.println(this.t2/1000 - this.t1/1000);
			return  (t2-t1)/1000;
		}
		public  long stopTimer() {
			return checkTimer();
		}
}
