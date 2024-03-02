package net.indevo.numismatic.datagen.loot;

import net.indevo.numismatic.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.AMETHYST_COINSTACK.get());
        this.dropSelf(ModBlocks.EMERALD_COINSTACK.get());
        this.dropSelf(ModBlocks.LAPIS_COINSTACK.get());
        this.dropSelf(ModBlocks.COPPER_COINSTACK.get());
        this.dropSelf(ModBlocks.DIAMOND_COINSTACK.get());
        this.dropSelf(ModBlocks.GOLD_COINSTACK.get());
        this.dropSelf(ModBlocks.IRON_COINSTACK.get());
        this.dropSelf(ModBlocks.NETHERITE_COINSTACK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
