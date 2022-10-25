package tn.esb.bis.childRestApi.Domains;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    private String content;
    @EqualsAndHashCode.Include
    @NonNull
    private LocalDateTime dateTime;


    //la relation entre Message et Child (*-1)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "child_id", referencedColumnName = "id")
    private Child child;

}
