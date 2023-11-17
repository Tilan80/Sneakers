package Seminarska.superge;

public class Podjetja {
    protected int id;
    protected String naziv;

    public Podjetja() {
    }
    
    

    public Podjetja(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public Podjetja(String naziv) {
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    
}
