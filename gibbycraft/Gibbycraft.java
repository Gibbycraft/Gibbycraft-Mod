/**
 * @author Gibby
 */

//Don't change this
package gibbycraft;

/**
 * Imports. They make up a lot of our country. As well as this mod. If you use something from
 * another package, PLEASE add it here. Usage is:
 * 
 * import package.name.as.it.appears.in.project.explorer.*;
 */

//start forge hooks
import ic2.api.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import gibbycraft.proxies.CommonProxy;
import gibbycraft.proxies.ClientProxy;
import gibbycraft.items.food.*;
import gibbycraft.blocks.plants.*;
import ic2.api.*;

/*
 * Mod info from cpw.mods.fml.common.Mod
 */
@Mod
(
		modid="Gibbycraft", 
		name="Gibbycraft", 
		version="0.2.0"
		//, dependencies="before:AragamiMod;after:BuildCraft|Core;after:ComputerCraft;after:Railcraft;after:IC2;after:RedPowerWorld"
		)

@NetworkMod
(
		clientSideRequired=true, 
		serverSideRequired=true
		)
//end forge hooks

public class Gibbycraft 
{

    // The instance of the mod (forge use)
    @Instance("Gibbycraft")
    public static Gibbycraft instance;
   
    /*
     * Brace yourselves, long explanation inbound.
     * 
     * Proxies are this new idea that revolves around 1.4.6+ using servers in single player and multiplayer.
     * Yes, that's right. SINGLE PLAYER USES SERVERS TOO!!! Anyways, back to the explanation:
     * 
     * A proxy is used to handle registering and rendering items and blocks. Basically speaking, the
     * client RENDERS the images and the server REGISTERS AND TRACKS entities. Trying to run render
     * code in the server is like slapping Icy Hot on your balls. Don't do it; it's plain retarded.
     * 
     * Client proxies always are headed by Client- and server side is headed by Common-
     * 
     * BIG NOTE, AS THIS WILL BITE YOU IN THE ASS LATER:
     * The client proxy inherits the server (common) proxy. Anything not overloaded in client acts like server.
     * I noted this again in the client proxy.
     */
    @SidedProxy(clientSide="gibbycraft.proxies.ClientProxy", serverSide="gibbycraft.proxies.CommonProxy")
    public static CommonProxy proxy;
   
    /*
     * New in 0.2.0, this dude generates a config file that lets the user pick and choose item IDs,
     * and even disable features. Nifty, and it allows us to deal with whiny 12 year olds that can't
     * get the mod to work.
     */
    @PreInit
    public void preInit(FMLPreInitializationEvent event) 
    {
    	//make or load the config file
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        config.load();

        /*
         * This section is for item IDs and block IDs. Format is:
         * 
         * int itemnameID = config.getItem("itemname", id).getInt();
         * 
         * int blocknameID = config.getBlock("blockname", id).getInt();
         * 
         * MAKE SURE YOU MAKE A GLOBAL VARIABLE THAT CORRESPONDS WITH THE
         * WORD AFTER int 
         */
        BaconBurgerID = config.getItem("BaconBurger", 1914 ).getInt();
        TortillaID = config.getItem("Tortilla", 1915 ).getInt();
        TacoShellID = config.getItem("TacoShell", 1916 ).getInt();
        BeefTacoID = config.getItem("BeefTaco", 1917 ).getInt();
        DeluxeBeefTacoID = config.getItem("DeluxeBeefTaco", 1918 ).getInt();
        ChickenTacoID = config.getItem("ChickenTaco", 1919 ).getInt();
        DeluxeChickenTacoID = config.getItem("DeluxeChickenTaco", 1920 ).getInt();
        BeefBurritoID = config.getItem("BeefBurrito", 1921 ).getInt();
        DeluxeBeefBurritoID = config.getItem("DeluxeBeefBurrito", 1922 ).getInt();
        NoodlesID = config.getItem("Noodles", 1923 ).getInt();
        SpaghettiID = config.getItem("Spaghetti", 1924 ).getInt();
        SpaghettiAndMeatballsID = config.getItem("SpaghettiAndMeatballs", 1925 ).getInt();
        PotatoSlicesID = config.getItem("PotatoSlices", 1926 ).getInt();
        PotatoBitsID = config.getItem("PotatoBits", 1927 ).getInt();
        FriesID = config.getItem("Fries", 1928 ).getInt();
        CheeseFriesID = config.getItem("CheeseFries", 1929 ).getInt();
        TaterTotsID = config.getItem("TaterTots", 1930 ).getInt();
        PotatoChipsID = config.getItem("PotatoChips", 1931 ).getInt();
        SpicyPotatoChipsID = config.getItem("SpicyPotatoChips", 1932 ).getInt();
        CheesePotatoChipsID = config.getItem("CheesePotatoChips", 1933 ).getInt();
        SugarCookieID = config.getItem("SugarCookie", 1934 ).getInt();
        DoubleChocolateCookieID = config.getItem("DoubleChocolateCookie", 1935 ).getInt();
        CookedEggID = config.getItem("CookedEgg", 1936 ).getInt();
        ScrambledEggID = config.getItem("ScrambledEgg", 1937 ).getInt();
        BaconID = config.getItem("Bacon", 1938 ).getInt();
        PumpkinCookieID = config.getItem("PumpkinCookie", 1939 ).getInt();
        ChocolateAppleID = config.getItem("ChocolateApple", 1940 ).getInt();
        BarbecueChickenID = config.getItem("BarbecueChicken", 1941 ).getInt();
        ChickenFingerID = config.getItem("ChickenFinger", 1942 ).getInt();
        CheeseburgerID = config.getItem("Cheeseburger", 1943 ).getInt();
        ApplePieID = config.getItem("ApplePie", 1944 ).getInt();
        ChocolatePieID = config.getItem("ChocolatePie", 1945 ).getInt();
        ChocolateBarID = config.getItem("ChocolateBar", 1946 ).getInt();
        ChickenPizzaID = config.getItem("ChickenPizza", 1947 ).getInt();
        AnchoviesPizzaID = config.getItem("AnchoviesPizza", 1948 ).getInt();
        BeefPizzaID = config.getItem("BeefPizza", 1949 ).getInt();
        PepperoniPizzaID = config.getItem("PepperoniPizza", 1950 ).getInt();
        CheesePizzaID = config.getItem("CheesePizza", 1951 ).getInt();
        SauceID = config.getItem("Sauce", 1952 ).getInt();
        TomatoID = config.getItem("Tomato", 1953 ).getInt();
        BagelID = config.getItem("Bagel", 1954 ).getInt();
        CreamCheeseID = config.getItem("CreamCheese", 1955 ).getInt();
        BeefSandwichID = config.getItem("BeefSandwich", 1956 ).getInt();
        PorkSandwichID = config.getItem("PorkSandwich", 1957 ).getInt();
        ChickenSandwichID = config.getItem("ChickenSandwich", 1958 ).getInt();
        FishSandwichID = config.getItem("FishSandwich", 1959 ).getInt();
        ToastedBreadID = config.getItem("ToastedBread", 1960 ).getInt();
        BreadSliceID = config.getItem("BreadSlice", 1961 ).getInt();
        ToastID = config.getItem("Toast", 1962 ).getInt();
        CheeseID = config.getItem("Cheese", 1963 ).getInt();
        GrilledCheeseID = config.getItem("GrilledCheese", 1964 ).getInt();
        QuantumSwordID = config.getItem("QuantumSword", 1965 ).getInt();
        TomatoCropID = config.getBlock("TomatoCrop", 195 ).getInt();
        TomatoSeedID = config.getItem("TomatoSeed", 1966 ).getInt();
        QSUID = config.getBlock("QSU", 200 ).getInt();

        /*
         * Turn on or off certain sections of the mod. Format is
         * 
         * boolean UsePart = config.get(Configuration.CATEGORY_GENERAL, "UsePart", default value).getBoolean(default value);
         */

        boolean UseFood = config.get(Configuration.CATEGORY_GENERAL, "UseFood", true).getBoolean(true);

        config.save();
        proxy.getUseFood(UseFood);
    }
   
    @Init
    public void load(FMLInitializationEvent event) 
    {
    	/*
    	 * Load all items, then register their textures
    	 */

    	ItemQuantumSword = new ItemQuantumSword(QuantumSwordID, 6, 1F, false).setItemName("QuantumSword").setIconIndex(0);

    	BlockQSU = new BlockQSU(QSUID, 0).setHardness(3.0F).setResistance(3.0F).setItemName("QSU").setIconIndex(0);
    	
    	if(UseFood==true)
    	{
    		loadFood();
    		loadFoodRecipes();
    		registerFoodNames();
    	}
    	
    	/*
    	 * Load the recipes.
    	 * 
    	 * TODO Clean up recipes
    	 */
    	
    	GameRegistry.addRecipe(new ItemStack(ItemQuantumSword, 1), new Object [] {"T# ","%# ","!@!", Character.valueOf('T'), Items.getItem("teslaCoil").getItem(), Character.valueOf('#'), Items.getItem("iridiumPlate").getItem(),Character.valueOf('%'), Item.redstone, Character.valueOf('!'), Items.getItem("carbonPlate").getItem(), Character.valueOf('@'), Items.getItem("lapotronCrystal").getItem()});
        //ModLoader.addRecipe(new ItemStack(BlockQSU,1,0), new Object [] {"IFI","FTF","IFI", Character.valueOf('I'), Items.getItem("iridiumPlate").getItem(), Character.valueOf('F'), Items.getItem("mfsUnit").getItem(), Character.valueOf('T'), Items.getItem("hvTransformer")});
        
        /*
         * Add the names to Minecraft
         */
        LanguageRegistry.addName(ItemGrilledCheese, "Grilled Cheese");
        LanguageRegistry.addName(ItemQuantumSword, "Quantum Saber");



    	proxy.registerRenderers();



    }
   
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }
	
	/*
	 * This is the private (aka global) variable storage section
	 * Notice that the names correspond to stuff made in the config
	 * file and the block/item they represent.
	 */
	
    public static int BaconBurgerID;
    public static int TortillaID;
    public static int TacoShellID;
    public static int BeefTacoID;
    public static int DeluxeBeefTacoID;
    public static int ChickenTacoID;
    public static int DeluxeChickenTacoID;
    public static int BeefBurritoID;
    public static int DeluxeBeefBurritoID;
    public static int NoodlesID;
    public static int SpaghettiID;
    public static int SpaghettiAndMeatballsID;
    public static int PotatoSlicesID;
    public static int PotatoBitsID;
    public static int FriesID;
    public static int CheeseFriesID;
    public static int TaterTotsID;
    public static int PotatoChipsID;
    public static int SpicyPotatoChipsID;
    public static int CheesePotatoChipsID;
    public static int SugarCookieID;
    public static int DoubleChocolateCookieID;
    public static int CookedEggID;
    public static int ScrambledEggID;
    public static int BaconID;
    public static int PumpkinCookieID;
    public static int ChocolateAppleID;
    public static int BarbecueChickenID;
    public static int ChickenFingerID;
    public static int CheeseburgerID;
    public static int ApplePieID;
    public static int ChocolatePieID;
    public static int ChocolateBarID;
    public static int ChickenPizzaID;
    public static int AnchoviesPizzaID;
    public static int BeefPizzaID;
    public static int PepperoniPizzaID;
    public static int CheesePizzaID;
    public static int SauceID;
    public static int TomatoID;
    public static int BagelID;
    public static int CreamCheeseID;
    public static int BeefSandwichID;
    public static int PorkSandwichID;
    public static int ChickenSandwichID;
    public static int FishSandwichID;
    public static int ToastedBreadID;
    public static int BreadSliceID;
    public static int ToastID;
    public static int CheeseID;
    public static int GrilledCheeseID;
    public static int QuantumSwordID;
    public static int TomatoCropID;
    public static int TomatoSeedID;
    public static int QSUID;
    
    public static boolean UseFood;
    
    /*
     * Stores names of items, but they are useless until loaded (by the load event and the private voids that fill them)
     */
    
    public static Item ItemBaconBurger;
    public static Item ItemTortilla;
    public static Item ItemTacoShell;
    public static Item ItemBeefTaco;
    public static Item ItemDeluxeBeefTaco;
    public static Item ItemChickenTaco;
    public static Item ItemDeluxeChickenTaco;
    public static Item ItemBeefBurrito;
    public static Item ItemDeluxeBeefBurrito;
    public static Item ItemNoodles;
    public static Item ItemSpaghetti;
    public static Item ItemSpaghettiAndMeatballs;
    public static Item ItemPotatoSlices;
    public static Item ItemPotatoBits;
    public static Item ItemFries;
    public static Item ItemCheeseFries;
    public static Item ItemTaterTots;
    public static Item ItemPotatoChips;
    public static Item ItemSpicyPotatoChips;
    public static Item ItemCheesePotatoChips;
    public static Item ItemSugarCookie;
    public static Item ItemDoubleChocolateCookie;
    public static Item ItemCookedEgg;
    public static Item ItemScrambledEgg;
    public static Item ItemBacon;
    public static Item ItemPumpkinCookie;
    public static Item ItemChocolateApple;
    public static Item ItemBarbecueChicken;
    public static Item ItemChickenFinger;
    public static Item ItemCheeseburger;
    public static Item ItemApplePie;
    public static Item ItemChocolatePie;
    public static Item ItemChocolateBar;
    public static Item ItemChickenPizza;
    public static Item ItemAnchoviesPizza;
    public static Item ItemBeefPizza;
    public static Item ItemPepperoniPizza;
    public static Item ItemCheesePizza;
    public static Item ItemSauce;
    public static Item ItemTomato;
    public static Item ItemBagel;
    public static Item ItemCreamCheese;
    public static Item ItemBeefSandwich;
    public static Item ItemPorkSandwich;
    public static Item ItemChickenSandwich;
    public static Item ItemFishSandwich;
    public static Item ItemToastedBread;
    public static Item ItemBreadSlice;
    public static Item ItemToast;
    public static Item ItemCheese;
    public static Item ItemGrilledCheese;
    public static Item ItemQuantumSword;
    public static Block BlockTomatoCrop;
    public static ItemSeeds ItemTomatoSeed;
    public static Block BlockQSU;
    
    /*
     * Loads food items
     */
    private void loadFood()
    {
    	//TODO: make item classes in gibbycraft.items.food
    	 ItemBaconBurger = new ItemBaconBurger(BaconBurgerID, 16, 1.5F, false).setItemName("BaconBurger").setIconIndex(0);
    	 ItemTortilla = new ItemTortilla(TortillaID, 1, 0.3F, false).setItemName("Tortilla").setIconIndex(0);
    	 ItemTacoShell = new ItemTacoShell(TacoShellID, 2, 0.4F, false).setItemName("TacoShell").setIconIndex(0);
    	 ItemBeefTaco = new ItemBeefTaco(BeefTacoID, 10, 1F, false).setItemName("BeefTaco").setIconIndex(0);
    	 ItemDeluxeBeefTaco = new ItemDeluxeBeefTaco(DeluxeBeefTacoID, 15, 1.2F, false).setItemName("DeluxeBeefTaco").setIconIndex(0);
    	 ItemChickenTaco = new ItemChickenTaco(ChickenTacoID, 10, 1F, false).setItemName("ChickenTaco").setIconIndex(0);
    	 ItemDeluxeChickenTaco = new ItemDeluxeChickenTaco(DeluxeChickenTacoID, 15, 1.2F, false).setItemName("DeluxeChickenTaco").setIconIndex(0);
    	 ItemBeefBurrito = new ItemBeefBurrito(BeefBurritoID, 9, 1F, false).setItemName("BeefBurrito").setIconIndex(0);
    	 ItemDeluxeBeefBurrito = new ItemDeluxeBeefBurrito(DeluxeBeefBurritoID, 12, 1.3F, false).setItemName("DeluxeBeefBurrito").setIconIndex(0);
    	 ItemNoodles = new ItemNoodles(NoodlesID, 1, 0.3F, false).setItemName("Noodles").setIconIndex(0);
    	 ItemSpaghetti = new ItemSpaghetti(SpaghettiID, 8, 0.7F, false).setItemName("Spaghetti").setIconIndex(0);
    	 ItemSpaghettiAndMeatballs = new ItemSpaghettiAndMeatballs(SpaghettiAndMeatballsID, 15, 1.5F, false).setItemName("SpaghettiAndMeatballs").setIconIndex(0);
    	 ItemPotatoSlices = new ItemPotatoSlices(PotatoSlicesID, 2, 0.4F, false).setItemName("PotatoSlices").setIconIndex(0);
    	 ItemPotatoBits = new ItemPotatoBits(PotatoBitsID, 2, 0.4F, false).setItemName("PotatoBits").setIconIndex(0);
    	 ItemFries = new ItemFries(FriesID, 4, 0.6F, false).setItemName("Fries").setIconIndex(0);
    	 ItemCheeseFries = new ItemCheeseFries(CheeseFriesID, 7, 0.8F, false).setItemName("CheeseFries").setIconIndex(0);
    	 ItemTaterTots = new ItemTaterTots(TaterTotsID, 4, 0.6F, false).setItemName("TaterTots").setIconIndex(0);
    	 ItemPotatoChips = new ItemPotatoChips(PotatoChipsID, 4, 0.6F, false).setItemName("PotatoChips").setIconIndex(0);
    	 ItemSpicyPotatoChips = new ItemSpicyPotatoChips(SpicyPotatoChipsID, 7, 0.5F, false).setItemName("SpicyPotatoChips").setIconIndex(0);
    	 ItemCheesePotatoChips = new ItemCheesePotatoChips(CheesePotatoChipsID, 7, 0.5F, false).setItemName("CheesePotatoChips").setIconIndex(0);
    	 ItemSugarCookie = new ItemSugarCookie(SugarCookieID, 1, 0.1F, false).setItemName("SugarCookie").setIconIndex(0);
    	 ItemDoubleChocolateCookie = new ItemDoubleChocolateCookie(DoubleChocolateCookieID, 2, 0.3F, false).setItemName("DoubleChocolateCookie").setIconIndex(0);
    	 ItemCookedEgg = new ItemCookedEgg(CookedEggID, 3, 0.4F, false).setItemName("CookedEgg").setIconIndex(0);
    	 ItemScrambledEgg = new ItemScrambledEgg(ScrambledEggID, 6, 0.8F, false).setItemName("ScrambledEgg").setIconIndex(0);
    	 ItemBacon = new ItemBacon(BaconID, 2, 0.2F, false).setItemName("Bacon").setIconIndex(0);
    	 ItemPumpkinCookie = new ItemPumpkinCookie(PumpkinCookieID, 2, 0.4F, false).setItemName("PumpkinCookie").setIconIndex(0);
    	 ItemChocolateApple = new ItemChocolateApple(ChocolateAppleID, 6, 0.4F, false).setItemName("ChocolateApple").setIconIndex(0);
    	 ItemBarbecueChicken = new ItemBarbecueChicken(BarbecueChickenID, 4, 0.4F, false).setItemName("BarbecueChicken").setIconIndex(0);
    	 ItemChickenFinger = new ItemChickenFinger(ChickenFingerID, 2, 0.2F, false).setItemName("ChickenFinger").setIconIndex(0);
    	 ItemCheeseburger = new ItemCheeseburger(CheeseburgerID, 14, 1.3F, false).setItemName("Cheeseburger").setIconIndex(0);
    	 ItemApplePie = new ItemApplePie(ApplePieID, 10, 0.9F, false).setItemName("ApplePie").setIconIndex(0);
    	 ItemChocolatePie = new ItemChocolatePie(ChocolatePieID, 10, 0.9F, false).setItemName("ChocolatePie").setIconIndex(0);
    	 ItemChocolateBar = new ItemChocolateBar(ChocolateBarID, 7, 0.4F, false).setItemName("ChocolateBar").setIconIndex(0);
    	 ItemChickenPizza = new ItemChickenPizza(ChickenPizzaID, 18, 1.5F, false).setItemName("ChickenPizza").setIconIndex(0);
    	 ItemAnchoviesPizza = new ItemAnchoviesPizza(AnchoviesPizzaID, 18, 1.5F, false).setItemName("AnchoviesPizza").setIconIndex(0);
    	 ItemBeefPizza = new ItemBeefPizza(BeefPizzaID, 18, 1.5F, false).setItemName("BeefPizza").setIconIndex(0);
    	 ItemPepperoniPizza = new ItemPepperoniPizza(PepperoniPizzaID, 18, 1.5F, false).setItemName("PepperoniPizza").setIconIndex(0);
    	 ItemCheesePizza = new ItemCheesePizza(CheesePizzaID, 15, 1.2F, false).setItemName("CheesePizza").setIconIndex(0);
    	 ItemSauce = new ItemSauce(SauceID, 2, 0.3F, false).setItemName("Sauce").setIconIndex(0);
    	 ItemTomato = new ItemTomato(TomatoID, 1, 0.2F, false).setItemName("Tomato").setIconIndex(0);
    	 ItemBagel = new ItemBagel(BagelID, 8, 0.8F, false).setItemName("Bagel").setIconIndex(0);
    	 ItemCreamCheese = new ItemCreamCheese(CreamCheeseID, 2, 0.3F, false).setItemName("CreamCheese").setIconIndex(0);
    	 ItemBeefSandwich = new ItemBeefSandwich(BeefSandwichID, 12, 1F, false).setItemName("BeefSandwich").setIconIndex(0);
    	 ItemPorkSandwich = new ItemPorkSandwich(PorkSandwichID, 12, 1F, false).setItemName("PorkSandwich").setIconIndex(0);
    	 ItemChickenSandwich = new ItemChickenSandwich(ChickenSandwichID, 12, 1F, false).setItemName("ChickenSandwich").setIconIndex(0);
    	 ItemFishSandwich = new ItemFishSandwich(FishSandwichID, 12, 1F, false).setItemName("FishSandwich").setIconIndex(0);
    	 ItemToastedBread = new ItemToastedBread(ToastedBreadID, 8, 0.6F, false).setItemName("ToastedBread").setIconIndex(0);
    	 ItemBreadSlice = new ItemBreadSlice(BreadSliceID, 1, 0.6F, false).setItemName("BreadSlice").setIconIndex(0);
    	 ItemToast = new ItemToast(ToastID, 2, 0.6F, false).setItemName("Toast").setIconIndex(0);
    	 ItemCheese = new ItemCheese(CheeseID, 1, 0.3F, false).setItemName("Cheese").setIconIndex(0);
    	 ItemGrilledCheese = new ItemGrilledCheese(GrilledCheeseID, 6, 0.9F, false).setItemName("GrilledCheese").setIconIndex(0);

     	BlockTomatoCrop = new BlockTomatoCrop(TomatoCropID, 0);
        ItemTomatoSeed = (ItemSeeds) new ItemSeeds(TomatoSeedID,
                BlockTomatoCrop.blockID, Block.tilledField.blockID).setIconIndex(0)
                .setTextureFile(proxy.TomatoSeed);

    }
    
    private void loadFoodRecipes()
    {
    	GameRegistry.addRecipe(new ItemStack(ItemBaconBurger, 1), new Object [] {"#","!", Character.valueOf('#'), ItemBacon, Character.valueOf('!'), ItemCheeseburger}); 
        GameRegistry.addRecipe(new ItemStack(ItemPotatoSlices, 1), new Object [] {"#", Character.valueOf('#'), Item.potato});
        GameRegistry.addRecipe(new ItemStack(ItemPumpkinCookie, 8), new Object [] {"#!#", Character.valueOf('#'), Item.wheat, Character.valueOf('!'), Block.pumpkin});
        GameRegistry.addRecipe(new ItemStack(ItemPotatoChips, 1), new Object [] {"#", Character.valueOf('#'), ItemPotatoSlices});
        GameRegistry.addRecipe(new ItemStack(ItemBacon, 4), new Object [] {"#", Character.valueOf('#'), Item.porkCooked});
        GameRegistry.addRecipe(new ItemStack(ItemDoubleChocolateCookie, 1), new Object [] {"#","!", Character.valueOf('#'), new ItemStack(Item.dyePowder, 1, 3), Character.valueOf('!'), Item.cookie});
        GameRegistry.addRecipe(new ItemStack(ItemSugarCookie, 8), new Object [] {"#!#", Character.valueOf('#'), Item.wheat, Character.valueOf('!'), Item.sugar});
        GameRegistry.addRecipe(new ItemStack(ItemCheesePotatoChips, 1), new Object [] {"#","!", Character.valueOf('#'), ItemCheese, Character.valueOf('!'), ItemPotatoChips});
        GameRegistry.addRecipe(new ItemStack(ItemSpicyPotatoChips, 1), new Object [] {"#","!", Character.valueOf('#'), ItemSauce, Character.valueOf('!'), ItemPotatoChips});
        GameRegistry.addRecipe(new ItemStack(ItemCheeseFries, 1), new Object [] {"#","!", Character.valueOf('#'), ItemCheese, Character.valueOf('!'), ItemFries});
        GameRegistry.addRecipe(new ItemStack(ItemSpaghettiAndMeatballs, 1), new Object [] {"#","!", Character.valueOf('#'), Item.beefCooked, Character.valueOf('!'), ItemSpaghetti});
        GameRegistry.addRecipe(new ItemStack(ItemSpaghetti, 1), new Object [] {"###","!!!", Character.valueOf('#'), ItemSauce, Character.valueOf('!'), ItemNoodles});
        GameRegistry.addRecipe(new ItemStack(ItemDeluxeBeefBurrito, 1), new Object [] {"#","!","$", Character.valueOf('#'), ItemSauce, Character.valueOf('!'), ItemCheese, Character.valueOf('$'), ItemBeefBurrito});
        GameRegistry.addRecipe(new ItemStack(ItemBeefBurrito, 1), new Object [] {"#","!", Character.valueOf('#'), Item.beefCooked, Character.valueOf('!'), ItemTortilla});
        GameRegistry.addRecipe(new ItemStack(ItemDeluxeChickenTaco, 1), new Object [] {"#","!","$", Character.valueOf('#'), ItemSauce, Character.valueOf('!'), ItemCheese, Character.valueOf('$'), ItemChickenTaco});
        GameRegistry.addRecipe(new ItemStack(ItemChickenTaco, 1), new Object [] {"#","!", Character.valueOf('#'), Item.chickenCooked, Character.valueOf('!'), ItemTacoShell});
        GameRegistry.addRecipe(new ItemStack(ItemDeluxeBeefTaco, 1), new Object [] {"#","!","$", Character.valueOf('#'), ItemSauce, Character.valueOf('!'), ItemCheese, Character.valueOf('$'), ItemBeefTaco});
        GameRegistry.addRecipe(new ItemStack(ItemBeefTaco, 1), new Object [] {"#","!", Character.valueOf('#'), Item.beefCooked, Character.valueOf('!'), ItemTacoShell});
        GameRegistry.addRecipe(new ItemStack(ItemChocolateApple, 1), new Object [] {"#","!", Character.valueOf('#'), new ItemStack(Item.dyePowder, 1, 3), Character.valueOf('!'), Item.appleRed});
        GameRegistry.addRecipe(new ItemStack(ItemBarbecueChicken, 1), new Object [] {"#","!", Character.valueOf('#'), ItemSauce, Character.valueOf('!'), ItemChickenFinger});
        GameRegistry.addRecipe(new ItemStack(ItemChickenFinger, 3), new Object [] {"#", Character.valueOf('#'), Item.chickenCooked});
        GameRegistry.addRecipe(new ItemStack(ItemCheeseburger, 1), new Object [] {"#","!", Character.valueOf('#'), ItemCheese, Character.valueOf('!'), ItemBeefSandwich});
        GameRegistry.addRecipe(new ItemStack(ItemApplePie, 1), new Object [] {"WSW","WAW","WWW", Character.valueOf('W'), Item.wheat, Character.valueOf('S'), Item.sugar, Character.valueOf('A'), Item.appleRed});
        GameRegistry.addRecipe(new ItemStack(ItemChocolatePie, 1), new Object [] {"WSW","WCW","WWW", Character.valueOf('W'), Item.wheat, Character.valueOf('S'), Item.sugar, Character.valueOf('C'), new ItemStack(Item.dyePowder, 1, 3)});
        GameRegistry.addRecipe(new ItemStack(ItemChocolateBar, 1), new Object [] {"##","##","##", Character.valueOf('#'), ItemChocolateBar});
        GameRegistry.addRecipe(new ItemStack(ItemChocolateBar, 1), new Object[] {"#", "!",Character.valueOf('#'), Item.sugar, Character.valueOf('!'), new ItemStack(Item.dyePowder, 1, 3)});
        GameRegistry.addRecipe(new ItemStack(ItemChickenPizza, 1), new Object [] {"#","!", Character.valueOf('#'), Item.chickenCooked, Character.valueOf('!'), ItemCheesePizza});
        GameRegistry.addRecipe(new ItemStack(ItemAnchoviesPizza, 1), new Object [] {"#","!", Character.valueOf('#'), Item.fishCooked, Character.valueOf('!'), ItemCheesePizza});
        GameRegistry.addRecipe(new ItemStack(ItemBeefPizza, 1), new Object [] {"#","!", Character.valueOf('#'), Item.beefCooked, Character.valueOf('!'), ItemCheesePizza});
        GameRegistry.addRecipe(new ItemStack(ItemPepperoniPizza, 1), new Object [] {"#","!", Character.valueOf('#'), Item.porkCooked, Character.valueOf('!'), ItemCheesePizza});
        GameRegistry.addRecipe(new ItemStack(ItemCheesePizza, 1), new Object [] {"CCC","SSS","WWW", Character.valueOf('C'), ItemCheese, Character.valueOf('S'), ItemSauce, Character.valueOf('W'), Item.wheat});
        GameRegistry.addRecipe(new ItemStack(ItemBagel, 1), new Object [] {"B","C","B", Character.valueOf('B'), ItemToast, Character.valueOf('C'), ItemCreamCheese});
        GameRegistry.addRecipe(new ItemStack(ItemCreamCheese, 1), new Object [] {"C","B", Character.valueOf('C'), ItemCheese, Character.valueOf('B'), Item.bucketMilk});
        GameRegistry.addRecipe(new ItemStack(ItemBeefSandwich, 1), new Object [] {"B","M","B", Character.valueOf('B'), ItemToast, Character.valueOf('M'), Item.beefCooked});
        GameRegistry.addRecipe(new ItemStack(ItemPorkSandwich, 1), new Object [] {"B","M","B", Character.valueOf('B'), ItemToast, Character.valueOf('M'), Item.porkCooked});
        GameRegistry.addRecipe(new ItemStack(ItemChickenSandwich, 1), new Object [] {"B","M","B", Character.valueOf('B'), ItemToast, Character.valueOf('M'), Item.chickenCooked});
        GameRegistry.addRecipe(new ItemStack(ItemFishSandwich, 1), new Object [] {"B","M","B", Character.valueOf('B'), ItemToast, Character.valueOf('M'), Item.fishCooked});
        GameRegistry.addRecipe(new ItemStack(ItemToast, 4), new Object [] {"#", Character.valueOf('#'), ItemToastedBread});
        GameRegistry.addRecipe(new ItemStack(ItemBreadSlice, 4), new Object [] {"#", Character.valueOf('#'), Item.bread});
        GameRegistry.addRecipe(new ItemStack(ItemGrilledCheese, 1), new Object [] {"#","%","#", Character.valueOf('#'), ItemToast, Character.valueOf('%'), ItemCheese});
        GameRegistry.addRecipe(new ItemStack(ItemTomatoSeed, 1), new Object [] {"T", Character.valueOf('T'), ItemTomato});
        
        GameRegistry.addSmelting(TomatoID, new ItemStack(ItemSauce, 1), 0.1F);
        GameRegistry.addSmelting(Item.bread.shiftedIndex, new ItemStack(ItemToastedBread, 1), 0.1F);
        GameRegistry.addSmelting(BreadSliceID, new ItemStack(ItemToast, 1), 0.1F);
        GameRegistry.addSmelting(TortillaID, new ItemStack(ItemTacoShell, 1), 0.1F);
        GameRegistry.addSmelting(PotatoSlicesID, new ItemStack(ItemFries, 1), 0.1F);
        GameRegistry.addSmelting(PotatoBitsID, new ItemStack(ItemTaterTots, 1), 0.1F);
        GameRegistry.addSmelting(Item.egg.shiftedIndex, new ItemStack(ItemCookedEgg, 1), 0.1F);
        
        Ic2Recipes.addExtractorRecipe(new ItemStack(Item.bucketMilk, 1), new ItemStack(ItemCheese, 2));
        Ic2Recipes.addExtractorRecipe(new ItemStack(Item.wheat, 1), new ItemStack(ItemNoodles, 1));
        
        Ic2Recipes.addCompressorRecipe(new ItemStack(Item.wheat, 3), new ItemStack(ItemTortilla, 1));
        
        Ic2Recipes.addMaceratorRecipe(new ItemStack(Item.potato, 1), new ItemStack(ItemPotatoBits, 1));
        Ic2Recipes.addMaceratorRecipe(new ItemStack(ItemCookedEgg, 1), new ItemStack(ItemScrambledEgg, 1));
                
    }
	
    private void registerFoodNames()
    {
        LanguageRegistry.addName(ItemBaconBurger, "BaconBurger");
        LanguageRegistry.addName(ItemTortilla, "Tortilla");
        LanguageRegistry.addName(ItemTacoShell, "Taco Shell");
        LanguageRegistry.addName(ItemBeefTaco, "Beef Taco");
        LanguageRegistry.addName(ItemDeluxeBeefTaco, "Deluxe Beef Taco");
        LanguageRegistry.addName(ItemChickenTaco, "Chicken Taco");
        LanguageRegistry.addName(ItemDeluxeChickenTaco, "Deluxe Chicken Taco");
        LanguageRegistry.addName(ItemBeefBurrito, "Beef Burrito");
        LanguageRegistry.addName(ItemDeluxeBeefBurrito, "Deluxe Beef Burrito");
        LanguageRegistry.addName(ItemNoodles, "Noodles");
        LanguageRegistry.addName(ItemSpaghetti, "Spaghetti");
        LanguageRegistry.addName(ItemSpaghettiAndMeatballs, "Spaghetti And Meatballs");
        LanguageRegistry.addName(ItemPotatoSlices, "Potato Slices");
        LanguageRegistry.addName(ItemPotatoBits, "Potato Bits");
        LanguageRegistry.addName(ItemFries, "Fries");
        LanguageRegistry.addName(ItemCheeseFries, "Cheese Fries");
        LanguageRegistry.addName(ItemTaterTots, "Tater Tots");
        LanguageRegistry.addName(ItemPotatoChips, "Potato Chips");
        LanguageRegistry.addName(ItemSpicyPotatoChips, "Spicy Potato Chips");
        LanguageRegistry.addName(ItemCheesePotatoChips, "Cheese Potato Chips");
        LanguageRegistry.addName(ItemSugarCookie, "Sugar Cookie");
        LanguageRegistry.addName(ItemDoubleChocolateCookie, "Double Chocolate Cookie");
        LanguageRegistry.addName(ItemCookedEgg, "Cooked Egg");
        LanguageRegistry.addName(ItemScrambledEgg, "Scrambled Eggs");
        LanguageRegistry.addName(ItemBacon, "Bacon");
        LanguageRegistry.addName(ItemPumpkinCookie, "Pumpkin Cookie");
        LanguageRegistry.addName(ItemChocolateApple, "Chocolate Apple");
        LanguageRegistry.addName(ItemTomato, "Tomato");
        LanguageRegistry.addName(ItemBarbecueChicken, "Barbeque Chicken");
        LanguageRegistry.addName(ItemChickenFinger, "Chicken Finger");
        LanguageRegistry.addName(ItemCheeseburger, "Cheeseburger");
        LanguageRegistry.addName(ItemApplePie, "Apple Pie");
        LanguageRegistry.addName(ItemChocolatePie, "Chocolate Pie");
        LanguageRegistry.addName(ItemChickenPizza, "Chicken Pizza");
        LanguageRegistry.addName(ItemChocolateBar, "Chocoloate Bar");
        LanguageRegistry.addName(ItemAnchoviesPizza, "Anchovies Pizza");
        LanguageRegistry.addName(ItemBeefPizza, "Beef Pizza");
        LanguageRegistry.addName(ItemPepperoniPizza, "Pepperoni Pizza");          
        LanguageRegistry.addName(ItemCheesePizza, "Cheese Pizza");
        LanguageRegistry.addName(ItemSauce, "Sauce");
        LanguageRegistry.addName(ItemTomato, "Tomato");              
        LanguageRegistry.addName(ItemBagel, "Bagel");
        LanguageRegistry.addName(ItemCreamCheese, "Cream Cheese");
        LanguageRegistry.addName(ItemBeefSandwich, "Beef Sandwich");
        LanguageRegistry.addName(ItemPorkSandwich, "Pork Sandwich");
        LanguageRegistry.addName(ItemChickenSandwich, "Chicken Sandwich");
        LanguageRegistry.addName(ItemFishSandwich, "Fish Sandwich");
        LanguageRegistry.addName(ItemToastedBread, "Toasted Bread");
        LanguageRegistry.addName(ItemBreadSlice, "Bread Slice");
        LanguageRegistry.addName(ItemToast, "Toast");
        LanguageRegistry.addName(ItemCheese, "Cheese");
        LanguageRegistry.addName(BlockTomatoCrop, "Tomato Crop");
        LanguageRegistry.addName(ItemTomatoSeed, "Tomato Seed");

    }
}
