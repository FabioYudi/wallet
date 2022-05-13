package com.wallet.extrato.repository;

import com.wallet.extrato.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaldoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findByNumeroConta(String numeroConta);


}
