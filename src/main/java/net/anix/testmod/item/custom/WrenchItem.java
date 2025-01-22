package net.anix.testmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;


public class WrenchItem extends Item {
    public static final Map<Block, Block> WRENCH_MAP =
           Map.ofEntries(
                   Map.entry(Blocks.STONE, Blocks.STONE_BRICKS),
                   Map.entry(Blocks.STONE_SLAB, Blocks.STONE_BRICK_SLAB),
                   Map.entry(Blocks.STONE_STAIRS, Blocks.STONE_BRICK_STAIRS),
                   Map.entry(Blocks.END_STONE, Blocks.END_STONE_BRICKS),
                   Map.entry(Blocks.PACKED_MUD, Blocks.MUD_BRICKS),
                   Map.entry(Blocks.NETHERRACK, Blocks.NETHER_BRICKS),
                   Map.entry(Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS),
                   Map.entry(Blocks.STRIPPED_OAK_WOOD, Blocks.BOOKSHELF),
                   Map.entry(Blocks.CORNFLOWER, Blocks.DIAMOND_BLOCK),
                   Map.entry(Blocks.AZURE_BLUET, Blocks.IRON_BLOCK),
                   Map.entry(Blocks.POPPY, Blocks.ENCHANTING_TABLE),
                   Map.entry(Blocks.POLISHED_GRANITE_STAIRS, Blocks.NETHERITE_BLOCK),
                   Map.entry(Blocks.OXEYE_DAISY, Blocks.HEAVY_CORE)
                   );


    public WrenchItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(WRENCH_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()){
                world.setBlockState(context.getBlockPos(), WRENCH_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
            }
        }


        return ActionResult.SUCCESS;
    }
}
