package Seminarska.superge;

import java.util.ArrayList;


public interface PodjetjaDao {
    public ArrayList<Podjetja> getAllPodjetja();
    public Podjetja getPodjetjaById(int id);
}
