package Seminarska.superge;

import java.util.ArrayList;

public interface SupergeDao {
    public ArrayList<Superge> getAllSuperge();
    public ArrayList<Superge> getAllByIDPodjetja(int idPodjetja);
    public Superge getSupergeById(int id);
    public void insertSuperge(Superge sup);
    public void updateSuperge(Superge sup);
    public void deleteSuperge(int id);
}
