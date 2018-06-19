/**
 * 
 */
package com.hong.Dao;

import java.util.List;
import java.util.Vector;

import com.hong.bean.Apartment;


/**
 * @author Abbey
 *
 */
public interface ApartmentDao {
	public void insertApartment(Apartment apartment);
	public void deleteApartment(int id);
	public void updateApartment(Apartment apartment);
	public Apartment findApartmentByCode(String code);
	public List<Apartment> findAllApartment();
	public List<Apartment> findApartmentByAnything(String anything);
	public Vector findApartmentCode();
	public void updateApartmentByCode(Apartment apartment);
	public Apartment findApartmentById(int id);
}
