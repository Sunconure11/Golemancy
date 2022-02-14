package net.emirikol.golemancy.test;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public abstract class AbstractTestSuite {
    private World world;
    private PlayerEntity player;

    public AbstractTestSuite(World world, PlayerEntity player) {
        this.world = world;
        this.player = player;
    }

    public void invokeTest() {
        try {
            this.test();
        } catch (Exception e) {
            String msg = e.getMessage();
            this.printMessage(msg);
        }
    }

    public abstract void test();

    public void printMessage(String msg) {
        System.out.println(msg);
        if (!this.world.isClient) this.player.sendMessage(new LiteralText(msg), false);
    }

    public World getWorld() { return this.world; }
    public PlayerEntity getPlayer() { return player; }

    public BlockPos getRandomBlockPos() {
        Random rand = this.world.getRandom();
        int distance = rand.nextInt(10) + 1;
        int direction = rand.nextInt(4);
        switch (direction) {
            case 0:
                return this.player.getBlockPos().north(distance);
            case 1:
                return this.player.getBlockPos().west(distance);
            case 2:
                return this.player.getBlockPos().east(distance);
            case 3:
                return this.player.getBlockPos().south(distance);
        }
        return this.player.getBlockPos();
    }
}
