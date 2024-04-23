package com.AlexandreLoiola.AccessManagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name="tb_role")
public class RoleModel {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "description", length = 100, nullable = false, unique = true)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @Version
    @Column(name = "version", nullable = false)
    private long version;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name="tb_role_authorization",
            joinColumns = {@JoinColumn(name = "id_role", referencedColumnName = "id")},
            inverseJoinColumns = @JoinColumn(name = "id_authorization")
    )
    private Set<AuthorizationModel> authorizations = new HashSet<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "roles")
    private Set<UserModel> users = new HashSet<>();

    public void setId(UUID id) {
        this.id = UUID.fromString(id.toString());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleModel)) return false;
        RoleModel that = (RoleModel) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
