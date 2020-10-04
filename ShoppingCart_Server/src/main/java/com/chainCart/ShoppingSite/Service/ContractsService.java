package com.SandhyaJoshi.ShoppingSite.Service;

import com.SandhyaJoshi.ShoppingSite.Model.Contracts;

import java.util.List;

public interface ContractsService {
    Contracts saveContracts(Contracts contracts);
    List<Contracts> findByUserID(int user_id);
}
