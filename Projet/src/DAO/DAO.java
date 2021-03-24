package DAO;
import java.sql.*;

public abstract class DAO<T> {

 
	
	//public Connection connect = ConnectionPostgreSQL.getInstance();
	protected Connection connect = null;
	public DAO(Connection conn){
	this.connect = conn; }
    
    /**
     * Permet de r�cup�rer un objet via son ID
     * @param id
     * @return
     */
    public abstract T read(int id);
    
    /**
     * Permet de cr�er une entr�e dans la base de donn�es
     * par rapport � un objet
     * @param obj
     */
    public abstract boolean create(T obj);
    
    /**
     * Permet de mettre � jour les donn�es d'une entr�e dans la base 
     * @param obj
     */
    public abstract T update(T obj);
    
    /**
     * Permet la suppression d'une entr�e de la base
     * @param obj
     */
    public abstract void delete(T obj);
}