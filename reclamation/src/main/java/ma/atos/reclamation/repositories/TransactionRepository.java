package ma.atos.reclamation.repositories;

import ma.atos.reclamation.entites.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("select t from Transaction t where t.facture.reference=:refFacture")
    List<Transaction> findTransactionsByFacture(@Param("refFacture") String refFacture);
    Transaction findTransactionByReference(@Param("reference") String reference);
}
