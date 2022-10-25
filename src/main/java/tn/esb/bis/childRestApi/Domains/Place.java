package tn.esb.bis.childRestApi.Domains;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    private String name;
    @NonNull
    private String address;
    private String notes;
    @NonNull
    @EqualsAndHashCode.Include
    private double longitude;
    @EqualsAndHashCode.Include
    private double latitude;
    @OneToMany(mappedBy ="taskPlace")
    private List<Task> tasks = new ArrayList<>();
}
