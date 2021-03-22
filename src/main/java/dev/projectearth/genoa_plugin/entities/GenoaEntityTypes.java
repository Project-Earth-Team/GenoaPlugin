package dev.projectearth.genoa_plugin.entities;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.hostile.*;
import org.cloudburstmc.server.entity.passive.*;
import org.cloudburstmc.server.entity.projectile.Arrow;

public class GenoaEntityTypes {
    /* Pigs */
    public static final EntityType<Pig> MOTTLED_PIG = EntityType.from("genoa:mottled_pig", Pig.class);
    public static final EntityType<Pig> MUD_PIG = EntityType.from("genoa:mud_pig", Pig.class);
    public static final EntityType<Pig> PALE_PIG = EntityType.from("genoa:pale_pig", Pig.class);
    public static final EntityType<Pig> PIEBALD_PIG = EntityType.from("genoa:piebald_pig", Pig.class);
    public static final EntityType<Pig> PINK_FOOTED_PIG = EntityType.from("genoa:pink_footed_pig", Pig.class);
    public static final EntityType<Pig> SOOTY_PIG = EntityType.from("genoa:sooty_pig", Pig.class);
    public static final EntityType<Pig> SPOTTED_PIG = EntityType.from("genoa:spotted_pig", Pig.class);

    /* Sheep */
    public static final EntityType<Sheep> FLECKED_SHEEP = EntityType.from("genoa:flecked_sheep", Sheep.class);
    public static final EntityType<Sheep> FUZZY_SHEEP = EntityType.from("genoa:fuzzy_sheep", Sheep.class);
    public static final EntityType<Sheep> SHEEP = EntityType.from("genoa:sheep", Sheep.class);
    public static final EntityType<Sheep> HORNED_SHEEP = EntityType.from("genoa:horned_sheep", Sheep.class);
    public static final EntityType<Sheep> INKY_SHEEP = EntityType.from("genoa:inky_sheep", Sheep.class);
    public static final EntityType<Sheep> LONG_NOSED_SHEEP = EntityType.from("genoa:long_nosed_sheep", Sheep.class);
    public static final EntityType<Sheep> PATCHED_SHEEP = EntityType.from("genoa:patched_sheep", Sheep.class);
    public static final EntityType<Sheep> RAINBOW_SHEEP = EntityType.from("genoa:rainbow_sheep", Sheep.class);
    public static final EntityType<Sheep> ROCKY_SHEEP = EntityType.from("genoa:rocky_sheep", Sheep.class);

    /* Cows */
    public static final EntityType<Cow> ALBINO_COW = EntityType.from("genoa:albino_cow", Cow.class);
    public static final EntityType<Cow> ASHEN_COW = EntityType.from("genoa:ashen_cow", Cow.class);
    public static final EntityType<Cow> COOKIE_COW = EntityType.from("genoa:cookie_cow", Cow.class);
    public static final EntityType<Cow> CREAM_COW = EntityType.from("genoa:cream_cow", Cow.class);
    public static final EntityType<Cow> DAIRY_COW = EntityType.from("genoa:dairy_cow", Cow.class);
    public static final EntityType<Cow> MOOLIP = EntityType.from("genoa:moolip", Cow.class);
    public static final EntityType<Cow> MOO_BLOOM = EntityType.from("genoa:moo_bloom", Cow.class);
    public static final EntityType<Cow> PINTO_COW = EntityType.from("genoa:pinto_cow", Cow.class);
    public static final EntityType<Cow> SUNSET_COW = EntityType.from("genoa:sunset_cow", Cow.class);
    public static final EntityType<Cow> UMBRA_COW = EntityType.from("genoa:umbra_cow", Cow.class);
    public static final EntityType<Cow> WOOLY_COW = EntityType.from("genoa:wooly_cow", Cow.class);

    /* Chickens */
    public static final EntityType<Chicken> AMBER_CHICKEN = EntityType.from("genoa:amber_chicken", Chicken.class);
    public static final EntityType<Chicken> BRONZED_CHICKEN = EntityType.from("genoa:bronzed_chicken", Chicken.class);
    public static final EntityType<Chicken> CLUCK_SHROOM = EntityType.from("genoa:cluck_shroom", Chicken.class);
    public static final EntityType<Chicken> FANCY_CHICKEN = EntityType.from("genoa:fancy_chicken", Chicken.class);
    public static final EntityType<Chicken> GOLD_CRESTED_CHICKEN = EntityType.from("genoa:gold_crested_chicken", Chicken.class);
    public static final EntityType<Chicken> MIDNIGHT_CHICKEN = EntityType.from("genoa:midnight_chicken", Chicken.class);
    public static final EntityType<Chicken> SKEWBALD_CHICKEN = EntityType.from("genoa:skewbald_chicken", Chicken.class);
    public static final EntityType<Chicken> STORMY_CHICKEN = EntityType.from("genoa:stormy_chicken", Chicken.class);

    /* Rabbits */
    public static final EntityType<Rabbit> BOLD_STRIPED_RABBIT = EntityType.from("genoa:bold_striped_rabbit", Rabbit.class);
    public static final EntityType<Rabbit> FRECKLED_RABBIT = EntityType.from("genoa:freckled_rabbit", Rabbit.class);
    public static final EntityType<Rabbit> HARELEQUIN_RABBIT = EntityType.from("genoa:harelequin_rabbit", Rabbit.class);
    public static final EntityType<Rabbit> JUMBO_RABBIT = EntityType.from("genoa:jumbo_rabbit", Rabbit.class);
    public static final EntityType<Rabbit> MUDDY_FOOT_RABBIT = EntityType.from("genoa:muddy_foot_rabbit", Rabbit.class);
    public static final EntityType<Rabbit> VESTED_RABBIT = EntityType.from("genoa:vested_rabbit", Rabbit.class);

    /* Neutral mobs */
    public static final EntityType<Squid> GLOW_SQUID = EntityType.from("genoa:glow_squid", Squid.class);
    public static final EntityType<Llama> JOLLY_LLAMA = EntityType.from("genoa:jolly_llama", Llama.class);
    public static final EntityType<IronGolem> FURNACE_GOLEM = EntityType.from("genoa:furnace_golem", IronGolem.class);
    public static final EntityType<SnowGolem> MELON_GOLEM = EntityType.from("genoa:melon_golem", SnowGolem.class);
    public static final EntityType<Slime> TROPICAL_SLIME = EntityType.from("genoa:tropical_slime", Slime.class);

    /* Hostile mobs */
    public static final EntityType<Zombie> BOULDERING_ZOMBIE = EntityType.from("genoa:bouldering_zombie", Zombie.class);
    public static final EntityType<Zombie> LOBBER_ZOMBIE = EntityType.from("genoa:lobber_zombie", Zombie.class);
    public static final EntityType<Wolf> SKELETON_WOLF = EntityType.from("genoa:skeleton_wolf", Wolf.class);
    public static final EntityType<Spider> BONE_SPIDER = EntityType.from("genoa:bone_spider", Spider.class);
    public static final EntityType<Witch> VILER_WITCH = EntityType.from("genoa:viler_witch", Witch.class);

    /* Other mobs */
    public static final EntityType<Slime> GENOA_SLIME = EntityType.from("genoa:genoa_slime", Slime.class);
    public static final EntityType<Slime> GENOA_SLIME_HALF = EntityType.from("genoa:genoa_slime_half", Slime.class);
    public static final EntityType<Slime> GENOA_SLIME_QUARTER = EntityType.from("genoa:genoa_slime_quarter", Slime.class);
    public static final EntityType<Skeleton> OOBE_SKELETON = EntityType.from("genoa:oobe_skeleton", Skeleton.class);

    /* Projectiles */
    public static final EntityType<Arrow> BONE_SHARD = EntityType.from("genoa:bone_shard", Arrow.class);
    public static final EntityType<Arrow> MELON_SEED_PROJECTILE = EntityType.from("genoa:melon_seed_projectile", Arrow.class);
    public static final EntityType<Arrow> ROTTEN_FLESH_PROJECTILE = EntityType.from("genoa:rotten_flesh_projectile", Arrow.class);
}
