package tech.mcwhirl.events;

import com.darkmagician6.eventapi.events.Cancellable;
import com.darkmagician6.eventapi.events.Event;

import net.minecraft.network.Packet;

public class EventSentPacket implements Event, Cancellable {
	
	private Packet packet;
	private boolean cancel;
	
	public EventSentPacket(final Packet packet) {
		this.packet = packet;
	}
	
	public Packet getPacket() {
		return packet;
	}
	
	public void setPacket(Packet packet) {
		this.packet = packet;
	}

	@Override
	public boolean isCancelled() {
		return this.cancel;
	}

	@Override
	public void setCancelled(final boolean cancel) {
		this.cancel = cancel;
	}

}
