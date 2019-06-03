package com.xcq.original.dto;

import com.xcq.original.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class UUserDto extends User {


    private List<String> roleStrlist;
    private List<String> perminsStrlist;
}
