package com.qhdn.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AccountDto {
    @NotEmpty
    @Size(min = 4, message = "Tên tài khoản ít nhất 4 kí tự!!")
    String username;
    @NotEmpty(message = "Mật khẩu không được để trống")
    @Size(min = 3, max = 10, message = "Mật khẩu phải từ 3 đến 10 kí tự!!")
    String password;
    String fullName;
    @Email(message = "Email không đúng!!")
    String email;
    String photo;
}
