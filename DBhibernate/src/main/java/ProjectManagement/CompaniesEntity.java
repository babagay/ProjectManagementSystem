package main.java.ProjectManagement;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table (name = "companies", schema = "public", catalog = "postgres")
public class CompaniesEntity {
    private int id;
    private String name;
    private Collection<CompaniesToProjectsEntity> companiesToProjectsById;

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

    @Override
    public boolean equals(Object o)
    {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        CompaniesEntity that = (CompaniesEntity) o;
        return id == that.id &&
                Objects.equals( name, that.name );
    }

    @Override
    public int hashCode()
    {

        return Objects.hash( id, name );
    }

    @OneToMany (mappedBy = "companiesByCompanyId")
    public Collection<CompaniesToProjectsEntity> getCompaniesToProjectsById()
    {
        return companiesToProjectsById;
    }

    public void setCompaniesToProjectsById(Collection<CompaniesToProjectsEntity> companiesToProjectsById)
    {
        this.companiesToProjectsById = companiesToProjectsById;
    }
}
