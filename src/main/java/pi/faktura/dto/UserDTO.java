package pi.faktura.dto;

import lombok.NoArgsConstructor;
import pi.faktura.model.Dispatch_note;
import pi.faktura.model.Role;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
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


}
