package dev.projectearth.genoa_plugin.utils;

import lombok.Getter;

public enum MobColor {
    WHITE((byte) 0, 0xF0F0F0),
    ORANGE((byte) 1, 0xF9801D),
    MAGENTA((byte) 2, 0xC74EBD),
    LIGHT_BLUE((byte) 3, 0x3AB3DA),
    YELLOW((byte) 4, 0xFED83D),
    LIME((byte) 5, 0x80C71F),
    PINK((byte) 6, 0xF38BAA),
    GRAY((byte) 7, 0x474F52),
    LIGHT_GRAY((byte) 8, 0x9D9D97),
    CYAN((byte) 9, 0x169C9C),
    PURPLE((byte) 10, 0x8932B8),
    BLUE((byte) 11, 0x3C44AA),
    BROWN((byte) 12, 0x835432),
    GREEN((byte) 13, 0x5E7C16),
    RED((byte) 14, 0xB02E26),
    BLACK((byte) 15, 0x1D1D21);

    private static final MobColor[] VALUES = values();

    @Getter
    private byte bedrockID;
    @Getter
    private int colorCode;

    MobColor(byte bedrockID, int colorCode) {
        this.bedrockID = bedrockID;
        this.colorCode = colorCode;
    }

    public static MobColor fromColorCode(int colorCode) {
        // Strip the alpha channel
        colorCode = colorCode & 0xFFFFFF;

        for (MobColor color : VALUES) {
            if (color.colorCode == colorCode) {
                return color;
            }
        }

        return WHITE;
    }

    public static MobColor fromBedrockID(int id) {
        for (MobColor color : VALUES) {
            if (color.bedrockID == id) {
                return color;
            }
        }

        return WHITE;
    }
}
