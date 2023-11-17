
package Seminarska.superge;

import java.util.ArrayList;

public class TestSuperge {
    
    public static void main(String[] args) {
        Superge sup = new Superge();
        SupergeDaoImpl SupergeDao = new SupergeDaoImpl();
        PodjetjaDaoImpl PodjetjaDao = new PodjetjaDaoImpl();
        
        sup = new Superge(3, "Messi10", "nogomet", 40, 140, 2022, 4);
        SupergeDao.insertSuperge(sup);
        
        System.out.println("\nSeznam superg");
        ArrayList<Superge> superge = SupergeDao.getAllSuperge();
        
        for (Superge sp : superge) {
            Podjetja pod = PodjetjaDao.getPodjetjaById(sp.getIdPodjetja());
            System.out.println(sp.toString() + ", " + pod.getNaziv());
        }
    }

}
