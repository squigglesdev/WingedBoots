package dev.squiggles.entity.spawner;

import dev.squiggles.WingedBoots;
import dev.squiggles.entity.CloudEntity;
import dev.squiggles.entity.Entities;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.SpawnHelper;
import net.minecraft.world.spawner.SpecialSpawner;


public class CloudSpawner implements SpecialSpawner {

    @Override
    public int spawn(ServerWorld world, boolean spawnMonsters, boolean spawnAnimals) {
        int count = 0;


        for (int i = 0; i < 2; i++) { // Spawn roughly two per chunk
            int x = world.random.nextInt(16) + 8;
            int z = world.random.nextInt(16) + 8;
            int y = world.getTopY(Heightmap.Type.WORLD_SURFACE, x, z) - world.random.nextInt(200); // Adjust the height as needed

            WingedBoots.LOGGER.debug("spawnin' a cloud");
            BlockPos pos = new BlockPos(x, y, z);

            if (SpawnHelper.isClearForSpawn(world, pos, world.getBlockState(pos), world.getFluidState(pos), Entities.CLOUD_ENTITY)) {
                CloudEntity cloudEntity = new CloudEntity(Entities.CLOUD_ENTITY, world);
                cloudEntity.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, world.random.nextFloat() * 360.0F, 0.0F);
                world.spawnEntity(cloudEntity);
                count++;
            }
        }


        return count;
    }
}
