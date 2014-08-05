/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Session;

/**
 *
 * @author Алексей
 */
import java.util.List;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Stateless
public class Session1 implements SessionInterface{
    @PersistenceContext(unitName = "databasePU")
    private EntityManager em;
    
    public String find()
    {
        return "hfhfghdfghd";
    }
    public List find1()
    {
        Query q=em.createNamedQuery("Groups.findNames");
        List result=q.getResultList();
        return result;
    }
    
    public List find3()
    {
        Query q=em.createNamedQuery("Groups.findNames");
        List result=q.getResultList();
        return result;
    }
    
    public List find2()
    {
        List result;
        List students=find1();
        Query q=em.createNamedQuery("Groups.findAll");
        List groups=q.getResultList();
        
        result=groups;
        return result;
    }

}
