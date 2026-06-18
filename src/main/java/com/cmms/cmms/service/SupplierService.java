package com.cmms.cmms.service;

import com.cmms.cmms.entity.Supplier;
import com.cmms.cmms.entity.Purchase;
import com.cmms.cmms.repository.SupplierRepository;
import com.cmms.cmms.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepo;

    @Autowired
    private PurchaseRepository purchaseRepo;

    // Supplier methods
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }
    public Supplier getSupplierById(Long id) {

        return supplierRepo
                .findById(id)
                .orElse(null);
    }

    // Purchase methods
    public Purchase savePurchase(Purchase purchase) {
        return purchaseRepo.save(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepo.findAll();
    }
}