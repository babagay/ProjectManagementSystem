package main.java.ProjectManagement;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CompaniesToProjectsEntityPK implements Serializable {
    private int companyId;
    private int projectsId;

    @Column (name = "company_id", nullable = false)
    @Id
    public int getCompanyId()
    {
        return companyId;
    }

    public void setCompanyId(int companyId)
    {
        this.companyId = companyId;
    }

    @Column (name = "projects_id", nullable = false)
    @Id
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
        CompaniesToProjectsEntityPK that = (CompaniesToProjectsEntityPK) o;
        return companyId == that.companyId &&
                projectsId == that.projectsId;
    }

    @Override
    public int hashCode()
    {

        return Objects.hash( companyId, projectsId );
    }
}
