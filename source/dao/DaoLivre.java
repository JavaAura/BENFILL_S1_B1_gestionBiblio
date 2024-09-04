package dao;

import java.time.LocalDate;

import classes.Livre;

public interface DaoLivre {

	public boolean addLivre(String titre, String auteur, int nombreDePages, String isbn, LocalDate time);;

	public Livre searchForDocs(long id);;
}