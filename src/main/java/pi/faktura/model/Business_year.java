package pi.faktura.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "business_year")
public class Business_year implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_year_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "year", nullable = false, length = 4)
    private Integer year;

    @Column(name="start_date", nullable=false)
    private Date start_date;

    @Column(name="end_date", nullable=false)
    private Date end_date;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;

    @Column(name="finished", columnDefinition="BOOLEAN DEFAULT FALSE")
    private Boolean finished;

}
