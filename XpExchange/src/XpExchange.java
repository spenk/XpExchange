import java.io.File;
import java.util.logging.Logger;
public class XpExchange extends Plugin{
	  String name = "XpExchange ";
	  String version = "1.0 ";
	  String author = "by spenk ";
	  static Logger log = Logger.getLogger("Minecraft");

	  public void initialize()
	  {
		  XpExchangeListener listener = new XpExchangeListener();
	    log.info(this.name + " version " + this.version + " by " + this.author + " is initialized!");
	    etc.getLoader().addListener(PluginLoader.Hook.COMMAND, listener, this, PluginListener.Priority.MEDIUM);
	    File f1 = new File("plugins/config");
	    f1.mkdir();
	    listener.loadprops();
	  }

	  public void enable() {
	    log.info(this.name + " version " + this.version + " by " + this.author + " is enabled!");
	  }

	  public void disable() {
	    log.info(this.name + " version " + this.version + " is disabled!");
	  }
}
