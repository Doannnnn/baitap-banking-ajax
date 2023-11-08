package com.example.baitap.service.Transfer;

import com.example.baitap.model.Customer;
import com.example.baitap.model.Transfer;
import com.example.baitap.repository.ITransferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransferService implements ITransferService{

    private ITransferRepository transferRepository;
    @Override
    public List<Transfer> findAll(boolean deleted) {
        return transferRepository.findAll();
    }

    @Override
    public List<Transfer> findAllById(Long id) {
        return transferRepository.findAll().stream().filter(transfer -> Objects.equals(transfer.getSender().getId(), id)).collect(Collectors.toList());
    }

    @Override
    public Optional<Transfer> findById(Long id) {
        return transferRepository.findById(id);
    }

    @Override
    public void create(Transfer transfer) {
        transfer.setDateTransfer(LocalDateTime.now());
        transferRepository.save(transfer);
    }

    @Override
    public void update(Long id, Transfer transfer) {

    }

    @Override
    public void removeById(Long id) {

    }
}
