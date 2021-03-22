package dev.projectearth.genoa_plugin.entities;

import dev.projectearth.genoa_plugin.GenoaPlugin;
import dev.projectearth.genoa_plugin.entities.chicken.*;
import dev.projectearth.genoa_plugin.entities.cow.*;
import dev.projectearth.genoa_plugin.entities.hostile.*;
import dev.projectearth.genoa_plugin.entities.neutral.*;
import dev.projectearth.genoa_plugin.entities.other.*;
import dev.projectearth.genoa_plugin.entities.pig.*;
import dev.projectearth.genoa_plugin.entities.projectile.*;
import dev.projectearth.genoa_plugin.entities.rabbit.*;
import dev.projectearth.genoa_plugin.entities.sheep.*;
import org.cloudburstmc.server.registry.EntityRegistry;

public class GenoaEntityLoader {
    public static void load() {
        /* Pigs */
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.MOTTLED_PIG, MottledPig::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.MUD_PIG, MudPig::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.PALE_PIG, PalePig::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.PIEBALD_PIG, PiebaldPig::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.PINK_FOOTED_PIG, PinkFootedPig::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.SOOTY_PIG, SootyPig::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.SPOTTED_PIG, SpottedPig::new, 1000, false);

        /* Sheep */
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.FLECKED_SHEEP, FleckedSheep::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.FUZZY_SHEEP, FuzzySheep::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.SHEEP, GenoaSheep::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.HORNED_SHEEP, HornedSheep::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.INKY_SHEEP, InkySheep::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.LONG_NOSED_SHEEP, LongNosedSheep::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.PATCHED_SHEEP, PatchedSheep::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.RAINBOW_SHEEP, RainbowSheep::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.ROCKY_SHEEP, RockySheep::new, 1000, false);

        /* Cows */
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.ALBINO_COW, AlbinoCow::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.ASHEN_COW, AshenCow::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.COOKIE_COW, CookieCow::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.CREAM_COW, CreamCow::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.DAIRY_COW, DairyCow::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.MOOLIP, Moolip::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.MOO_BLOOM, MooBloom::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.PINTO_COW, PintoCow::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.SUNSET_COW, SunsetCow::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.UMBRA_COW, UmbraCow::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.WOOLY_COW, WoolyCow::new, 1000, false);

        /* Chickens */
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.AMBER_CHICKEN, AmberChicken::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.BRONZED_CHICKEN, BronzedChicken::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.CLUCK_SHROOM, CluckShroom::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.FANCY_CHICKEN, FancyChicken::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.GOLD_CRESTED_CHICKEN, GoldCrestedChicken::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.MIDNIGHT_CHICKEN, MidnightChicken::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.SKEWBALD_CHICKEN, SkewbaldChicken::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.STORMY_CHICKEN, StormyChicken::new, 1000, false);

        /* Rabbits */
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.BOLD_STRIPED_RABBIT, BoldStripedRabbit::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.FRECKLED_RABBIT, FreckledRabbit::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.HARELEQUIN_RABBIT, HarelequinRabbit::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.JUMBO_RABBIT, JumboRabbit::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.MUDDY_FOOT_RABBIT, MuddyFootRabbit::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.VESTED_RABBIT, VestedRabbit::new, 1000, false);

        /* Neutral mobs */
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.GLOW_SQUID, GlowSquid::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.JOLLY_LLAMA, JollyLlama::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.FURNACE_GOLEM, FurnaceGolem::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.MELON_GOLEM, MelonGolem::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.TROPICAL_SLIME, TropicalSlime::new, 1000, false);

        /* Hostile mobs */
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.BOULDERING_ZOMBIE, BoulderingZombie::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.LOBBER_ZOMBIE, LobberZombie::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.SKELETON_WOLF, SkeletonWolf::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.BONE_SPIDER, BoneSpider::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.VILER_WITCH, VilerWitch::new, 1000, false);

        /* Other mobs */
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.GENOA_SLIME, GenoaSlime::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.GENOA_SLIME_HALF, GenoaSlimeHalf::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.GENOA_SLIME_QUARTER, GenoaSlimeQuarter::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.OOBE_SKELETON, OobeSkeleton::new, 1000, false);

        /* Projectiles */
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.BONE_SHARD, BoneShard::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.MELON_SEED_PROJECTILE, MelonSeedProjectile::new, 1000, false);
        EntityRegistry.get().register(GenoaPlugin.get(), GenoaEntityTypes.ROTTEN_FLESH_PROJECTILE, RottenFleshProjectile::new, 1000, false);

        /*
        Missing mobs:
        "genoa:neutral_dummy",
        "genoa:albino_rabbit",
        "genoa:desert_rabbit",
        "genoa:blotched_rabbit",
        "genoa:violet_rabbit",
        "genoa:sable_rabbit",
        "genoa:toast_rabbit",
        "genoa:dusky_rabbit",
        "genoa:salt_and_pepper_rabbit",
        "genoa:melon_seeds",
        "genoa:hostile_dummy",
         */
    }
}
