package net.emirikol.golemancy.network;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.networking.v1.*;
import net.minecraft.entity.*;
import net.minecraft.particle.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.registry.*;
import net.minecraft.server.network.*;
import net.minecraft.server.world.*;
import net.minecraft.client.*;

import java.util.*;

public class SpawnPacket {
	public static final Identifier SPAWN_PACKET_ID = new Identifier("golemancy", "spawn_packet");
	
	public static Packet<?> create(Entity e, Identifier packetID) {
		PacketByteBuf buf = PacketByteBufs.create();
		buf.writeVarInt(Registry.ENTITY_TYPE.getRawId(e.getType()));
		buf.writeUuid(e.getUuid());
		buf.writeVarInt(e.getEntityId());
		
		writeVec3d(buf, e.getPos());
		writeAngle(buf, e.pitch);
		writeAngle(buf, e.yaw);
		
		return ServerPlayNetworking.createS2CPacket(packetID, buf);
	}
	
	public static void writeVec3d(PacketByteBuf byteBuf, Vec3d vec3d) {
		byteBuf.writeDouble(vec3d.x);
		byteBuf.writeDouble(vec3d.y);
		byteBuf.writeDouble(vec3d.z);
	}
	
	public static Vec3d readVec3d(PacketByteBuf byteBuf) {
		double x = byteBuf.readDouble();
		double y = byteBuf.readDouble();
		double z = byteBuf.readDouble();
		return new Vec3d(x, y, z);
	}
	
	public static void writeAngle(PacketByteBuf byteBuf, float angle) {
		byteBuf.writeByte(packAngle(angle));
	}

	public static float readAngle(PacketByteBuf byteBuf) {
		return unpackAngle(byteBuf.readByte());
	}
	
	public static byte packAngle(float angle) {
		return (byte) MathHelper.floor(angle * 256 / 360);
	}


	public static float unpackAngle(byte angleByte) {
		return (angleByte * 360) / 256f;
	}
}