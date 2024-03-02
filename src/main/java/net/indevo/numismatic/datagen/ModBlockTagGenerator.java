package net.indevo.numismatic.datagen;

import net.indevo.numismatic.Numismatic;
import net.indevo.numismatic.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper ){
        super(output, lookupProvider, Numismatic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider ){
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.AMETHYST_COINSTACK.get(),
                        ModBlocks.EMERALD_COINSTACK.get(),
                        ModBlocks.COPPER_COINSTACK.get(),
                        ModBlocks.DIAMOND_COINSTACK.get(),
                        ModBlocks.GOLD_COINSTACK.get(),
                        ModBlocks.IRON_COINSTACK.get(),
                        ModBlocks.NETHERITE_COINSTACK.get(),
                        ModBlocks.LAPIS_COINSTACK.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
