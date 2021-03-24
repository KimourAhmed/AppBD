package tables;

public class Photo {
    int idPhoto;
    String parametresRetouche;
    int idPage;
    int idTir;
    
    
    public Photo(int idPhoto, String parametresRetouche, int idPage, int idTir) {
        this.idPhoto = idPhoto;
        this.parametresRetouche = parametresRetouche;
        this.idPage = idPage;
        this.idTir = idTir;
    }
    
    public Photo() {
        
    }
    
    public int getIdPhoto() {
        return idPhoto;
    }
    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }
    public String getParametresRetouche() {
        return parametresRetouche;
    }
    public void setParametresRetouche(String parametresRetouche) {
        this.parametresRetouche = parametresRetouche;
    }
    public int getIdPage() {
        return idPage;
    }
    public void setIdPage(int idPage) {
        this.idPage = idPage;
    }
    public int getIdTir() {
        return idTir;
    }
    public void setIdTir(int idTir) {
        this.idTir = idTir;
    }
    
    
}