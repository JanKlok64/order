package com.switchfully.jan.order.repositories;

import com.switchfully.jan.order.instances.Address;
import com.switchfully.jan.order.instances.Admin;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AdminRepository {
    private final Map<String, Admin> admins = new HashMap<>();

    public AdminRepository() {
        Address address = new Address("Oudebaan", "191", "3000", "Leuven");
        Admin admin = new Admin("Jan", "Klok", "jan@klok.com", address, "0484246262");
        admins.put(admin.getId(), admin);
    }

    public Collection<Admin> getAdmins() {
        return new ArrayList<>(admins.values());
    }
}
