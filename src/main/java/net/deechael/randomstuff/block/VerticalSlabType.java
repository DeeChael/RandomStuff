package net.deechael.randomstuff.block;

import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum VerticalSlabType implements StringRepresentable {
    EAST("east", Direction.EAST),
    WEST("west", Direction.WEST),
    NORTH("north", Direction.NORTH),
    SOUTH("south", Direction.SOUTH),
    DOUBLE("double", Direction.EAST);

    private final String name;
    private final Direction direction;

    VerticalSlabType(String name, Direction direction) {
        this.name = name;
        this.direction = direction;
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static VerticalSlabType fromDirection(Direction direction) {
        return switch (direction) {
            case EAST -> EAST;
            case WEST -> WEST;
            case SOUTH -> SOUTH;
            case NORTH -> NORTH;
            default -> throw new RuntimeException("HOW!");
        };
    }

}
