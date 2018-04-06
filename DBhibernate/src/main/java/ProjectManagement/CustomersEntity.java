package main.java.ProjectManagement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "customers", schema = "public", catalog = "postgres")
public class CustomersEntity {
    private int id;
    private String name;
    private String biz;

    @Id
    @Column (name = "id", nullable = false)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
    @Column (name = "name", nullable = false, length = -1)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column (name = "biz", nullable = false, length = -1)
    public String getBiz()
    {
        return biz;
    }

    public void setBiz(String biz)
    {
        this.biz = biz;
    }

    @Override
    public boolean equals(Object o)
    {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        CustomersEntity that = (CustomersEntity) o;
        return id == that.id &&
                Objects.equals( name, that.name ) &&
                Objects.equals( biz, that.biz );
    }

    @Override
    public int hashCode()
    {

        return Objects.hash( id, name, biz );
    }
}
