package dev.projectearth.genoa_plugin.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nukkitx.math.vector.Vector2f;
import com.nukkitx.math.vector.Vector3f;
import com.nukkitx.math.vector.Vector3i;
import dev.projectearth.genoa_plugin.deserializers.Base64Deserializer;
import dev.projectearth.genoa_plugin.deserializers.Vector2fDeserializer;
import dev.projectearth.genoa_plugin.deserializers.Vector3fDeserializer;
import dev.projectearth.genoa_plugin.deserializers.Vector3iDeserializer;
import lombok.Getter;
import org.cloudburstmc.server.block.BlockState;
import org.cloudburstmc.server.registry.BlockRegistry;
import org.cloudburstmc.server.utils.Identifier;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Buildplate {
    private BuildplateResult result;
}


