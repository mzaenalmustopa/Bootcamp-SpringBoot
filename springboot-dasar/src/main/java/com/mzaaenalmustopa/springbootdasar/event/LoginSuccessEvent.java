package com.mzaaenalmustopa.springbootdasar.event;

import com.mzaaenalmustopa.springbootdasar.data.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class LoginSuccessEvent extends ApplicationEvent {

    private final User user;

    public LoginSuccessEvent(User user) {
        super(user );
        this.user = user;
    }
}
