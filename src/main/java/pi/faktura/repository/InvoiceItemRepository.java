package pi.faktura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.faktura.model.Invoice_item;

@Repository
public interface InvoiceItemRepository extends JpaRepository<Invoice_item, Long> {

}
