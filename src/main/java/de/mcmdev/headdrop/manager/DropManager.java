package de.mcmdev.headdrop.manager;

import de.mcmdev.headdrop.HeadDropsPlugin;
import de.mcmdev.headdrop.api.entityspecifier.EntitySpecifier;
import de.mcmdev.headdrop.api.entityspecifier.impl.*;
import de.mcmdev.headdrop.config.HeadConfig;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

import static org.bukkit.entity.EntityType.*;

public class DropManager {

    private HeadDropsPlugin plugin;
    private Map<EntityType, EntitySpecifier> specifierMap = new HashMap<>();

    public DropManager(HeadDropsPlugin plugin) {
        this.plugin = plugin;
        specifierMap.put(HORSE, new HorseSpecifier(this));
        specifierMap.put(BAT, new BatSpecifier(this));
        specifierMap.put(CAT, new CatSpecifier(this));
        specifierMap.put(CHICKEN, new ChickenSpecifier(this));
        specifierMap.put(COD, new CodSpecifier(this));
        specifierMap.put(COW, new CowSpecifier(this));
        specifierMap.put(DONKEY, new DonkeySpecifier(this));
        specifierMap.put(FOX, new FoxSpecifier(this));
        specifierMap.put(MUSHROOM_COW, new MooshroomSpecifier(this));
        specifierMap.put(MULE, new MuleSpecifier(this));
        specifierMap.put(OCELOT, new OcelotSpecifier(this));
        specifierMap.put(PARROT, new ParrotSpecifier(this));
        specifierMap.put(PIG, new PigSpecifier(this));
        specifierMap.put(RABBIT, new RabbitSpecifier(this));
        specifierMap.put(SALMON, new SalmonSpecifier(this));
        specifierMap.put(SHEEP, new SheepSpecifier(this));
        specifierMap.put(SQUID, new SquidSpecifier(this));
        specifierMap.put(TROPICAL_FISH, new TropicalFishSpecifier(this));
        specifierMap.put(TURTLE, new TurtleSpecifier(this));
        specifierMap.put(VILLAGER, new VillagerSpecifier(this));
        specifierMap.put(WANDERING_TRADER, new WandererSpecifier(this));

        specifierMap.put(PUFFERFISH, new PufferfishSpecifier(this));
        specifierMap.put(DOLPHIN, new DolphinSpecifier(this));
        specifierMap.put(LLAMA, new LlamaSpecifier(this));
        specifierMap.put(PANDA, new PandaSpecifier(this));
        specifierMap.put(POLAR_BEAR, new PolarBearSpecifier(this));
        specifierMap.put(TRADER_LLAMA, new TraderLlamaSpecifier(this));
        specifierMap.put(WOLF, new WolfSpecifier(this));
        specifierMap.put(CAVE_SPIDER, new CaveSpiderSpecifier(this));
        specifierMap.put(ENDERMAN, new EndermanSpecifier(this));
        specifierMap.put(SPIDER, new SpiderSpecifier(this));
        specifierMap.put(PIG_ZOMBIE, new PigZombieSpecifier(this));

        specifierMap.put(BLAZE, new BlazeSpecifier(this));
        specifierMap.put(CREEPER, new CreeperSpecifier(this));
        specifierMap.put(DROWNED, new DrownedSpecifier(this));
        specifierMap.put(ELDER_GUARDIAN, new ElderGuardianSpecifier(this));
        specifierMap.put(ENDERMITE, new EndermiteSpecifier(this));
        specifierMap.put(EVOKER, new EvokerSpecifier(this));
        specifierMap.put(GHAST, new GhastSpecifier(this));
        specifierMap.put(GUARDIAN, new GuardianSpecifier(this));
        specifierMap.put(HUSK, new HuskSpecifier(this));
        specifierMap.put(MAGMA_CUBE, new MagmaSpecifier(this));
        specifierMap.put(PHANTOM, new PhantomSpecifier(this));
        specifierMap.put(PILLAGER, new PillagerSpecifier(this));
        specifierMap.put(RAVAGER, new RavagerSpecifier(this));
        specifierMap.put(SHULKER, new ShulkerSpecifier(this));
        specifierMap.put(SILVERFISH, new ShulkerSpecifier(this));
        specifierMap.put(SKELETON, new SkeletonSpecifier(this));
        specifierMap.put(SLIME, new SlimeSpecifier(this));
        specifierMap.put(STRAY, new StraySpecifier(this));
        specifierMap.put(VEX, new VexSpecifier(this));
        specifierMap.put(VINDICATOR, new VindicatorSpecifier(this));
        specifierMap.put(WITCH, new WitchSpecifier(this));
        specifierMap.put(WITHER_SKELETON, new WitherSkeletonSpecifier(this));
        specifierMap.put(ZOMBIE, new ZombieSpecifier(this));
        specifierMap.put(ZOMBIE_VILLAGER, new ZombieVillagerSpecifier(this));
    }

    public EntitySpecifier getSpecifier(EntityType entityType) {
        return specifierMap.get(entityType);
    }

    public boolean hasSpecifier(EntityType entityType) {
        return specifierMap.containsKey(entityType);
    }

    public HeadConfig getHeadConfig()   {
        return plugin.getHeadConfig();
    }
}
