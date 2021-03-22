package dev.projectearth.genoa_plugin.entities.hostile;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.hostile.EntityZombie;
import org.cloudburstmc.server.entity.hostile.Zombie;
import org.cloudburstmc.server.level.Location;

public class BoulderingZombie extends EntityZombie {
    public BoulderingZombie(EntityType<Zombie> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Bouldering Zombie";
    }
}
