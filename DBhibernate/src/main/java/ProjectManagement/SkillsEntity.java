package main.java.ProjectManagement;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table (name = "skills", schema = "public", catalog = "postgres")
public class SkillsEntity {
    private int id;
    private String title;
    private Collection<DevelopersToSkillsEntity> developersToSkillsById;

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
    @Column (name = "title", nullable = false, length = 50)
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
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
        SkillsEntity that = (SkillsEntity) o;
        return id == that.id &&
                Objects.equals( title, that.title );
    }

    @Override
    public int hashCode()
    {

        return Objects.hash( id, title );
    }

    @OneToMany (mappedBy = "skillsBySkillId")
    public Collection<DevelopersToSkillsEntity> getDevelopersToSkillsById()
    {
        return developersToSkillsById;
    }

    public void setDevelopersToSkillsById(Collection<DevelopersToSkillsEntity> developersToSkillsById)
    {
        this.developersToSkillsById = developersToSkillsById;
    }
}
