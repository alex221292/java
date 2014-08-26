/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Алексей
 */
@Entity
@Table(name = "groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g"),
    @NamedQuery(name = "Groups.findByGroupId", query = "SELECT g FROM Groups g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "Groups.findByGroupNum", query = "SELECT g FROM Groups g WHERE g.groupNum = :groupNum"),
    @NamedQuery(name = "Groups.findByFakult", query = "SELECT g FROM Groups g WHERE g.fakult = :fakult"),
    @NamedQuery(name = "Student.findNames", query = "SELECT g.groupNum FROM Groups g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "Groups.findNames", query = "SELECT g.groupNum, s.fio, s.studentPK.studentId FROM Groups g, Student s WHERE s.studentPK.groupId=g.groupId")})
public class Groups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "groupId")
    private Integer groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "groupNum")
    private String groupNum;
    @Size(max = 20)
    @Column(name = "fakult")
    private String fakult;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groups")
    private Collection<Student> studentCollection;

    public Groups() {
    }

    public Groups(Integer groupId) {
        this.groupId = groupId;
    }

    public Groups(Integer groupId, String groupNum) {
        this.groupId = groupId;
        this.groupNum = groupNum;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }

    public String getFakult() {
        return fakult;
    }

    public void setFakult(String fakult) {
        this.fakult = fakult;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.groupNum;//"Entity.Groups[ groupId=" + groupId + " ]";
    }
    
}
