package net.anix.testmod.item;

import net.anix.testmod.TestMod;
import net.anix.testmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup TEST_MOD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "mod_items" ),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.KEYBOARD))
                    .displayName(Text.translatable("itemgroup.testmod.mod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.KEYBOARD);
                        entries.add(ModItems.CARBON);
                        entries.add(ModItems.WRENCH);
                        entries.add(ModItems.KATANA);
                        entries.add(ModItems.HATCHET);

                    }).build());
        public static final ItemGroup TEST_MOD_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "mod_blocks" ),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.SKIBIDI_TEO))
                    .displayName(Text.translatable("itemgroup.testmod.mod_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.XP_BLOCK);
                        entries.add(ModBlocks.CARBON_BLOCK);
                        entries.add(ModBlocks.SKIBIDI_TEO);

                    }).build());




    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Item Groups for"+ TestMod.MOD_ID);
    }
}
