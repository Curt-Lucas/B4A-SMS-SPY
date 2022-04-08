B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=11.5
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Type Message (Address As String, Body As String)
End Sub

Sub Service_Create
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.

End Sub

Sub Service_Start (StartingIntent As Intent)
	Service.StopAutomaticForeground 'Starter service can start in the foreground state in some edge cases.
	If StartingIntent.Action = "android.provider.Telephony.SMS_RECEIVED" Then
		Dim messages() As Message
		messages = ParseSmsIntent(StartingIntent)
		For i = 0 To messages.Length - 1
			Log(messages(i))
		Next
	End If
	Service.StopAutomaticForeground
End Sub

Sub Service_TaskRemoved
	'This event will be raised when the user removes the app from the recent apps list.
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub

'Parses an SMS intent and returns an array of messages
Sub ParseSmsIntent (in As Intent) As Message()
	Dim messages() As Message
	If in.HasExtra("pdus") = False Then Return messages
	Dim pdus() As Object
	Dim r As Reflector
	pdus = in.GetExtra("pdus")
	If pdus.Length > 0 Then
		Dim messages(pdus.Length) As Message
		For i = 0 To pdus.Length - 1
			r.Target = r.RunStaticMethod("android.telephony.SmsMessage", "createFromPdu", _
            Array As Object(pdus(i)), Array As String("[B"))
			messages(i).Body = r.RunMethod("getMessageBody")
			messages(i).Address = r.RunMethod("getOriginatingAddress")
		Next
	End If
	Return messages
End Sub

