package dao;

import java.time.LocalDate;

import classes.Magazine;

public interface DaoMagazine {
	public boolean addMagazine(String titre, String auteur, int nombreDePages, int numero, LocalDate time);;

	public Magazine searchForDocs(long id);;
}
