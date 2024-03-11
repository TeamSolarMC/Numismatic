package net.indevo.numismatic.recipe;

import net.indevo.numismatic.Numismatic;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Numismatic.MOD_ID);

    public static final RegistryObject<RecipeSerializer<CoinExchangerRecipe>> COIN_EXCHANGE_SERIALIZER =
            SERIALIZERS.register("coin_exchange", () -> CoinExchangerRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
