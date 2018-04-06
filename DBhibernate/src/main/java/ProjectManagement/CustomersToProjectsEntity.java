package main.java.ProjectManagement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "customers_to_projects", schema = "public", catalog = "postgres")
@IdClass (CustomersToProjectsEntityPK.class)
public class CustomersToProjectsEntity {
    private int customerId;
    private int projectId;
    private CustomersEntity customersByCustomerId;
    private ProjectsEntity projectsByProjectId;

    @Id
    @Column (name = "customer_id", nullable = false)
    public int getCustomerId()
    {
        return customerId;
    }

    public void setCustomerId(int customerId)
    {
        this.customerId = customerId;
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
        CustomersToProjectsEntity that = (CustomersToProjectsEntity) o;
        return customerId == that.customerId &&
                projectId == that.projectId;
    }

    @Override
    public int hashCode()
    {

        return Objects.hash( customerId, projectId );
    }

    @ManyToOne
    @JoinColumn (name = "customer_id", referencedColumnName = "id", nullable = false)
    public CustomersEntity getCustomersByCustomerId()
    {
        return customersByCustomerId;
    }

    public void setCustomersByCustomerId(CustomersEntity customersByCustomerId)
    {
        this.customersByCustomerId = customersByCustomerId;
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
