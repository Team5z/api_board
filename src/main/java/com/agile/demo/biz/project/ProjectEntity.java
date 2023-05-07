package com.agile.demo.biz.project;

import com.agile.demo.biz.backlog.BacklogEntity;
import com.agile.demo.biz.project.account.AccountProjectEntity;
import com.agile.demo.biz.task.TaskEntity;
import com.agile.demo.core.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "NProject")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProjectEntity extends BaseEntity {

    @Column(nullable = false, updatable = true, length = 100)
    private String title;

    @Column(nullable = true, updatable = true)
    private String assign;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project" , cascade = CascadeType.REMOVE) // project를 삭제하면 같이 삭제
    @JsonBackReference
    private List<BacklogEntity> backlogs;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project" , cascade = CascadeType.REMOVE) // project를 삭제하면 같이 삭제
    @JsonManagedReference
    private List<TaskEntity> tasks;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projects" , cascade = CascadeType.REMOVE) // project를 삭제하면 같이 삭제
    @JsonManagedReference
    private List<AccountProjectEntity> accountProjects;
}