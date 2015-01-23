/*
 * Kontalk XMPP Tigase extension
 * Copyright (C) 2014 Kontalk Devteam <devteam@kontalk.org>

 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.kontalk.xmppserver.auth;

import javax.security.auth.callback.CallbackHandler;
import java.util.Map;


/**
 * SASL mechanism for Kontalk authentication tokens with PLAIN.
 * @author Daniele Ricci
 */
public class SaslKontalkPlainToken extends SaslKontalkToken {

    public static final String MECHANISM = "PLAIN";

    SaslKontalkPlainToken(Map<? super String, ?> props, CallbackHandler callbackHandler) {
        super(props, callbackHandler);
    }

    @Override
    public String getMechanismName() {
        return MECHANISM;
    }

}
