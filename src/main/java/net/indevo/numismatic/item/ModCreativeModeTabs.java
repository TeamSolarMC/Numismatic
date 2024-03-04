package net.indevo.numismatic.item;

import net.indevo.numismatic.Numismatic;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Numismatic.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NUMISMATIC_TAB = CREATIVE_MODE_TABS.register("numismatic_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NETHERITE_COIN.get()))
                    .title(Component.translatable("creativetab.numismatic_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.COPPER_COIN.get());
                        output.accept(ModItems.IRON_COIN.get());
                        output.accept(ModItems.GOLD_COIN.get());
                        output.accept(ModItems.DIAMOND_COIN.get());
                        output.accept(ModItems.EMERALD_COIN.get());
                        output.accept(ModItems.NETHERITE_COIN.get());
                        output.accept(ModItems.AMETHYST_COIN.get());
                        output.accept(ModItems.LAPIS_COIN.get());


                        output.accept(ModItems.AMETHYST_COINSTACK.get());
                        output.accept(ModItems.EMERALD_COINSTACK.get());
                        output.accept(ModItems.LAPIS_COINSTACK.get());
                        output.accept(ModItems.COPPER_COINSTACK.get());
                        output.accept(ModItems.DIAMOND_COINSTACK.get());
                        output.accept(ModItems.GOLD_COINSTACK.get());
                        output.accept(ModItems.IRON_COINSTACK.get());
                        output.accept(ModItems.NETHERITE_COINSTACK.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
