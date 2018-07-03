package ru.yandex.sergaidm;

import java.util.List;

public interface FlatDAO {
	
	public void insert(Flat flat);
	
	public List<Flat> getFlatsList();
	
	public Flat getFlatByID(int id);	
	
	public List<Flat> getFlatsByRoomsNumber(int roomsNumber);
	
	public List<Flat> getFlatsByAddress(String address);
	
	public List<Flat> getFlatsByFloor(int floor);
	
	public List<Flat> getFlatsByPrice(double begin, double end, String currency);
    
    public void update(int id, String address, int roomsNumber, int floor, Price price);

    public void delete(int id);

}
