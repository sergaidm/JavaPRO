package ru.yandex.sergaidm;

import java.util.List;

public interface FlatDAO {
	
	public void insert(Flat flat);
	
	public List<Flat> getFlatsList();
	
	public Flat getFlatByID(int value);	
	
	public List<Flat> getFlatsByRoomsNumber(int roomsNumber);
	
	public List<Flat> getFlatsByAddress(String address);
	
	public List<Flat> getFlatsByFloor(int floor);
	
	public List<Flat> getFlatsByPrice(double begin, double end, String currency);
    
    public void update(Flat flat);

    public void delete(int id);

}
