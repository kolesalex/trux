package com.decaflabs.trux.platform;

import java.util.LinkedList;
import java.util.List;

import com.decaflabs.trux.platform.capsule.AbstractCapsule;
import com.decaflabs.trux.platform.capsule.Capsule;

public abstract class AbstractTrux extends AbstractPlatform {
	
	public static final double TRUX_WIDTH = 0.5d;
	
	protected List<Capsule> capsules = new LinkedList<Capsule>();
	
	public AbstractTrux(int team) {
		super(team);
	}
	
	@Override
	public void mutate(double delta) {
		for (Capsule capsule: this.capsules) {
			capsule.setX(this.x);
			capsule.setY(this.y);
		}
	}
	
	public void capture(Capsule capsule) {		
		this.capsules.add(capsule);
		capsule.setHost(this);
	}
	
	public void release(AbstractCapsule capsule) {
		if (this.capsules.remove(capsule)) {
			capsule.release();
		}
	}
	
}
