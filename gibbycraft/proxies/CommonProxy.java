/**
 * @author Gibby
 */

package gibbycraft.proxies;

public class CommonProxy 
{
	/*
	 * Start by listing all the images. Note that nothing is actually done here.
	 */
	public static String BaconBurger = "/gibbycraft/gui/BaconBurger.png";
	public static String Tortilla = "/gibbycraft/gui/Tortilla.png";
	public static String TacoShell = "/gibbycraft/gui/TacoShell.png";
	public static String BeefTaco = "/gibbycraft/gui/BeefTaco.png";
	public static String DeluxeBeefTaco = "/gibbycraft/gui/DeluxeBeefTaco.png";
	public static String ChickenTaco = "/gibbycraft/gui/ChickenTaco.png";
	public static String DeluxeChickenTaco = "/gibbycraft/gui/DeluxeChickenTaco.png";
	public static String BeefBurrito = "/gibbycraft/gui/BeefBurrito.png";
	public static String DeluxeBeefBurrito = "/gibbycraft/gui/DeluxeBeefBurrito.png";
	public static String Noodles = "/gibbycraft/gui/Noodles.png";
	public static String Spaghetti = "/gibbycraft/gui/Spaghetti.png";
	public static String SpaghettiAndMeatballs = "/gibbycraft/gui/SpaghettiAndMeatballs.png";
	public static String PotatoSlices = "/gibbycraft/gui/PotatoSlices.png";
	public static String PotatoBits = "/gibbycraft/gui/PotatoBits.png";
	public static String Fries = "/gibbycraft/gui/Fries.png";
	public static String CheeseFries = "/gibbycraft/gui/CheeseFries.png";
	public static String TaterTots = "/gibbycraft/gui/TaterTots.png";
	public static String PotatoChips = "/gibbycraft/gui/PotatoChips.png";
	public static String SpicyPotatoChips = "/gibbycraft/gui/SpicyPotatoChips.png";
	public static String CheesePotatoChips = "/gibbycraft/gui/CheesePotatoChips.png";
	public static String SugarCookie = "/gibbycraft/gui/SugarCookie.png";
	public static String DoubleChocolateCookie = "/gibbycraft/gui/DoubleChocolateCookie.png";
	public static String CookedEgg = "/gibbycraft/gui/CookedEgg.png";
	public static String ScrambledEgg = "/gibbycraft/gui/ScrambledEggs.png";
	public static String Bacon = "/gibbycraft/gui/Bacon.png";
	public static String PumpkinCookie = "/gibbycraft/gui/PumpkinCookie.png";
	public static String ChocolateApple = "/gibbycraft/gui/ChocolateApple.png";
	public static String BarbecueChicken = "/gibbycraft/gui/BarbequeChicken.png";
	public static String ChickenFinger = "/gibbycraft/gui/ChickenFinger.png";
	public static String Cheeseburger = "/gibbycraft/gui/Cheeseburger.png";
	public static String ApplePie = "/gibbycraft/gui/ApplePie.png";
	public static String ChocolatePie = "/gibbycraft/gui/ChocolatePie.png";
	public static String ChocolateBar = "/gibbycraft/gui/ChocolateBar.png";
	public static String ChickenPizza = "/gibbycraft/gui/ChickenPizza.png";
	public static String AnchoviesPizza = "/gibbycraft/gui/AnchoviesPizza.png";
	public static String BeefPizza = "/gibbycraft/gui/BeefPizza.png";
	public static String PepperoniPizza = "/gibbycraft/gui/PepperoniPizza.png";
	public static String CheesePizza = "/gibbycraft/gui/CheesePizza.png";
	public static String Sauce = "/gibbycraft/gui/Sauce.png";
	public static String Tomato = "/gibbycraft/gui/Tomato.png";
	public static String Bagel = "/gibbycraft/gui/Bagel.png";
	public static String CreamCheese = "/gibbycraft/gui/CreamCheese.png";
	public static String BeefSandwich = "/gibbycraft/gui/BeefSandwich.png";
	public static String PorkSandwich = "/gibbycraft/gui/PorkSandwich.png";
	public static String ChickenSandwich = "/gibbycraft/gui/ChickenSandwich.png";
	public static String FishSandwich = "/gibbycraft/gui/FishSandwich.png";
	public static String ToastedBread = "/gibbycraft/gui/ToastedBread.png";
	public static String BreadSlice = "/gibbycraft/gui/BreadSlice.png";
	public static String Toast = "/gibbycraft/gui/Toast.png";
	public static String Cheese = "/gibbycraft/gui/Cheese.png";
	public static String GrilledCheese = "/gibbycraft/gui/GrilledCheese.png";
	public static String QuantumSword = "/gibbycraft/gui/QuantumSword.png";
	public static String Cocoa = "/gibbycraft/gui/Cocoa.png";
	public static String CocoaSeed = "gibbycraft/gui/CocoaSeed.png";
	public static String QSU = "gibbycraft/gui/QSU.png";
	
	public void registerRenderers()
	{
        // Nothing here
    }
	/**
	 * A nifty inheritance trick that allows Gibbycraft to send the props file over
	 * without having to recall the config file.
	 * @param a UseFood
	 */
	public void getUseFood(boolean a)
	{
		useFoodProp = a;
	}
	
	public boolean useFoodProp = true;
	
}
