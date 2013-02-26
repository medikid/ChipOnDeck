package poker.app;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import poker.app.Timer.Alarm;

public class Timer implements Runnable {
	private Thread timerThread = null;
	 public int ticker = 0;
	 public int timeOut=0;
	 public int nextAlarmTime = 0;
	 public Map< Object, Alarm> alarmList;
	 public Set<Entry<Object, Alarm>> alarmSet;
	 Iterator<Entry<Object, Alarm>> alarmIterator;
	 List<TimerListener> TimerListeners = new ArrayList<TimerListener>();
	 
	 public Timer(int timerTime){
		 this.timeOut = timerTime;
		 alarmList = new HashMap<Object, Alarm>();
		 alarmSet = alarmList.entrySet();
		 alarmIterator = alarmSet.iterator();
	 }
	 
	 public void addTimerListener(TimerListener TL) {
		 TimerListeners.add(TL);			
		}
		
	 public void start(){
		if(timerThread == null){
			timerThread = new Thread(this, "Timer");
			timerThread.start();
			
			for (TimerListener  tl: TimerListeners) tl.onTimerStart();
		}
	}
	 
	public void addAlarm(int alarmTime, final Object aninstance, final String amethodname, final Class[] parameterTypes, final Object[] parameters){
		Alarm alr = new Alarm(alarmTime, aninstance, amethodname, parameterTypes, parameters);
		
		alarmList.put(alarmTime, alr);
	}

	@Override
	public void run() {
		Thread myThread = Thread.currentThread();
		while (timerThread == myThread){
			System.out.println("TImer running: Time is " + String.valueOf(this.getTick() ) );
			
			if (this.isTimeUp() == true){
				this.stop();				
			} else {
				try {
					myThread.sleep(1000); // 1sec delay
					this.tick();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
			/*
			try {
				this.tick();
			} catch (ClassNotFoundException | NoSuchMethodException
					| SecurityException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
	}
	
	public void stop(){
		timerThread = null;
		for (TimerListener  tl: TimerListeners) tl.onTimerStop();
	}
	
	public void tick() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException{
		this.ticker++;
		for (TimerListener  tl: TimerListeners) tl.onTimerTick();
		
		if ( this.checkAlarm() == true ){
			this.executeAlarm(new Integer(this.getTick()));
		}
	}
	
	public void setTick(int timerTick){
		this.ticker = timerTick;
	}
	
	public int getTick(){
		return this.ticker;
	}
	
	public void reset(){
		this.ticker = 0;
	}
	
	public Boolean isTimeUp(){
		Boolean timeUp = false;
		if (this.getTick() >= this.timeOut){
			timeUp = true;
		}
		return timeUp;
	}
	
	public Boolean checkAlarm(){
		Boolean isAlarm = false;
		if (this.getTick() == this.nextAlarmTime){
			isAlarm = true;
		}
		
		return isAlarm;
	}
	
	public void executeAlarm(Object alarmTime) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Alarm calledAlarm = this.alarmList.get(alarmTime);
		for (TimerListener  tl: TimerListeners) tl.onTimerAlarm();
		calledAlarm.execute();
		
		if ( this.alarmIterator.hasNext()){
			Map.Entry me = (Map.Entry) alarmIterator.next();
			this.nextAlarmTime = (int) me.getKey();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public class Alarm{
		public int _alarmTime;
		public Object _object;
		public String _objectName;
		public String _methodName;
		public String _className;
		public String[] _args;
		public Class[] _parmeterTypes;
		public Object[] _parameters;
		@SuppressWarnings("rawtypes")
		public Class[] parameterTypes = new Class[]{String[].class};
		
		public Alarm(int alarmTime, Object objInstance, final String methodName, final Class[] parameterTypes, final Object[] parameters){
			this.setAlarmTime(alarmTime);
			this._object = objInstance;			
			this.setMethodName(methodName);
			this._parmeterTypes = parameterTypes;
			this._parameters = parameters;
		}
		
		public void setAlarmTime(int alarmTime){
			this._alarmTime = alarmTime;
		}
		
		public int getAlarmTime(){
			return this._alarmTime;
		}
		
		public void setObjectName(Object objName){
			this._object = objName;
		}
		
		public Object getObjectName(){
			return this._object;
		}
		
		public void setMethodName(String methodName){
			this._methodName = methodName;
		}
		
		public String getMethodName(){
			return this._methodName;
		}
		
		public void setMethodArgs(String[] args){
			this._args = args;
		}
		public String[] getmethodArgs(){
			return this._args;
		}
		
		public void execute() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
			this.reflectionCall();
		}
		
		
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Object reflectionCall() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		    Object res;// = null;
		    try {  	Class aclass = null;// = null;
			    	if(this._object != null){
			    		aclass = this._object.getClass();
			    	}
		    	//Class[] parameterTypes = new Class[]{String[].class};
		    final Method amethod = aclass.getDeclaredMethod(this._methodName, this._parmeterTypes);
		    
		    	res = amethod.invoke(this._object, this._parameters);
		    } finally {
		    	
		    }
		    
		    return res;
		}
	}
	
	public interface TimerListener {
		public void onTimerTick();
		public void onTimerStart();
		public void onTimerStop();
		public void onTimerAlarm();
		
	}
		
}
