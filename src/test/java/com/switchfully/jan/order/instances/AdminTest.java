package com.switchfully.jan.order.instances;

import com.switchfully.jan.order.repositories.AdminRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
    @Test
    void givenAdminRepositoryWith1Admin_whenGetAdminList_thenListSizeIs1() {
        //given
        int expectedListSize = 1;
        //when
        AdminRepository adminRepository = new AdminRepository();
        //then
        assertEquals(expectedListSize,adminRepository.getAdmins().size());
    }
}