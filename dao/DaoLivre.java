package dao;

import classes.Livre;

public interface DaoLivre {

	public boolean addLivre(String titre, String auteur, int nombreDePages, String isbn);;

	public void getLivres();;

	public Livre searchForDocs(long id);;
}