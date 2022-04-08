package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class service1 extends  android.app.Service{
	public static class service1_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (service1) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, service1.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, false, anywheresoftware.b4a.ShellBA.class);
		}

	}
    static service1 mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return service1.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "b4a.example", "b4a.example.service1");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.service1", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, true) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (service1) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (service1) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (service1) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (false) {
            BA.LogInfo("** Service (service1) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (service1) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
public static class _message{
public boolean IsInitialized;
public String Address;
public String Body;
public void Initialize() {
IsInitialized = true;
Address = "";
Body = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public b4a.example.main _main = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
RDebugUtils.currentModule="service1";
if (Debug.shouldDelegate(processBA, "application_error", false))
	 {return ((Boolean) Debug.delegate(processBA, "application_error", new Object[] {_error,_stacktrace}));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="End Sub";
return false;
}
public static b4a.example.service1._message[]  _parsesmsintent(anywheresoftware.b4a.objects.IntentWrapper _in) throws Exception{
RDebugUtils.currentModule="service1";
if (Debug.shouldDelegate(processBA, "parsesmsintent", false))
	 {return ((b4a.example.service1._message[]) Debug.delegate(processBA, "parsesmsintent", new Object[] {_in}));}
b4a.example.service1._message[] _messages = null;
Object[] _pdus = null;
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
int _i = 0;
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub ParseSmsIntent (in As Intent) As Message()";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Dim messages() As Message";
_messages = new b4a.example.service1._message[(int) (0)];
{
int d0 = _messages.length;
for (int i0 = 0;i0 < d0;i0++) {
_messages[i0] = new b4a.example.service1._message();
}
}
;
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="If in.HasExtra(\"pdus\") = False Then Return messag";
if (_in.HasExtra("pdus")==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return _messages;};
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="Dim pdus() As Object";
_pdus = new Object[(int) (0)];
{
int d0 = _pdus.length;
for (int i0 = 0;i0 < d0;i0++) {
_pdus[i0] = new Object();
}
}
;
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="pdus = in.GetExtra(\"pdus\")";
_pdus = (Object[])(_in.GetExtra("pdus"));
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="If pdus.Length > 0 Then";
if (_pdus.length>0) { 
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="Dim messages(pdus.Length) As Message";
_messages = new b4a.example.service1._message[_pdus.length];
{
int d0 = _messages.length;
for (int i0 = 0;i0 < d0;i0++) {
_messages[i0] = new b4a.example.service1._message();
}
}
;
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="For i = 0 To pdus.Length - 1";
{
final int step8 = 1;
final int limit8 = (int) (_pdus.length-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="r.Target = r.RunStaticMethod(\"android.telephony";
_r.Target = _r.RunStaticMethod("android.telephony.SmsMessage","createFromPdu",new Object[]{_pdus[_i]},new String[]{"[B"});
RDebugUtils.currentLine=1245195;
 //BA.debugLineNum = 1245195;BA.debugLine="messages(i).Body = r.RunMethod(\"getMessageBody\"";
_messages[_i].Body /*String*/  = BA.ObjectToString(_r.RunMethod("getMessageBody"));
RDebugUtils.currentLine=1245196;
 //BA.debugLineNum = 1245196;BA.debugLine="messages(i).Address = r.RunMethod(\"getOriginati";
_messages[_i].Address /*String*/  = BA.ObjectToString(_r.RunMethod("getOriginatingAddress"));
 }
};
 };
RDebugUtils.currentLine=1245199;
 //BA.debugLineNum = 1245199;BA.debugLine="Return messages";
if (true) return _messages;
RDebugUtils.currentLine=1245200;
 //BA.debugLineNum = 1245200;BA.debugLine="End Sub";
return null;
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="service1";
if (Debug.shouldDelegate(processBA, "service_create", false))
	 {return ((String) Debug.delegate(processBA, "service_create", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="service1";
if (Debug.shouldDelegate(processBA, "service_destroy", false))
	 {return ((String) Debug.delegate(processBA, "service_destroy", null));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="service1";
if (Debug.shouldDelegate(processBA, "service_start", false))
	 {return ((String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent}));}
b4a.example.service1._message[] _messages = null;
int _i = 0;
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
mostCurrent._service.StopAutomaticForeground();
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="If StartingIntent.Action = \"android.provider.Tele";
if ((_startingintent.getAction()).equals("android.provider.Telephony.SMS_RECEIVED")) { 
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="Dim messages() As Message";
_messages = new b4a.example.service1._message[(int) (0)];
{
int d0 = _messages.length;
for (int i0 = 0;i0 < d0;i0++) {
_messages[i0] = new b4a.example.service1._message();
}
}
;
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="messages = ParseSmsIntent(StartingIntent)";
_messages = _parsesmsintent(_startingintent);
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="For i = 0 To messages.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (_messages.length /*int*/ -1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="Log(messages(i))";
anywheresoftware.b4a.keywords.Common.LogImpl("4983046",BA.ObjectToString(_messages[_i]),0);
 }
};
 };
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="Service.StopAutomaticForeground";
mostCurrent._service.StopAutomaticForeground();
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
RDebugUtils.currentModule="service1";
if (Debug.shouldDelegate(processBA, "service_taskremoved", false))
	 {return ((String) Debug.delegate(processBA, "service_taskremoved", null));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Service_TaskRemoved";
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return "";
}
}