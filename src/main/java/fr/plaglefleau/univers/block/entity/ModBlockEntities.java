package fr.plaglefleau.univers.block.entity;

import fr.plaglefleau.univers.Univers;
import fr.plaglefleau.univers.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<ScrollWriterBlockEntity> SCROLL_WRITER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier("scroll_writer_be"),
                    FabricBlockEntityTypeBuilder.create(ScrollWriterBlockEntity::new, ModBlocks.SCROLL_WRITER).build());

    public static void registerBlockEntities() {
        Univers.LOGGER.info("Registering Block Entities for %s".formatted(Univers.MOD_ID));
    }
}
