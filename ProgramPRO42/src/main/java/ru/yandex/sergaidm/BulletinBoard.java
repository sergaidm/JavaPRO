package ru.yandex.sergaidm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BulletinBoard implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Bulletin> bulletins = new ArrayList<Bulletin>();

	public BulletinBoard(List<Bulletin> bulletins) {
		super();
		this.bulletins = bulletins;
	}

	public BulletinBoard() {
		super();
	}

	public void addBulletin(Bulletin bulletin) {
		bulletins.add(bulletin);		
	}

	public List<Bulletin> getBulletins() {
		return bulletins;
	}

}
