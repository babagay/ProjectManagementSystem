package main.java.ProjectManagement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "companies_to_projects", schema = "public", catalog = "postgres")
@IdClass (CompaniesToProjectsEntityPK.class)
public class CompaniesToProjectsEntity {
    private int companyId;
    private int projectsId;
    private CompaniesEntity companiesByCompanyId;
    private ProjectsEntity projectsByProjectsId;

    @Id
    @Column (name = "company_id", nullable = false)
    public int getCompanyId()
    {
        return companyId;
    }

    public void setCompanyId(int companyId)
    {
        this.companyId = companyId;
    }

    @Id
    @Column (name = "projects_id", nullable = false)
    public int getProjectsId()
    {
        return projectsId;
    }

    public void setProjectsId(int projectsId)
    {
        this.projectsId = projectsId;
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
        CompaniesToProjectsEntity that = (CompaniesToProjectsEntity) o;
        return companyId == that.companyId &&
                projectsId == that.projectsId;
    }

    @Override
    public int hashCode()
    {

        return Objects.hash( companyId, projectsId );
    }

    @ManyToOne
    @JoinColumn (name = "company_id", referencedColumnName = "id", nullable = false)
    public CompaniesEntity getCompaniesByCompanyId()
    {
        return companiesByCompanyId;
    }

    public void setCompaniesByCompanyId(CompaniesEntity companiesByCompanyId)
    {
        this.companiesByCompanyId = companiesByCompanyId;
    }

    @ManyToOne
    @JoinColumn (name = "projects_id", referencedColumnName = "id", nullable = false)
    public ProjectsEntity getProjectsByProjectsId()
    {
        return projectsByProjectsId;
    }

    public void setProjectsByProjectsId(ProjectsEntity projectsByProjectsId)
    {
        this.projectsByProjectsId = projectsByProjectsId;
    }
}
