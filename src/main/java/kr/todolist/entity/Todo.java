package kr.todolist.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@DynamicUpdate
@Table(name = "TODOS")
@Getter
@Setter
@ToString(exclude = "todoRefers")
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(updatable = false)
  private int id;

  @Column(columnDefinition = "text")
  private String title;


  @CreationTimestamp
  @Column(columnDefinition = "timestamp", updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(columnDefinition = "timestamp")
  private LocalDateTime updatedAt;

  @Column(columnDefinition = "timestamp")
  private LocalDateTime completedAt;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "todo")
  private List<TodoRefer> todoRefers;
}