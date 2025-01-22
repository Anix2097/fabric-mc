package net.anix.testmod.block;


import net.anix.testmod.TestMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.client.sound.Sound;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block CARBON_BLOCK = registerBlock("carbon_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.ANCIENT_DEBRIS)
                    ));

    public static final Block SKIBIDI_TEO = registerBlock("skibidi_teo",
            new Block(AbstractBlock.Settings.create()
                    .strength(10f).sounds(BlockSoundGroup.GLASS)
                ));

    public static final Block XP_BLOCK = registerBlock("xp_block",
            new ExperienceDroppingBlock(UniformIntProvider.create(27, 66),
                    AbstractBlock.Settings.create()
                    .strength(0.5f, 0.5f).sounds(BlockSoundGroup.GLASS)
                            .requiresTool()
            ));




    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TestMod.MOD_ID, name), block);}
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));}
    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering Mod Blocks for " + TestMod.MOD_ID);



        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

            entries.add(ModBlocks.CARBON_BLOCK);
            entries.add(ModBlocks.SKIBIDI_TEO);
        });
    }
}