package Seminarska.superge;


public class Superge {
    protected int id;
    protected String model;
    protected String sport;
    protected int velikost;
    protected int cena;
    protected int leto;
    protected int idPodjetja;

    public Superge() {
    }

    public Superge(String model, String sport, int velikost, int cena, int leto, int idPodjetja) {
        this.model = model;
        this.sport = sport;
        this.velikost = velikost;
        this.cena = cena;
        this.leto = leto;
        this.idPodjetja = idPodjetja;
    }

    public Superge(int id, String model, String sport, int velikost, int cena, int leto, int idPodjetja) {
        this.id = id;
        this.model = model;
        this.sport = sport;
        this.velikost = velikost;
        this.cena = cena;
        this.leto = leto;
        this.idPodjetja = idPodjetja;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getSport() {
        return sport;
    }

    public int getVelikost() {
        return velikost;
    }

    public int getCena() {
        return cena;
    }

    public int getLeto() {
        return leto;
    }

    public int getIdPodjetja() {
        return idPodjetja;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setVelikost(int velikost) {
        this.velikost = velikost;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setLeto(int leto) {
        this.leto = leto;
    }

    public void setIdPodjetja(int idPodjetja) {
        this.idPodjetja = idPodjetja;
    }

    @Override
    public String toString() {
        return "Superge{" + "id=" + id + ", model=" + model + ", sport=" + sport + ", velikost=" + velikost + ", cena=" + cena + ", leto=" + leto + ", idPodjetja=" + idPodjetja + '}';
    }
    
    
    
    
}
