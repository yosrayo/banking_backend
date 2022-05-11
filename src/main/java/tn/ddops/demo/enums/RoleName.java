package tn.ddops.demo.enums;

import org.springframework.security.core.GrantedAuthority;

public enum RoleName implements GrantedAuthority {
	ADMIN, SUPERADMIN;

	@Override
	public String getAuthority() {
		return "ROLE_" + name();
	}
}
