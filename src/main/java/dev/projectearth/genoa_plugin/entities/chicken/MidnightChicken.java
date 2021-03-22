package dev.projectearth.genoa_plugin.entities.chicken;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.passive.EntityChicken;
import org.cloudburstmc.server.entity.passive.Chicken;
import org.cloudburstmc.server.level.Location;

public class MidnightChicken extends EntityChicken {
    public MidnightChicken(EntityType<Chicken> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Midnight Chicken";
    }
}
