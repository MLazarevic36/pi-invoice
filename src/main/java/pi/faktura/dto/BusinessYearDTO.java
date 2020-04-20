package pi.faktura.dto;



import java.io.Serializable;
import java.util.Date;


public class BusinessYearDTO implements Serializable {

    private Long id;
    private Integer year;
    private Date start_date;
    private Date end_date;
    private CompanyDTO company;
    private Boolean finished;

    public BusinessYearDTO() {
    }

    public BusinessYearDTO(Long id, Integer year, Date start_date, Date end_date, CompanyDTO company, Boolean finished) {
        this.id = id;
        this.year = year;
        this.start_date = start_date;
        this.end_date = end_date;
        this.company = company;
        this.finished = finished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}
