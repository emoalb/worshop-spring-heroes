package com.softuni.worshopspringheroes.services.services.implementations;

import com.softuni.worshopspringheroes.services.services.HashingService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class HashingServiceImpl  implements HashingService {


    @Override
    public String hash(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
