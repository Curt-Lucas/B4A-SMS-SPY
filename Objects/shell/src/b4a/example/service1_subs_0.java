package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class service1_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (service1) ","service1",1,service1.processBA,service1.mostCurrent,35);
if (RapidSub.canDelegate("application_error")) { return b4a.example.service1.remoteMe.runUserSub(false, "service1","application_error", _error, _stacktrace);}
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 35;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="Return True";
Debug.ShouldStop(8);
if (true) return service1.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _parsesmsintent(RemoteObject _in) throws Exception{
try {
		Debug.PushSubsStack("ParseSmsIntent (service1) ","service1",1,service1.processBA,service1.mostCurrent,44);
if (RapidSub.canDelegate("parsesmsintent")) { return b4a.example.service1.remoteMe.runUserSub(false, "service1","parsesmsintent", _in);}
RemoteObject _messages = null;
RemoteObject _pdus = null;
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
int _i = 0;
Debug.locals.put("in", _in);
 BA.debugLineNum = 44;BA.debugLine="Sub ParseSmsIntent (in As Intent) As Message()";
Debug.ShouldStop(2048);
 BA.debugLineNum = 45;BA.debugLine="Dim messages() As Message";
Debug.ShouldStop(4096);
_messages = RemoteObject.createNewArray ("b4a.example.service1._message", new int[] {0}, new Object[]{});Debug.locals.put("messages", _messages);
 BA.debugLineNum = 46;BA.debugLine="If in.HasExtra(\"pdus\") = False Then Return messag";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_in.runMethod(true,"HasExtra",(Object)(RemoteObject.createImmutable("pdus"))),service1.mostCurrent.__c.getField(true,"False"))) { 
if (true) return _messages;};
 BA.debugLineNum = 47;BA.debugLine="Dim pdus() As Object";
Debug.ShouldStop(16384);
_pdus = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});Debug.locals.put("pdus", _pdus);
 BA.debugLineNum = 48;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(32768);
_r = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("r", _r);
 BA.debugLineNum = 49;BA.debugLine="pdus = in.GetExtra(\"pdus\")";
Debug.ShouldStop(65536);
_pdus = (_in.runMethod(false,"GetExtra",(Object)(RemoteObject.createImmutable("pdus"))));Debug.locals.put("pdus", _pdus);
 BA.debugLineNum = 50;BA.debugLine="If pdus.Length > 0 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean(">",_pdus.getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 51;BA.debugLine="Dim messages(pdus.Length) As Message";
Debug.ShouldStop(262144);
_messages = RemoteObject.createNewArray ("b4a.example.service1._message", new int[] {_pdus.getField(true,"length").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("messages", _messages);
 BA.debugLineNum = 52;BA.debugLine="For i = 0 To pdus.Length - 1";
Debug.ShouldStop(524288);
{
final int step8 = 1;
final int limit8 = RemoteObject.solve(new RemoteObject[] {_pdus.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step8 > 0 && _i <= limit8) || (step8 < 0 && _i >= limit8) ;_i = ((int)(0 + _i + step8))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 53;BA.debugLine="r.Target = r.RunStaticMethod(\"android.telephony";
Debug.ShouldStop(1048576);
_r.setField ("Target",_r.runMethod(false,"RunStaticMethod",(Object)(BA.ObjectToString("android.telephony.SmsMessage")),(Object)(BA.ObjectToString("createFromPdu")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {_pdus.getArrayElement(false,BA.numberCast(int.class, _i))})),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("[B")}))));
 BA.debugLineNum = 55;BA.debugLine="messages(i).Body = r.RunMethod(\"getMessageBody\"";
Debug.ShouldStop(4194304);
_messages.getArrayElement(false, /*RemoteObject*/ BA.numberCast(int.class, _i)).setField ("Body" /*RemoteObject*/ ,BA.ObjectToString(_r.runMethod(false,"RunMethod",(Object)(RemoteObject.createImmutable("getMessageBody")))));
 BA.debugLineNum = 56;BA.debugLine="messages(i).Address = r.RunMethod(\"getOriginati";
Debug.ShouldStop(8388608);
_messages.getArrayElement(false, /*RemoteObject*/ BA.numberCast(int.class, _i)).setField ("Address" /*RemoteObject*/ ,BA.ObjectToString(_r.runMethod(false,"RunMethod",(Object)(RemoteObject.createImmutable("getOriginatingAddress")))));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 59;BA.debugLine="Return messages";
Debug.ShouldStop(67108864);
if (true) return _messages;
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Type Message (Address As String, Body As String)";
;
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (service1) ","service1",1,service1.processBA,service1.mostCurrent,12);
if (RapidSub.canDelegate("service_create")) { return b4a.example.service1.remoteMe.runUserSub(false, "service1","service_create");}
 BA.debugLineNum = 12;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(2048);
 BA.debugLineNum = 16;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (service1) ","service1",1,service1.processBA,service1.mostCurrent,39);
if (RapidSub.canDelegate("service_destroy")) { return b4a.example.service1.remoteMe.runUserSub(false, "service1","service_destroy");}
 BA.debugLineNum = 39;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(64);
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (service1) ","service1",1,service1.processBA,service1.mostCurrent,18);
if (RapidSub.canDelegate("service_start")) { return b4a.example.service1.remoteMe.runUserSub(false, "service1","service_start", _startingintent);}
RemoteObject _messages = null;
int _i = 0;
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 18;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 19;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
Debug.ShouldStop(262144);
service1.mostCurrent._service.runVoidMethod ("StopAutomaticForeground");
 BA.debugLineNum = 20;BA.debugLine="If StartingIntent.Action = \"android.provider.Tele";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_startingintent.runMethod(true,"getAction"),BA.ObjectToString("android.provider.Telephony.SMS_RECEIVED"))) { 
 BA.debugLineNum = 21;BA.debugLine="Dim messages() As Message";
Debug.ShouldStop(1048576);
_messages = RemoteObject.createNewArray ("b4a.example.service1._message", new int[] {0}, new Object[]{});Debug.locals.put("messages", _messages);
 BA.debugLineNum = 22;BA.debugLine="messages = ParseSmsIntent(StartingIntent)";
Debug.ShouldStop(2097152);
_messages = _parsesmsintent(_startingintent);Debug.locals.put("messages", _messages);
 BA.debugLineNum = 23;BA.debugLine="For i = 0 To messages.Length - 1";
Debug.ShouldStop(4194304);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_messages.getField(true,"length" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 24;BA.debugLine="Log(messages(i))";
Debug.ShouldStop(8388608);
service1.mostCurrent.__c.runVoidMethod ("LogImpl","4983046",BA.ObjectToString(_messages.getArrayElement(false, /*RemoteObject*/ BA.numberCast(int.class, _i))),0);
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 27;BA.debugLine="Service.StopAutomaticForeground";
Debug.ShouldStop(67108864);
service1.mostCurrent._service.runVoidMethod ("StopAutomaticForeground");
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_taskremoved() throws Exception{
try {
		Debug.PushSubsStack("Service_TaskRemoved (service1) ","service1",1,service1.processBA,service1.mostCurrent,30);
if (RapidSub.canDelegate("service_taskremoved")) { return b4a.example.service1.remoteMe.runUserSub(false, "service1","service_taskremoved");}
 BA.debugLineNum = 30;BA.debugLine="Sub Service_TaskRemoved";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}