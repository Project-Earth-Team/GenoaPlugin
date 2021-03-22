package dev.projectearth.genoa_plugin.entities.neutral;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.passive.EntityIronGolem;
import org.cloudburstmc.server.entity.passive.IronGolem;
import org.cloudburstmc.server.level.Location;

public class FurnaceGolem extends EntityIronGolem {
    public FurnaceGolem(EntityType<IronGolem> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Furnace Golem";
    }
}
