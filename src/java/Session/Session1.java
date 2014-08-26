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
import Entity.Groups;
import Entity.Groups1;
import Entity.Student;
import Entity.Student1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

@Stateless
public class Session1 implements SessionInterface {

    @PersistenceContext(unitName = "databasePU")
    private EntityManager em;

    public class Infostud {
        public String fio;
        public String group;
        public Long id;

        public String getFio() {
            return fio;
        }

        public void setFio(String fio) {
            this.fio = fio;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Infostud(String f,String g, Long i)
        {
            fio=f;
            group=g;
            id=i;
        }
    }

    public String find() {
        return "hfhfghdfghd";
    }

    public List find1() {
        Query q = em.createNamedQuery("Groups.findNames");
        List result = q.getResultList();
        //System.out.println(result.get(1));
        //System.out.println(result.get(1).getClass());
        return result;
    }

    public List find3() {
        Query q = em.createNamedQuery("Student.findAll");
        List result = q.getResultList();
        return result;
    }

    public List<Infostud> find2() {
        List<Infostud> arr=new ArrayList<>();
        List<Student1> stud=em.createQuery("SELECT s FROM Student1 s").getResultList();
        List<Groups1> gr=em.createQuery("SELECT g FROM Groups1 g").getResultList();
        for (Student1 s:stud)
        {
            for (Groups1 g:gr)
            {
                if (Objects.equals(s.getGroupId(), g.getGroupId())) {Infostud inf =new Infostud(s.getFIO(),g.getNum(),s.getStudentId()); arr.add(inf); break;}
            }
            
        }
        return arr;
    }
    public String[] find4() {
        //Long i=new Long(1);
        int i=0;
        String[] arr = new String[4];
        List<Student1> stud=em.createQuery("SELECT s FROM Student1 s").getResultList();
        for (Student1 s:stud)
        {
            arr[i]=s.getFIO();
            i++;
        }
        return arr;
    }

    public void insertGroup() {
        Groups g = new Groups();
        g.setFakult("sfgfdg");
        g.setGroupNum("121442");
        em.persist(g);
    }

    public void insertStudent() {
        Student1 s = new Student1();
        s.setFIO("test");
        //s.setGroupId(1);
        em.persist(s);
    }

}
