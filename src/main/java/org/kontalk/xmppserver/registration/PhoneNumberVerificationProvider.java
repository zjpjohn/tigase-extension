/*
 * Kontalk XMPP Tigase extension
 * Copyright (C) 2015 Kontalk Devteam <devteam@kontalk.org>

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

package org.kontalk.xmppserver.registration;

import tigase.db.TigaseDBException;
import tigase.xmpp.XMPPResourceConnection;

import java.io.IOException;
import java.util.Map;


/**
 * An interface for phone number verification providers.
 * @author Daniele Ricci
 */
public interface PhoneNumberVerificationProvider {

    /** Challenge the user with a verification PIN sent through a SMS or a told through a phone call. */
    public static final String CHALLENGE_PIN = "pin";
    /** Challenge the user with a missed call from a random number and making the user guess the digits. */
    public static final String CHALLENGE_MISSED_CALL = "missedcall";
    /** Challenge the user with the caller ID presented in a user-initiated call to a given phone number. */
    public static final String CHALLENGE_CALLER_ID = "callerid";

    public void init(Map<String, Object> settings) throws TigaseDBException;

    public String getSenderId();

    public String getAckInstructions();

    /**
     * Initiates a verification.
     * @param phoneNumber the phone number being verified
     * @return a request object of some kind that you will give to {@link #endVerification}.
     */
    public RegistrationRequest startVerification(String domain, String phoneNumber)
            throws IOException, VerificationRepository.AlreadyRegisteredException, TigaseDBException;

    /**
     * Ends a verification.
     * @param request request object as returned by {@link #startVerification}
     * @param proof the proof of the verification (e.g. verification code)
     * @return true if verification succeded, false otherwise.
     */
    public boolean endVerification(XMPPResourceConnection session, RegistrationRequest request, String proof) throws IOException, TigaseDBException;

    /** Returns true if this provider supports this kind if registration request. */
    public boolean supportsRequest(RegistrationRequest request);

    public String getChallengeType();

}
