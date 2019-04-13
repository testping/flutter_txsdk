package android.src.main.java.flutxsdk.com.txsdk_plugin;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** TxsdkPlugin */
public class TxsdkPlugin implements MethodCallHandler {
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "txsdk_plugin");
    channel.setMethodCallHandler(new TxsdkPlugin());
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else if(call.method.equals("clculate")){
      int a = call.argument("a");
      int b = call.argument("b");
      int r = a + b;
      return result.success("" + r);
    }else{
      result.notImplemented();
    }
  }
}
