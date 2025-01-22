package net.anix.testmod.item;

import net.anix.testmod.TestMod;
import net.anix.testmod.item.custom.WrenchItem;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item KEYBOARD = registerItem("keyboard", new Item(new Item.Settings()));
    public static final Item CARBON = registerItem("carbon", new Item(new Item.Settings()));

    public static final Item WRENCH = registerItem("wrench", new WrenchItem(new Item.Settings().maxDamage(64).maxCount(1)));

    public static final Item KATANA = registerItem("katana",
            new SwordItem(ToolMaterials.NETHERITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -2.1F))));
    public static final Item HATCHET = registerItem("hatchet",
            new AxeItem(ToolMaterials.NETHERITE, new Item.Settings()
                    .fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers( ToolMaterials.NETHERITE,  4, -2.7F))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name) , item);
    }

    public static void registerModItems(){
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(KEYBOARD);

        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(CARBON);

        });
    }
}
