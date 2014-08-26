/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Session;

import Session.Session1.Infostud;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Алексей
 */
@Local
public interface SessionInterface {
    public String find();
    public List find1();
    public List find3();
    public List<Infostud> find2();
    public String[] find4();    
    public void insertGroup();
    public void insertStudent();
}
