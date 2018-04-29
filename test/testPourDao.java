
import com.serviceannuaire.models.Connexion;
import com.serviceannuaire.models.Succursale;
import com.serviceannuaire.models.SuccursaleDao;
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PadgetPi
 */
public class testPourDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection connection = Connexion.getInstance();
        SuccursaleDao dao = new SuccursaleDao(connection);
        Succursale s = new Succursale();
       /s.setDescription("deeeeeeee");
        s.setLattitude();
        s.setLongitude(45,540974);
        s.setNoEntrepriseQuebec(1111111111);
        Succursale succes = dao.CreateOrUpdtate(s);
       
       // System.out.println(succes);
    }
    
}
