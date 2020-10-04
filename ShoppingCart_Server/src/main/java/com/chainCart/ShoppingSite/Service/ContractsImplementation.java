package com.SandhyaJoshi.ShoppingSite.Service;

import com.SandhyaJoshi.ShoppingSite.Model.Contracts;
import com.SandhyaJoshi.ShoppingSite.Repository.ContractsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContractsImplementation implements ContractsService {

    @Autowired
    ContractsRepository contractsRepository;

    @Override
    public Contracts saveContracts(Contracts contracts){
        return contractsRepository.save(contracts);
    }

    @Override
    public List<Contracts> findByUserID(final int user_id){
        return contractsRepository.findByUserID(user_id);
    }
}
