package com.liu.covid.mapper;

import com.liu.covid.entity.User;
import com.liu.covid.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Transactional
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testCRUDOperations() {
        // Create
        User user1 = createUser("admin", "1234567", "人力资源部");
        userMapper.insert(user1);

        // Read
        User retrievedUser = userMapper.selectById(user1.getId());
        assertNotNull(retrievedUser);
        assertEquals(user1.getUsername(), retrievedUser.getUsername());

        // Update
        retrievedUser.setDepart("财务部");
        userMapper.updateById(retrievedUser);

        User updatedUser = userMapper.selectById(retrievedUser.getId());
        assertEquals("财务部", updatedUser.getDepart());

        // Delete
        userMapper.deleteById(updatedUser.getId());
        User deletedUser = userMapper.selectById(updatedUser.getId());
        assertNull(deletedUser);
    }



    private User createUser(String username, String password, String depart) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setDepart(depart);
        return user;
    }
}
