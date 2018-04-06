package main.java.ProjectManagement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "developers_to_projects", schema = "public", catalog = "postgres")
@IdClass (DevelopersToProjectsEntityPK.class)
public class DevelopersToProjectsEntity {
    private int developerId;
    private int projectId;
    private DevelopersEntity developersByDeveloperId;
    private ProjectsEntity projectsByProjectId;

    @Id
    @Column (name = "developer_id", nullable = false)
    public int getDeveloperId()
    {
        return developerId;
    }

    public void setDeveloperId(int developerId)
    {
        this.developerId = developerId;
    }

    @Id
    @Column (name = "project_id", nullable = false)
    public int getProjectId()
    {
        return projectId;
    }

    public void setProjectId(int projectId)
    {
        this.projectId = projectId;
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
        DevelopersToProjectsEntity that = (DevelopersToProjectsEntity) o;
        return developerId == that.developerId &&
                projectId == that.projectId;
    }

    @Override
    public int hashCode()
    {

        return Objects.hash( developerId, projectId );
    }

    @ManyToOne
    @JoinColumn (name = "developer_id", referencedColumnName = "id", nullable = false)
    public DevelopersEntity getDevelopersByDeveloperId()
    {
        return developersByDeveloperId;
    }

    public void setDevelopersByDeveloperId(DevelopersEntity developersByDeveloperId)
    {
        this.developersByDeveloperId = developersByDeveloperId;
    }

    @ManyToOne
    @JoinColumn (name = "project_id", referencedColumnName = "id", nullable = false)
    public ProjectsEntity getProjectsByProjectId()
    {
        return projectsByProjectId;
    }

    public void setProjectsByProjectId(ProjectsEntity projectsByProjectId)
    {
        this.projectsByProjectId = projectsByProjectId;
    }
}
