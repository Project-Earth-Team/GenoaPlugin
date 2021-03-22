package dev.projectearth.genoa_plugin.entities.hostile;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.hostile.EntitySpider;
import org.cloudburstmc.server.entity.hostile.Spider;
import org.cloudburstmc.server.level.Location;

public class BoneSpider extends EntitySpider {
    public BoneSpider(EntityType<Spider> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Bone Spider";
    }
}
