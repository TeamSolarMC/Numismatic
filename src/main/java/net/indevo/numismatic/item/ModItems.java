package net.indevo.numismatic.item;

import net.indevo.numismatic.Numismatic;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Numismatic.MOD_ID);

    public static final RegistryObject<Item> COPPER_COIN = ITEMS.register("copper_coin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_COIN = ITEMS.register("iron_coin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_COIN = ITEMS.register("gold_coin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_COIN = ITEMS.register("diamond_coin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_COIN = ITEMS.register("emerald_coin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_COIN = ITEMS.register("netherite_coin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_COIN = ITEMS.register("amethyst_coin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_COIN = ITEMS.register("lapis_coin",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COPPER_COINSTACK = ITEMS.register("copper_coinstack",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_COINSTACK = ITEMS.register("iron_coinstack",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_COINSTACK = ITEMS.register("gold_coinstack",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_COINSTACK = ITEMS.register("diamond_coinstack",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_COINSTACK = ITEMS.register("emerald_coinstack",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_COINSTACK = ITEMS.register("netherite_coinstack",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_COINSTACK = ITEMS.register("amethyst_coinstack",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_COINSTACK = ITEMS.register("lapis_coinstack",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
