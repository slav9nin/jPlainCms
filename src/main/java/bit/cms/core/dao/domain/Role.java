package bit.cms.core.dao.domain;

/**
 * @author Artem.Telizhenko
 *         Date: 13.11.2014
 *         Time: 17:40
 */
public class Role implements Id {
    private static final long serialVersionUID = -4125465682416247203L;

    private Long id;
    private String roleName;
    private boolean isActive;
    private boolean isAdmin;

    public Role(Long id) {
        this.id = id;
    }

    public Role() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return !(id != null ? !id.equals(role.id) : role.id != null);

    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", isActive=" + isActive +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
