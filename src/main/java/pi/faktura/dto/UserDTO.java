package pi.faktura.dto;

import pi.faktura.model.Role;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class UserDTO implements Serializable {

    private Long id;
    private String username;
    private String password;
    private CompanyDTO company;
    private Role role;
    private Set<ReceivingOrderDTO> receiving_orderDTOs =new HashSet<>();
    private Set<InvoiceDTO> invoiceDTOs =new HashSet<>();
    private Set<DispatchNoteDTO> dispatch_noteDTOs = new HashSet<>();
    private boolean deleted;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String password, CompanyDTO company, Role role, Set<ReceivingOrderDTO> receiving_orderDTOs, Set<InvoiceDTO> invoiceDTOs, Set<DispatchNoteDTO> dispatch_noteDTOs, boolean deleted) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.company = company;
        this.role = role;
        this.receiving_orderDTOs = receiving_orderDTOs;
        this.invoiceDTOs = invoiceDTOs;
        this.dispatch_noteDTOs = dispatch_noteDTOs;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<ReceivingOrderDTO> getReceiving_orderDTOs() {
        return receiving_orderDTOs;
    }

    public void setReceiving_orderDTOs(Set<ReceivingOrderDTO> receiving_orderDTOs) {
        this.receiving_orderDTOs = receiving_orderDTOs;
    }

    public Set<InvoiceDTO> getInvoiceDTOs() {
        return invoiceDTOs;
    }

    public void setInvoiceDTOs(Set<InvoiceDTO> invoiceDTOs) {
        this.invoiceDTOs = invoiceDTOs;
    }

    public Set<DispatchNoteDTO> getDispatch_noteDTOs() {
        return dispatch_noteDTOs;
    }

    public void setDispatch_noteDTOs(Set<DispatchNoteDTO> dispatch_noteDTOs) {
        this.dispatch_noteDTOs = dispatch_noteDTOs;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
