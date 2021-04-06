package dao;
import jdbc.*;
import java.sql.*;

public abstract class DAO<T> {
    protected Connection connect = null; 
    protected int type = ResultSet.TYPE_SCROLL_INSENSITIVE;
    protected int mode = ResultSet.CONCUR_UPDATABLE;
    
    public DAO(Connection conn){ this.connect = conn; } 
    
    public abstract boolean create(T obj); 
    public abstract T read(int id);
    //public abstract T readS(String ch);
    public abstract boolean update(T obj); 
    public abstract boolean delete(T obj);

	
}