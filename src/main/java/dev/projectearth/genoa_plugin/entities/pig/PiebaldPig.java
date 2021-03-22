package dev.projectearth.genoa_plugin.entities.pig;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.passive.EntityPig;
import org.cloudburstmc.server.entity.passive.Pig;
import org.cloudburstmc.server.level.Location;

public class PiebaldPig extends EntityPig {
    public PiebaldPig(EntityType<Pig> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Piebald Pig";
    }
}
