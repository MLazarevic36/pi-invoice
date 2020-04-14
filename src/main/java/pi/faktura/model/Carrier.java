package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "carriers")
public class Carrier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrier_id", unique = true, nullable = false)
    private Long id;

    @Column(name="name", unique=false, nullable=false, length = 50)
    private String name;

    @OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "carrier")
    private Set<Dispatch_note> dispatch_notes = new HashSet<Dispatch_note>();

    @Column(name="deleted", columnDefinition="BOOLEAN DEFAULT FALSE")
    private Boolean deleted;

}
