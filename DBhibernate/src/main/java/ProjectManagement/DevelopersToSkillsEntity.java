package main.java.ProjectManagement;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "developers_to_skills", schema = "public", catalog = "postgres")
@IdClass (DevelopersToSkillsEntityPK.class)
public class DevelopersToSkillsEntity {
    private int developerId;
    private int skillId;
    private DevelopersEntity developersByDeveloperId;
    private SkillsEntity skillsBySkillId;

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
    @Column (name = "skill_id", nullable = false)
    public int getSkillId()
    {
        return skillId;
    }

    public void setSkillId(int skillId)
    {
        this.skillId = skillId;
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
        DevelopersToSkillsEntity that = (DevelopersToSkillsEntity) o;
        return developerId == that.developerId &&
                skillId == that.skillId;
    }

    @Override
    public int hashCode()
    {

        return Objects.hash( developerId, skillId );
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
    @JoinColumn (name = "skill_id", referencedColumnName = "id", nullable = false)
    public SkillsEntity getSkillsBySkillId()
    {
        return skillsBySkillId;
    }

    public void setSkillsBySkillId(SkillsEntity skillsBySkillId)
    {
        this.skillsBySkillId = skillsBySkillId;
    }
}
