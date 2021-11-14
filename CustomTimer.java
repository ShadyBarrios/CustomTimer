import java.util.TimerTask;

// CustomTimer tasks = new CustomTimer(RequestedTime, TimeIncrements);
// Timer timer = new Timer;
// timer.schedule(tasks, 0, TimeIncrements);

public abstract class CustomTimer extends TimerTask{
	long TimeIncrements;
	long RemainingTime;
	
	// RequestedTime and TimeIncrements are taken in the form of milliseconds
	public CustomTimer(long RequestedTime, long TimeIncrements) {
		this.RemainingTime = RequestedTime;
		this.TimeIncrements = TimeIncrements; // the time between Tasks
	}
	
	// include conditional that uses StopTimer() when RemainingTime <= 0
	@Override
	abstract public void run();
	
	protected long ToSeconds(long milliseconds) {return milliseconds / 1000;}
	
	protected long ToMinutes(long seconds) {return seconds / 60;} // doesn't return fractions of minutes
	
	protected long ToHours(long minutes) {return minutes / 60;}
	
	// the time argument is returned in two-digit format
	abstract protected String FormatTime(long time); 
	
	protected long GetRemainingTime() {
		RemainingTime -= TimeIncrements; // directly affects instance variable
		return RemainingTime;
	}
	
	protected void StopTimer() {
		this.cancel();
		// also .cancel() the timer using this CustomTimerTask
	}
}