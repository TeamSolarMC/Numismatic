package net.indevo.numismatic.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.indevo.numismatic.Numismatic;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class CoinExchangerRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final ResourceLocation id;

    public CoinExchangerRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> inputItems) {
        this.inputItems = inputItems;
        this.output = output;
        this.id = id;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }

        return inputItems.get(0).test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer p_44001_, RegistryAccess p_267165_) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return output.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.inputItems;
    }

    @Override
    public ResourceLocation m_6423_() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<CoinExchangerRecipe> {
        private Type() {
        }

        public static final Type INSTANCE = new Type();
        public static final String ID = "gem_empowering";
    }

    public static ItemStack itemStackFromJson(com.google.gson.JsonObject pStackObject) {
        return net.minecraftforge.common.crafting.CraftingHelper.getItemStack(pStackObject, true, true);
    }

    public static class Serializer implements RecipeSerializer<CoinExchangerRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Numismatic.MOD_ID, "gem_empowering");

        @Override
        public CoinExchangerRecipe m_6729_(ResourceLocation p_44103_, JsonObject p_44104_) {
            ItemStack output = ShapedRecipe.m_151274_(GsonHelper.getAsJsonObject(p_44104_, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(p_44104_, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.m_43917_(ingredients.get(i)));
            }

            return new CoinExchangerRecipe(p_44103_, output, inputs);
        }

        @Override
        public @Nullable CoinExchangerRecipe fromNetwork(ResourceLocation p_44105_, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            ItemStack output = pBuffer.readItem();
            return new CoinExchangerRecipe(p_44105_, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, CoinExchangerRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.getIngredients().size());

            for (Ingredient ing : pRecipe.getIngredients()) {
                ing.toNetwork(pBuffer);
            }
            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        }
    }
}
