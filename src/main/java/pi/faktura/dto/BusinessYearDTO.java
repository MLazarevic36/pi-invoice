package pi.faktura.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.faktura.model.Business_year;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BusinessYearDTO implements Serializable {

    private Long id;
    private Integer year;
    private Date start_date;
    private Date end_date;
    private CompanyDTO company;
    private Boolean finished;

    public BusinessYearDTO(Long id, Integer year, Date start_date, Date end_date, CompanyDTO company, Boolean finished) {
        this.id = id;
        this.year = year;
        this.start_date = start_date;
        this.end_date = end_date;
        this.company = company;
        this.finished = finished;
    }

    public BusinessYearDTO(Business_year b) {
        this(b.getId(), b.getYear(), b.getStart_date(), b.getEnd_date(), new CompanyDTO(b.getCompany()),
                b.getFinished());
    }


}
