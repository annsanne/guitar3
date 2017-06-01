package dao;

import java.util.List;

import entity.Guitar;
import entity.GuitarSpec;

public interface GuitarDao {

	List<Guitar> search(GuitarSpec spec);
	List<Guitar> show();
	public boolean add(Guitar guitar);
	public boolean delete(Guitar guitar);
}