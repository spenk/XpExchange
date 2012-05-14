import java.util.Map;
import java.util.logging.Logger;


public class XpExchangeListener extends PluginListener{
Logger log = Logger.getLogger("Minecraft");
PropertiesFile f = new PropertiesFile("plugins/config/XpExchange.properties");
Map<String, String> m;
public void loadprops(){
	try {
		m = f.returnMap();
		log.info("[XpExchange] - PropertiesFile decoded!");
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public boolean onCommand(Player player,String[] split){
	if (split[0].equalsIgnoreCase("/exchange")&&player.canUseCommand("/xpexchange")){
		Item item = player.getItemStackInHand();
		if (split.length <1 || split.length >1){
			player.notify("The correct usage is '/exchange'");
			return true;
		}
		if (item == null){
			player.notify("You dont have any item in your hand to exchange!");
			return true;
		}
		if (!m.containsKey(item.getItemId()+"")){
			player.notify("You cant exchange this item!");
			return true;
		}
		double xp;
		try{xp = Double.parseDouble(m.get(item.getItemId()+""));}catch(NumberFormatException nfe){log.info("Error during decoding "+item.getItemId()+" please change this and reload the plugin!");return true;}
		double total = xp * item.getAmount();
		int end = (int)Math.floor(total);
		player.addXP(end);
		player.getInventory().removeItem(item.getSlot());
		player.sendMessage("§2Items exchanged for "+end+" xp!");
		return true;
	}
	return false;
}
}
