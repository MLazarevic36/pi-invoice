package pi.faktura.security;


import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.Documented;

@Documented
@AuthenticationPrincipal
public @interface CurrentUser {

}
