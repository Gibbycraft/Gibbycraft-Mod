/**
 * @author Gibby
 */

package gibbycraft.proxies;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy
{
	@Override
    public void registerRenderers() 
	{
		if(useFood==true)
			registerFood();
		MinecraftForgeClient.preloadTexture(QuantumSword);
		MinecraftForgeClient.preloadTexture(TomatoCrop);
		MinecraftForgeClient.preloadTexture(TomatoSeed);
		MinecraftForgeClient.preloadTexture(QSU);
	}
	
	
	private void registerFood()
	{
		MinecraftForgeClient.preloadTexture(BaconBurger);
		MinecraftForgeClient.preloadTexture(Tortilla);
		MinecraftForgeClient.preloadTexture(TacoShell);
		MinecraftForgeClient.preloadTexture(BeefTaco);
		MinecraftForgeClient.preloadTexture(DeluxeBeefTaco);
		MinecraftForgeClient.preloadTexture(ChickenTaco);
		MinecraftForgeClient.preloadTexture(DeluxeChickenTaco);
		MinecraftForgeClient.preloadTexture(BeefBurrito);
		MinecraftForgeClient.preloadTexture(DeluxeBeefBurrito);
		MinecraftForgeClient.preloadTexture(Noodles);
		MinecraftForgeClient.preloadTexture(Spaghetti);
		MinecraftForgeClient.preloadTexture(SpaghettiAndMeatballs);
		MinecraftForgeClient.preloadTexture(PotatoSlices);
		MinecraftForgeClient.preloadTexture(PotatoBits);
		MinecraftForgeClient.preloadTexture(Fries);
		MinecraftForgeClient.preloadTexture(CheeseFries);
		MinecraftForgeClient.preloadTexture(TaterTots);
		MinecraftForgeClient.preloadTexture(PotatoChips);
		MinecraftForgeClient.preloadTexture(SpicyPotatoChips);
		MinecraftForgeClient.preloadTexture(CheesePotatoChips);
		MinecraftForgeClient.preloadTexture(SugarCookie);
		MinecraftForgeClient.preloadTexture(DoubleChocolateCookie);
		MinecraftForgeClient.preloadTexture(CookedEgg);
		MinecraftForgeClient.preloadTexture(ScrambledEgg);
		MinecraftForgeClient.preloadTexture(Bacon);
		MinecraftForgeClient.preloadTexture(PumpkinCookie);
		MinecraftForgeClient.preloadTexture(ChocolateApple);
		MinecraftForgeClient.preloadTexture(BarbecueChicken);
		MinecraftForgeClient.preloadTexture(ChickenFinger);
		MinecraftForgeClient.preloadTexture(Cheeseburger);
		MinecraftForgeClient.preloadTexture(ApplePie);
		MinecraftForgeClient.preloadTexture(ChocolatePie);
		MinecraftForgeClient.preloadTexture(ChocolateBar);
		MinecraftForgeClient.preloadTexture(ChickenPizza);
		MinecraftForgeClient.preloadTexture(AnchoviesPizza);
		MinecraftForgeClient.preloadTexture(BeefPizza);
		MinecraftForgeClient.preloadTexture(PepperoniPizza);
		MinecraftForgeClient.preloadTexture(CheesePizza);
		MinecraftForgeClient.preloadTexture(Sauce);
		MinecraftForgeClient.preloadTexture(Tomato);
		MinecraftForgeClient.preloadTexture(Bagel);
		MinecraftForgeClient.preloadTexture(CreamCheese);
		MinecraftForgeClient.preloadTexture(BeefSandwich);
		MinecraftForgeClient.preloadTexture(PorkSandwich);
		MinecraftForgeClient.preloadTexture(ChickenSandwich);
		MinecraftForgeClient.preloadTexture(FishSandwich);
		MinecraftForgeClient.preloadTexture(ToastedBread);
		MinecraftForgeClient.preloadTexture(BreadSlice);
		MinecraftForgeClient.preloadTexture(Toast);
		MinecraftForgeClient.preloadTexture(Cheese);
		MinecraftForgeClient.preloadTexture(GrilledCheese);

    }
	/**
	 * Uses super to inherit the UseFood property of the config file.
	 */
	private boolean useFood = super.useFoodProp;
}
