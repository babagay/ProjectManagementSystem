package main.java.ProjectManagement;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table (name = "projects", schema = "public", catalog = "postgres")
public class ProjectsEntity {
    private long id;
    private String title;
    private BigInteger cost;
    private Collection<CompaniesToProjectsEntity> companiesToProjectsById;
    private Collection<CustomersToProjectsEntity> customersToProjectsById;
    private Collection<DevelopersToProjectsEntity> developersToProjectsById;

    @Id
    @Column (name = "id", nullable = false)
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @Basic
    @Column (name = "title", nullable = false, length = -1)
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @Basic
    @Column (name = "cost", nullable = true, precision = 0)
    public BigInteger getCost()
    {
        return cost;
    }

    public void setCost(BigInteger cost)
    {
        this.cost = cost;
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
        ProjectsEntity that = (ProjectsEntity) o;
        return id == that.id &&
                Objects.equals( title, that.title ) &&
                Objects.equals( cost, that.cost );
    }

    @Override
    public int hashCode()
    {

        return Objects.hash( id, title, cost );
    }

    @OneToMany (mappedBy = "projectsByProjectsId")
    public Collection<CompaniesToProjectsEntity> getCompaniesToProjectsById()
    {
        return companiesToProjectsById;
    }

    public void setCompaniesToProjectsById(Collection<CompaniesToProjectsEntity> companiesToProjectsById)
    {
        this.companiesToProjectsById = companiesToProjectsById;
    }

    @OneToMany (mappedBy = "projectsByProjectId")
    public Collection<CustomersToProjectsEntity> getCustomersToProjectsById()
    {
        return customersToProjectsById;
    }

    public void setCustomersToProjectsById(Collection<CustomersToProjectsEntity> customersToProjectsById)
    {
        this.customersToProjectsById = customersToProjectsById;
    }

    @OneToMany (mappedBy = "projectsByProjectId")
    public Collection<DevelopersToProjectsEntity> getDevelopersToProjectsById()
    {
        return developersToProjectsById;
    }

    public void setDevelopersToProjectsById(Collection<DevelopersToProjectsEntity> developersToProjectsById)
    {
        this.developersToProjectsById = developersToProjectsById;
    }
}
